package EchoServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {

        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        String reply;

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server started, waiting for connection...");
            socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String str = in.readUTF();
                System.out.println(str);
                reply = scanner.next();
                out.writeUTF(reply);
                if (str.equals("/end")) {
                    break;
                }
                //out.writeUTF("Echo: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         }
}
