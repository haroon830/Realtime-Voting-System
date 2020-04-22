package rts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    protected ServerSocket server;
    protected Socket connection;


    public static void main(String[] args) {
        new Server().startRunning();
    }
    public static final int PORT = 6789;
    public void startRunning() {
        System.out.println("Running Server");
        try {
                server = null;
                server = new ServerSocket(PORT);
                server.setSoTimeout(0);
                System.out.println("Waiting for client to request");
                connection = server.accept();
                System.out.println("Connected");
                new ServerThread(connection).run();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }



}
