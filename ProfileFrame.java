import javax.swing.*;
import java.awt.event.*;

public class ProfileFrame extends JFrame implements ActionListener {

    JTextField nameField;
    JPasswordField passwordField;

    JButton startButton;

    String username;
    String password;

    ProfileFrame(String username, String password) {

        this.username = username;
        this.password = password;

        setTitle("Profile Update");

        setSize(400, 300);

        setLayout(null);

        JLabel title = new JLabel("Update Profile");

        title.setBounds(140, 30, 150, 30);

        add(title);

        JLabel nameLabel = new JLabel("Display Name:");

        nameLabel.setBounds(40, 90, 120, 25);

        add(nameLabel);

        nameField = new JTextField(username);

        nameField.setBounds(170, 90, 150, 25);

        add(nameField);

        JLabel passLabel = new JLabel("Password:");

        passLabel.setBounds(40, 140, 120, 25);

        add(passLabel);

        passwordField = new JPasswordField(password);

        passwordField.setBounds(170, 140, 150, 25);

        add(passwordField);

        startButton = new JButton("Start Exam");

        startButton.setBounds(130, 200, 120, 30);

        startButton.addActionListener(this);

        add(startButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        dispose();

        new ExamFrame();
    }
}