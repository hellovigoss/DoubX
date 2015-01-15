package message;

import org.msgpack.annotation.MessagePackMessage;

import java.util.List;

/**
 * Created by yedai on 15-1-14.
 */
@MessagePackMessage
public final class CallMessage {
    public String dst;
    public byte[] args;
}
