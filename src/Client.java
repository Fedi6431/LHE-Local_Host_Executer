//This software is protected by Fedi6431© copyrights
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public Client(String address, int port) {
        try {
            // establish a connection with the server
            System.out.println("Made by Fedi6431");
            System.out.println("Client started");
            socket = new Socket(address, port);
            System.out.println("Client connected");


            // get input from the terminal
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // send output to the server socket
            output = new DataOutputStream(socket.getOutputStream());


            // string to read input
            String line = "";
            int user_system;
            boolean linux;


            // IP of the server and the client
            String serverIP = socket.getLocalAddress().getHostAddress();
            String clientIP = Inet4Address.getLocalHost().getHostAddress();


            // ask the system that use the server to write custom payloads
            System.out.println("\nChoose the system that using the server");
            System.out.println("1 Linux");
            System.out.println("2 Windows\n");
            System.out.print("--> ");
            Scanner scanner = new Scanner(System.in);
            user_system = scanner.nextInt();

            if (user_system == 1) {
                linux = true;
                output.writeUTF(String.valueOf(linux));
            } else if (user_system == 2) {
                linux = false;
                output.writeUTF(String.valueOf(linux));
            } else {
                System.out.println("Syntax error, select one of the options");
            }

            // loop until "exit" is written
            while (!line.equalsIgnoreCase("exit")) {
                // get user input
                System.out.print(clientIP + " to " + serverIP + "$-");
                line = reader.readLine();
                // send the received input to the server
                output.writeUTF(line);
            }
            // close the connection
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
