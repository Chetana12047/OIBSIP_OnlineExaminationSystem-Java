import javax.swing.*;
import java.awt.event.*;

public class ExamFrame extends JFrame implements ActionListener {

    Question[] questions;

    JLabel questionLabel;
    JLabel timerLabel;

    JRadioButton option1, option2, option3, option4;

    ButtonGroup group;

    JButton nextButton, previousButton, submitButton;

    int currentQuestion = 0;

    int score = 0;

    int[] answers;

    int timeLeft = 180;

    Timer timer;

    ExamFrame() {

        questions = new Question[] {

    new Question(
            "What does JVM stand for?",
            new String[]{"Java Variable Machine", "Java Virtual Machine", "Java Verified Machine", "Joint Virtual Machine"},
            1
    ),

    new Question(
            "Which keyword is used for inheritance in Java?",
            new String[]{"extends", "implements", "inherits", "super"},
            0
    ),

    new Question(
            "Which package is used for Swing?",
            new String[]{"java.io", "java.sql", "javax.swing", "java.awt"},
            2
    ),

    new Question(
            "Which method is the entry point of Java program?",
            new String[]{"start()", "run()", "main()", "init()"},
            2
    ),

    new Question(
            "Which company developed Java?",
            new String[]{"Microsoft", "Apple", "Sun Microsystems", "Google"},
            2
    ),

    new Question(
            "Which operator is used for comparison?",
            new String[]{"=", "==", ":=", "!="},
            1
    ),

    new Question(
            "Which collection class stores dynamic arrays?",
            new String[]{"HashMap", "ArrayList", "Stack", "Queue"},
            1
    ),

    new Question(
            "Which keyword is used to create object in Java?",
            new String[]{"class", "this", "new", "create"},
            2
    ),

    new Question(
            "Which loop is guaranteed to execute at least once?",
            new String[]{"for", "while", "do-while", "foreach"},
            2
    ),

    new Question(
            "Which exception occurs when dividing by zero?",
            new String[]{"IOException", "ArithmeticException", "SQLException", "NullPointerException"},
            1
    )
};

        answers = new int[questions.length];

        for(int i = 0; i < answers.length; i++) {

            answers[i] = -1;
        }

        setTitle("Online Examination System");

        setSize(600, 400);

        setLayout(null);

        timerLabel = new JLabel("Time Left: 60");

        timerLabel.setBounds(450, 20, 120, 25);

        add(timerLabel);

        questionLabel = new JLabel();

        questionLabel.setBounds(50, 60, 500, 30);

        add(questionLabel);

        option1 = new JRadioButton();

        option1.setBounds(70, 120, 400, 25);

        add(option1);

        option2 = new JRadioButton();

        option2.setBounds(70, 150, 400, 25);

        add(option2);

        option3 = new JRadioButton();

        option3.setBounds(70, 180, 400, 25);

        add(option3);

        option4 = new JRadioButton();

        option4.setBounds(70, 210, 400, 25);

        add(option4);

        group = new ButtonGroup();

        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        previousButton = new JButton("Previous");

        previousButton.setBounds(80, 300, 100, 30);

        previousButton.addActionListener(this);

        add(previousButton);

        nextButton = new JButton("Next");

        nextButton.setBounds(220, 300, 100, 30);

        nextButton.addActionListener(this);

        add(nextButton);

        submitButton = new JButton("Submit");

        submitButton.setBounds(360, 300, 100, 30);

        submitButton.addActionListener(this);

        add(submitButton);

        loadQuestion();

        timer = new Timer(1000, e -> {

            timeLeft--;

            timerLabel.setText("Time Left: " + timeLeft);

            if(timeLeft <= 0) {

                timer.stop();

                submitExam();
            }
        });

        timer.start();

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                int choice = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to quit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION
                );

                if(choice == JOptionPane.YES_OPTION) {

                    System.exit(0);
                }
            }
        });

        setLocationRelativeTo(null);

        setVisible(true);
    }

    void loadQuestion() {

        Question q = questions[currentQuestion];

        questionLabel.setText((currentQuestion + 1) + ". " + q.question);

        option1.setText(q.options[0]);
        option2.setText(q.options[1]);
        option3.setText(q.options[2]);
        option4.setText(q.options[3]);

        group.clearSelection();

        if(answers[currentQuestion] == 0) option1.setSelected(true);
        if(answers[currentQuestion] == 1) option2.setSelected(true);
        if(answers[currentQuestion] == 2) option3.setSelected(true);
        if(answers[currentQuestion] == 3) option4.setSelected(true);
    }

    void saveAnswer() {

        if(option1.isSelected()) answers[currentQuestion] = 0;
        else if(option2.isSelected()) answers[currentQuestion] = 1;
        else if(option3.isSelected()) answers[currentQuestion] = 2;
        else if(option4.isSelected()) answers[currentQuestion] = 3;
    }

    public void actionPerformed(ActionEvent e) {

        saveAnswer();

        if(e.getSource() == nextButton) {

            if(currentQuestion < questions.length - 1) {

                currentQuestion++;

                loadQuestion();
            }
        }

        if(e.getSource() == previousButton) {

            if(currentQuestion > 0) {

                currentQuestion--;

                loadQuestion();
            }
        }

        if(e.getSource() == submitButton) {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Submit Exam?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if(choice == JOptionPane.YES_OPTION) {

                submitExam();
            }
        }
    }

    void submitExam() {

        timer.stop();

        score = 0;

        for(int i = 0; i < questions.length; i++) {

            if(answers[i] == questions[i].correctAnswer) {

                score++;
            }
        }

        dispose();

        new ResultFrame(score, questions.length);
    }
}