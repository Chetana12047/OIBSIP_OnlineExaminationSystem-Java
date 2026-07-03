import javax.swing.*;
import java.awt.event.*;

public class ResultFrame extends JFrame implements ActionListener {

    JButton logoutButton;

    ResultFrame(int score, int total) {

        setTitle("Exam Result");

        setSize(400, 300);

        setLayout(null);

        JLabel resultLabel = new JLabel(
                "Your Score: " + score + " / " + total
        );

        resultLabel.setBounds(120, 80, 200, 30);

        add(resultLabel);

        JLabel statusLabel;

        if(score >= 2) {

            statusLabel = new JLabel("Result: Passed");

        } else {

            statusLabel = new JLabel("Result: Failed");
        }

        statusLabel.setBounds(140, 130, 150, 30);

        add(statusLabel);

        logoutButton = new JButton("Logout");

        logoutButton.setBounds(130, 190, 120, 30);

        logoutButton.addActionListener(this);

        add(logoutButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        dispose();

        new LoginFrame();
    }
}