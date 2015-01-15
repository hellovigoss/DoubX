import api.Api;
import args.HelloArgs;
import message.CallMessage;
import org.msgpack.MessagePack;

/**
 * Created by yedai on 15-1-14.
 */
public class Main {
    public static void main(String argv[]) throws Exception {
        Parser parser = new Parser();
        CallMessage callMessage = new CallMessage();
        callMessage.dst = "Hello";
        HelloArgs args = new HelloArgs();
        args.name = "yedai";
        args.words = "helloworld";
        callMessage.args = MessagePack.pack(args);
        byte[] raw = MessagePack.pack(callMessage);

        CallMessage message = parser.call(raw);
        Api api = (Api) Class.forName("api." + message.dst).newInstance();
        System.out.println(api.run(message.args));

    }

}
