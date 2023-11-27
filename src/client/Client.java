package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9123);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream is = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            String request;
            Thread thread = new Thread(()->{
                String response;
                try {
                    while (true){
                        response = is.readUTF();
                        System.out.println(response);
                    }
                }catch (IOException e){
                   System.out.println("Потеряно соединение с сервером");
                }
            });
            thread.start();
            while (true){
                request = scanner.nextLine();
                out.writeUTF(request);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
