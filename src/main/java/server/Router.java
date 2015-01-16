package server;

import api.Api;
import org.msgpack.MessagePack;

/**
 * Created by yedai on 15-1-16.
 */
public class Router {
    public byte[] dispatch(byte[] raw) throws Exception {
        MessagePack mp = new MessagePack();
        CommandMsg message = mp.read(raw, CommandMsg.class);
        Api api = (Api) Class.forName("api." + message.dst).newInstance();
        return mp.write(api.run(message.args));
    }
}
