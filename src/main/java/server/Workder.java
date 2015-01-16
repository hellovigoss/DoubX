package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by yedai on 15-1-15.
 */
public class Workder implements Runnable {

    private Socket socket;

    public Workder(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        byte[] bytes = new byte[128];
        try {
            InputStream input = this.socket.getInputStream();
            input.read(bytes);
            RpcServer rpcServer = new RpcServer();
            try {
                System.out.println("new thread "+ Thread.currentThread().getId() + " init");
                byte[] outbytes = rpcServer.callback(bytes);
                OutputStream output = this.socket.getOutputStream();
                output.write(outbytes);
                output.flush();
                output.close();
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
