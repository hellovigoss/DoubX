package server;

import api.Api;
import message.CallMessage;
import org.msgpack.MessagePack;

/**
 * Created by yedai on 15-1-15.
 */
public class RpcServer <T>{
    public byte[] callback(byte[] raw) throws Exception {
        MessagePack mp = new MessagePack();
        CallMessage message = mp.read(raw, CallMessage.class);
        Api api = (Api) Class.forName("api." + message.dst).newInstance();
        return mp.write(api.run(message.args));
    }
}
