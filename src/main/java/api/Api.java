package api;

import org.msgpack.MessagePack;

import java.io.IOException;

/**
 * Created by yedai on 15-1-14.
 */

public abstract class Api<T> {

    protected T args;
    public T run(byte[] raw) throws ClassNotFoundException, IOException {
        MessagePack mp = new MessagePack();
        String argsClassName = this.getClass().getName().replaceAll("api", "args") + "Args";
        this.args = (T) mp.read(raw, Class.forName(argsClassName));
        return (T) this.render(this.work());
    }

    protected abstract T work();

    protected T render(T workResult){

        return workResult;

    }
}
