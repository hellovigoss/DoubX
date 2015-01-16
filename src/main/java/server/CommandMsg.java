package server;

import org.msgpack.annotation.MessagePackMessage;

import java.util.List;

/**
 * Created by yedai on 15-1-14.
 */
@MessagePackMessage
public final class CommandMsg {
    public String dst;
    public byte[] args;
}
