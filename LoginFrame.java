import javax.swing.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    String username = "admin";
    String password = "1234";

    LoginFrame() {

        setTitle("Online Examination System - Login");

        setSize(400, 300);

        setLayout(null);

        JLabel title = new JLabel("Login");

        title.setBounds(170, 30, 100, 30);

        add(title);

        JLabel userLabel = new JLabel("Username:");

        userLabel.setBounds(50, 80, 100, 25);

        add(userLabel);

        usernameField = new JTextField();

        usernameField.setBounds(150, 80, 150, 25);

        add(usernameField);

        JLabel passLabel = new JLabel("Password:");

        passLabel.setBounds(50, 130, 100, 25);

        add(passLabel);

        passwordField = new JPasswordField();

        passwordField.setBounds(150, 130, 150, 25);

        add(passwordField);

        loginButton = new JButton("Login");

        loginButton.setBounds(140, 190, 100, 30);

        loginButton.addActionListener(this);

        add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String user = usernameField.getText();

        String pass = new String(passwordField.getPassword());

        if(user.equals(username) && pass.equals(password)) {

            JOptionPane.showMessageDialog(this,
                    "Login Successful");

            dispose();

            new ProfileFrame(username, password);

        } else {

            JOptionPane.showMessageDialog(this,
                    "Invalid Username or Password");
        }
    }
}