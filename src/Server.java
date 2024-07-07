import java.net.*;
import java.io.*;

public class Server {
    public static void Initialize(String address, int port) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " + port + ", address: " + address);

            // Establish a connection with the client
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Get input from the client
            DataInputStream input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            // Read input from the client and execute commands based on the operating system
            String line = "";
            String os = System.getProperty("os.name");

            while (!line.equalsIgnoreCase("exit")) {
                try {
                    // Read the message sent by the client via socket
                    line = input.readUTF();
                    System.out.println(line);

                    // Execute the command based on the operating system
                    Process process;
                    if (os.toLowerCase().contains("windows")) {
                        process = Runtime.getRuntime().exec(new String[]{"cmd", "/c", line});
                    } else {
                        process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", line});
                    }

                    // Wait for the command to finish
                    process.waitFor();
                } catch (IOException | InterruptedException e) {
                    System.out.println("Oops.. Something went wrong.");
                    System.out.println("Exception: " + e.getMessage());
                }
            }

            // Close the connection
            System.out.println("Server shutting down");
            socket.close();
            input.close();
            server.close();

        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            InetAddress localIpAddress = InetAddress.getLocalHost();
            String address = localIpAddress.getHostAddress();
            Initialize(address, 65000);
        } catch (UnknownHostException e) {
            System.out.println("Error getting local host address: " + e.getMessage());
        }
    }
}
