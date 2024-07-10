//This software is protected by Fedi6431© copyrights

//This software is protected by Fedi6431© copyrights

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
import java.net.*;

public class Client {
    public static void Initialize(String address, int port) {
        try {
            System.out.println("Made by Fedi6431\n");

            // establish a connection with the server
            Socket socket = new Socket(address, port);

            // get input from the terminal
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader ServerInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader ServerInfo = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // send output to the server socket
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // string to read input
            String line = "";
            String os = ServerInput.readLine();
            String info = ServerInfo.readLine();

            System.out.println(info);

            System.out.println("\nServer system: " + os + "\n");
            // IP of the server and the client
            String serverIP = socket.getLocalAddress().getHostAddress();
            String clientIP = Inet4Address.getLocalHost().getHostAddress();

            // loop until "exit" is written
            while (!line.equalsIgnoreCase("exit")) {
                // get user input
                System.out.print(clientIP + " to " + serverIP + "$-");
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
            System.out.println("IO exception: " + IOe.getMessage());
            System.out.println("Exception cause: " + IOe.getCause());
        }
        catch (RuntimeException RTe) {
            System.out.println("Runtime exception: " + RTe.getMessage());
            System.out.println("Exception cause: " + RTe.getCause());
        }
    }


    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("LHE-Local_Host_Executer 1.7\nUsage: java Client.java [Options] {target specification}\nCONNECTION:\n  -IPv4 <server ipv4> Connect to the target server\nEXAMPLES:\n  java Client.java -IPv4 192.168.255.255\n");
        } else if (args[0].equals("-IPv4")) {
            String address = args[1];
            int port = 65000;
            Initialize(address, port);
        }
    }
}

