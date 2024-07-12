import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;

public class ClientGUI extends JFrame {

    public static void Login() {
        // Login frame settings
        JFrame frame = new JFrame("Server login panel");
        frame.setSize(350, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Objects initialization
        JTextArea textArea = new JTextArea();
        JButton button = new JButton("submit");
        JTextField textField = new JTextField("Type server IPv4");

        // Control panel LHE objects
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(textField, BorderLayout.PAGE_START);
        panel.add(button, BorderLayout.PAGE_END);

        // Adding objects to the login frame
        frame.add(textField);
        frame.add(button);
        textField.setBounds(125, 20, 100, 25);
        button.setBounds(137, 70, 75, 20);

        // Button action listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Connecting to server");
                frame.setVisible(false); // Hiding the login frame
                String address = textField.getText();
                int port = 65000;
                try {
                    ServerControlPanel(address, port);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public static void ServerControlPanel(String address, int port) throws IOException {
        // FRAME
        JFrame serverFrame = new JFrame("Server control panel - LHE-Local_Host_Executer");
        // frame configuration
        serverFrame.setSize(800, 500);
        serverFrame.setResizable(false);
        serverFrame.setLocationRelativeTo(null);
        serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // OBJECTS
        // text area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        // text field
        JTextField textField = new JTextField("");  // First component as text field
        // buttons
        JButton EndSessionButton = new JButton("End session");
        JButton submitbutton = new JButton("submit");


        // PANEL
        JPanel serverPanel = new JPanel();
        // panel layout configuration
        serverPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        /*
        c.fill      set if the grid is vertical or horizontal
        c.ipady     make the object bigger
        c.weightx   request any extra horizontal space
        c.gridwidth width of the grid
        c.gridx     x of the grid / align with other objects
        c.gridy     y of the grid / row number
        c.fill      GridBagConstraints.HORIZONTAL;
        c.ipady     reset to default
        c.weighty   request any extra vertical space
        c.anchor    set the location
        c.insets    padding
        */
        // LAYOUT
        // text field layout
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.weightx = 0.33;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 0;
        serverPanel.add(textField, c);
        // submit button layout
        c.ipady = 13;
        c.gridx = 3;
        c.gridy = 0;
        serverPanel.add(submitbutton, c);
        // text area layout
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 300;
        c.weightx = 0.0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 2;
        serverPanel.add(textArea, c);
        // Add the EndSessionButton
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 2;
        serverPanel.add(EndSessionButton, c);
        serverFrame.add(serverPanel);
        serverFrame.setVisible(true);

        String line = textField.getText();
        // establish a connection with the server
        Socket socket = new Socket(address, port);

        // get input from the terminal
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader ServerInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader ServerInfo = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // send output to the server socket
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // string to read input
        String os = ServerInput.readLine();
        String info = ServerInfo.readLine();

        textArea.append(info + "\n\n");
        textArea.append("Server operating system: " + os + "\n");

        // IP of the server and the client
        String serverIP = socket.getLocalAddress().getHostAddress();
        String clientIP = Inet4Address.getLocalHost().getHostAddress();

        // ACTION LISTENER FOR BUTTONS
        submitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String line = textField.getText();
            textArea.append(clientIP + " to " + serverIP + "$-" + line + "\n");
            line = textField.getText();
                try {
                    output.writeUTF(line);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                textField.setText("");

            }
        });

        EndSessionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }

    public static void main(String[] args) {
        Login();
    }
}