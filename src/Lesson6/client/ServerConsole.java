package Lesson6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerConsole {
    static Socket clientSocket;
    static final int PORT =8189;


    public static void main(String[] args) {

        clientSocket = null;
        Scanner scanner = new Scanner(System.in);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("server started");
            clientSocket = server.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out2 = new DataOutputStream(clientSocket.getOutputStream());

           Thread read = new Thread(()-> {
               try {
                   while (true) {
                       out2.writeUTF(scanner.nextLine());
                   }
               }catch (IOException e) {
                       e.printStackTrace();
                   }
           });
           read.setDaemon(true);
           read.start();


            while (true){
                String str = in.readUTF();
                    if (str.equals("/end")){
                        System.out.println("Client disconnected");
                        out2.writeUTF("/end");
                        break;
                    }else {
                        System.out.println("Client: " + str);
                    }
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
