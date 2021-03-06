package Main;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8000;

    public static void main(String[] arg) throws Exception {
        int c = 1;
        ServerSocket server = new ServerSocket(PORT);
        while (c <= 4) {
            System.out.println("[SERVER] Awaiting connection...");
            Socket connection = server.accept();
            System.out.println("[SERVER] Connected to client");
            Thread t = new ClientHandler(connection);
            t.start();
            c++;
        }


        System.out.println("[SERVER] Shutting down...");
        server.close();
    }
}
