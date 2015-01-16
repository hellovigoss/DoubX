import args.HelloArgs;
import client.RpcClient;

/**
 * Created by yedai on 15-1-14.
 */
public class Main {
    public static void main(String argv[]) throws Exception {
        RpcClient rpcClient = new RpcClient("127.0.0.1", 12345);
        HelloArgs args = new HelloArgs();
        args.name = "yedai";
        args.words = "a";
        System.out.println(rpcClient.call("Hello", args, String.class));
    }

}
