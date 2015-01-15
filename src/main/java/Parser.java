import message.CallMessage;
import org.msgpack.MessagePack;

import java.io.IOException;

/**
 * Created by yedai on 15-1-14.
 */
public class Parser {

    private MessagePack messagePack = new MessagePack();

    public CallMessage call(byte[] raw) throws IOException {
        CallMessage callMessage = MessagePack.unpack(raw, CallMessage.class);
        return callMessage;
    }
}
