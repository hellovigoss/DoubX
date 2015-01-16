package server;

import api.Api;
import org.msgpack.MessagePack;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yedai on 15-1-15.
 */
public class RpcServer <T>{

    public static void main(String argv[]){
        ServerSocket server = null;
        try {
            server = new ServerSocket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 12345);
            server.bind(inetSocketAddress);
            while(true){
                Socket socket = server.accept();
                Thread t = new Thread(new Workder(socket));
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
