//This software is protected by Fedi6431© copyrights 
import java.io.*;
import java.net.*;

public class Client {
    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream output = null;

    public Client(String address, int port) {
        try {
            // establish a connection with the server
            System.out.println("Made by Fedi6431");
            System.out.println("Client started");
            socket = new Socket(address, port);
            System.out.println("Client connected");

            // get input from the terminal using BufferedReader
            input = new BufferedReader(new InputStreamReader(System.in));
            // send output to the server socket
            output = new DataOutputStream(socket.getOutputStream());

            // string to read input
            String line = "";

            // IP of the server and the client
            String serverIP = socket.getLocalAddress().getHostAddress();
            String clientIP = Inet4Address.getLocalHost().getHostAddress();

            // loop until "exit" is written
            while (!line.equalsIgnoreCase("exit")) {
                // get user input
                System.out.print(clientIP + " to " + serverIP + "$-");
                line = input.readLine();
                // send the received input to the server
                output.writeUTF(line);
            }
            // close the connection
            System.out.println("Made by Fedi6431");
            input.close();
            output.close();
            socket.close();
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
        Client client = new Client("127.0.0.1", 5000);
    }
}
