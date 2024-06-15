//This software is protected by Fedi6431© copyrights 
import java.net.*;
import java.io.*;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input =  null;
    private DataOutputStream output = null;

    public Server(int port) {
        try {
            // create a server socket
            server = new ServerSocket(port);
            System.out.println("Made by Fedi6431");
            System.out.println("Server started");
            // establish a connection with the client
            socket = server.accept();
            System.out.println("Client connected");

            // get input from the terminal
            input = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            // send output to the client
            output = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));

            // string to read input
            String line = "";
            while (!line.equalsIgnoreCase("exit")) {
                // read the message sent by the client via socket
                line = input.readUTF();
                System.out.println(line);
                // try to execute the command on cmd using Runtime.getRuntime
                Process cmd_process = Runtime.getRuntime().exec(new String[]{"cmd", "/c " + line});
                Process linux_process = Runtime.getRuntime().exec(new String[]{line});
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
        Server server = new Server(5000);
    }
}
