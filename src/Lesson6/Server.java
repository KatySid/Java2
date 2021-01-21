package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static ServerSocket server;
    static Socket socket;
    static final int PORT =8189;


    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("server started");
            socket = server.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            DataOutputStream out2 = new DataOutputStream(socket.getOutputStream());

            new Thread(()->{
                Scanner scan = new Scanner(System.in);
                while (true){
                    String str = scan.nextLine();
                    try {
                        out2.writeUTF("server :" + str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            while (true){

                String str = in.readUTF();
                if (str.equals("/end")){
                    System.out.println("Client disconnected");
                    break;
                }
                System.out.println("Client: " + str);
                out2.writeUTF("server :" + str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
