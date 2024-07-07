//This software is protected by Fedi6431© copyrights

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void Initialize(String address, int port) {
        try {
            // establish a connection with the server
            Socket socket = new Socket(address, port);

            // get input from the terminal
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // send output to the server socket
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // string to read input
            String line = "";

            // IP of the server and the client
            String serverIP = socket.getLocalAddress().getHostAddress();
            String clientIP = Inet4Address.getLocalHost().getHostAddress();

            for(int i=0; i<100; i++) { System.out.println("\n"); }

            // loop until "exit" is written
            while (!line.equalsIgnoreCase("exit")) {
                // get user input
                System.out.print(STR."\{clientIP} to \{serverIP}$-");
                line = reader.readLine();
                // send the received input to the server
                output.writeUTF(line);
            }
            // close the connection
            output.close();
            socket.close();
        }
        // handle any errors
        catch (IOException IOe) {
            System.out.println(STR."IO exception: \{IOe.getMessage()}");
            System.out.println(STR."Exception cause: \{IOe.getCause()}");
        }
        catch (RuntimeException RTe) {
            System.out.println(STR."Runtime exception: \{RTe.getMessage()}");
            System.out.println(STR."Exception cause: \{RTe.getCause()}");
        }
    }

    public static void main(String[] args) {

        System.out.println("Made by Fedi6431");
        System.out.println("Type server IPv4");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();

        Initialize(address, 65000);
    }
}
