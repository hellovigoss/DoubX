package client;

import javassist.bytecode.ByteArray;
import message.CallMessage;
import org.msgpack.MessagePack;
import sun.nio.ByteBuffered;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

/**
 * Created by yedai on 15-1-15.
 */
public class RpcClient<T> {

    private Socket socket;

    public RpcClient(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
    }

    public Object call(String dst, T args, Class type) throws Exception{
        MessagePack mp = new MessagePack();
        CallMessage cm = new CallMessage();
        cm.dst = dst;
        cm.args = mp.write(args);

        byte[] raw = mp.write(cm);
        OutputStream output = this.socket.getOutputStream();
        output.write(raw);
        output.flush();
        InputStream input = this.socket.getInputStream();
        byte[] in = new byte[128];
        input.read(in, 0, 128);
        output.close();
        input.close();
        this.socket.close();
        return mp.read(in, type);
    }
}
