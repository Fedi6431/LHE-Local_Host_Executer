//This software is protected by Fedi6431© copyrights

import java.net.*;
import java.io.*;

public class Server {
    public static void Initialize(String address, int port) {
        try {
            // create a server socket
            InetAddress localIpAddress = InetAddress.getLocalHost();
            ServerSocket server = new ServerSocket();
            System.out.println("Server started");
            
            server.bind(new InetSocketAddress(localIpAddress, 65000));
            System.out.println("Running on port " + port + ", address: " + localIpAddress);

            // establish a connection with the client
            Socket socket = server.accept();
            System.out.println("Client connected");

            // get input from the terminal
            DataInputStream input = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            // string to read input
            String line = "";

            String os = System.getProperty("os.name");
            if (os.equals("windows")) 
            while (!line.equalsIgnoreCase("exit")) {
                try {
                    // read the message sent by the client via socket
                    line = input.readUTF();                        
                    System.out.println(line);

                    // try to execute the command on cmd using Runtime.getRuntime
                    Process windows_process = Runtime.getRuntime().exec(new String[]{"cmd", "/c " + line});
                } catch (IOException IOe) {
                    System.out.println("Oops.. Something went wrong.");
                    System.out.println("IO exception: " + IOe.getMessage());
                    System.out.println("Exception cause" + IOe.getCause());
                }
            }


         } else { 
            while (!line.equalsIgnoreCase("exit")) {
                try {
                    // read the message sent by the client via socket
                    line = input.readUTF();
                    System.out.println(line);

                    // try to execute the command on terminal using Runtime.getRuntime
                    Process linux_process = Runtime.getRuntime().exec(new String[]{line});
                } catch (IOException IOe) {
                    System.out.println("Oops.. Something went wrong.");
                    System.out.println("IO exception: " + IOe.getMessage());
                    System.out.println("Exception cause" + IOe.getCause());
                    }
                }
        }
        // close the connection
        System.out.println("Made by Fedi6431");
        socket.close();
        input.close();
            
        }
        // handle any errors
        catch (IOException IOe) {
            System.out.println("IO exception: " + IOe.getMessage());
            System.out.println("Exception cause" + IOe.getCause());
        }
        catch (RuntimeException RTe) {
            System.out.println("Runtime exception: " + RTe.getMessage());
            System.out.println("Exception cause" + RTe.getCause());
        }
    }

    public static void main(String args[]) {
        try {
            System.out.println("Made by Fedi6431");
            InetAddress localIpAddress = InetAddress.getLocalHost();
            String address = localIpAddress.getHostAddress();
            Initialize(address,65000);
        } catch (UnknownHostException e) {
            System.out.println("Error getting local host address: " + e.getMessage());
        }
    }
}
