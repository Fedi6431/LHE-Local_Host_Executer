//This software is protected by Fedi6431© copyrights

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;

public class ClientGUI extends JFrame {

    public static void Login() {
        // frame
        JFrame frame = new JFrame("Server login panel");
        frame.setSize(350, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // objects initialization
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
                frame.setVisible(false);
                String address = textField.getText();
                int port = 65000;
                ServerControlPanel(address, port);
            }
        });
    }

    public static void ServerControlPanel(String address, int port) {
        // frame
        JFrame serverFrame = new JFrame("Server control panel - LHE-Local_Host_Executer");
        serverFrame.setSize(800, 500);
        serverFrame.setResizable(false);
        serverFrame.setLocationRelativeTo(null);
        serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // objects initialization
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JTextField textField = new JTextField("");
        JButton EndSessionButton = new JButton("End session");
        JButton submitbutton = new JButton("submit");

        // panel
        JPanel serverPanel = new JPanel();
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

        // layout
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
        c.ipady = 250;
        c.weightx = 0.0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 2;
        serverPanel.add(textArea, c);
        // Add the EndSessionButton
        c.fill = GridBagConstraints.VERTICAL;
        c.ipady = 0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 4;
        c.gridy = 2;
        serverPanel.add(EndSessionButton, c);
        serverFrame.add(serverPanel);

        // set the frame to visible
        serverFrame.setVisible(true);

        try {
            // establish a connection with the server
            Socket socket = new Socket(address, port);
            JOptionPane.showMessageDialog(null, "Connected successfully to the server", "Server login panel", JOptionPane.INFORMATION_MESSAGE);

            // IP of the server and the client
            String serverIP = socket.getLocalAddress().getHostAddress();
            String clientIP = Inet4Address.getLocalHost().getHostAddress();

            // get input from the terminal
            BufferedReader ServerInfoOutput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // send output to the server socket
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // strings to read inputs
            String serverOS = ServerInfoOutput.readLine();
            String os = serverOS;
            String serverINFO = ServerInfoOutput.readLine();
            String info = serverINFO;

            // append the information of the server in the text area
            textArea.append(info + "\n\n");
            textArea.append("Server operating system: " + os + "\n");

            final int[] stringUsed = {0};
            submitbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // when the strings that are used are greater than 15 the client clear the text area
                    if (stringUsed[0] < 15) {
                        stringUsed[0]++;
                    } else if (stringUsed[0] >= 15) {
                        textArea.setText("");
                        textArea.append(info + "\n\n");
                        textArea.append("Server operating system: " + os + "\n\n");
                        for (int i = 0; i < 15; i++) {
                            stringUsed[0]--;
                        }
                    }

                    // append the commands in the text area
                    String line = textField.getText();
                    textArea.append(clientIP + " to " + serverIP + "$-" + line + "\n");
                    line = textField.getText();
                    try {
                        output.writeUTF(line);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            EndSessionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0)
                    ;
                }
            });
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to connect to server", "Server login panel", JOptionPane.ERROR_MESSAGE);
            int exitOption = JOptionPane.showConfirmDialog(null, "Want exit?", "Server login panel", JOptionPane.YES_NO_OPTION);
            if (exitOption == JOptionPane.NO_OPTION) {
                serverFrame.setVisible(false);
                Login();
            } else if (exitOption == JOptionPane.YES_OPTION){
                System.exit(1);
            }

        }
    }

    public static void main(String[] args) {
        Login();
    }
}
