package args;

import org.msgpack.annotation.MessagePackMessage;

/**
 * Created by yedai on 15-1-15.
 */
@MessagePackMessage
public class HelloArgs {
    public String name;
    public String words;
}
