package Lesson6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

        static Socket socket;
       private static final int PORT =8189;
        private static final String IP_ADRESS = "localhost";


        public static void main(String[] args) {

            try {
                socket = new Socket(IP_ADRESS, PORT);
                DataInputStream  in = new DataInputStream(socket.getInputStream());
                DataOutputStream out2 = new DataOutputStream(socket.getOutputStream());

                Thread thread = new Thread(()->{
                    Scanner scan = new Scanner(System.in);
                     while (true) {
                         String str = scan.nextLine();
                         try {
                             out2.writeUTF(str);
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     }
               });
               thread.setDaemon(true);
               thread.start();

                while (true){
                    String str = in.readUTF();
                    if (str.equals("/end")){
                        System.out.println("server disconnected");
                        break;
                    } else {
                    System.out.println("Server: " + str);}


                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }
