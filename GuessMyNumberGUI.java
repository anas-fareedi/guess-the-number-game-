import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessMyNumberGUI extends Frame implements ActionListener {
    private TextField inputField;
    private Label feedbackLabel;
    private Button guessButton;
    private Button resetButton;
    private int myNumber;

    public GuessMyNumberGUI() {
        // Setup the frame
        setTitle("Guess My Number Game");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null); // Center the window
        setResizable(false);

        // Create components
        Label promptLabel = new Label("Guess the number between 1 and 100:");
        inputField = new TextField(10);
        feedbackLabel = new Label("", Label.CENTER);
        feedbackLabel.setPreferredSize(new Dimension(350, 20));
        guessButton = new Button("Guess");
        resetButton = new Button("Reset");

        // Add action listeners
        guessButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Add components to the frame
        add(promptLabel);
        add(inputField);
        add(guessButton);
        add(resetButton);
        add(feedbackLabel);

        // Initialize game
        resetGame();

        // Handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == guessButton) {
            handleGuess();
        } else if (ae.getSource() == resetButton) {
            resetGame();
        }
    }

    private void handleGuess() {
        try {
            int userNumber = Integer.parseInt(inputField.getText());
            if (userNumber == myNumber) {
                feedbackLabel.setText("Woohoo! Correct!");
            } else if (userNumber < myNumber) {
                feedbackLabel.setText("Your number is too small.");
            } else {
                feedbackLabel.setText("Your number is too large.");
            }
        } catch (NumberFormatException e) {
            feedbackLabel.setText("Please enter a valid number.");
        }
    }

    private void resetGame() {
        myNumber = new Random().nextInt(100) + 1;
        System.out.println("New number to guess: " + myNumber); // Debugging output
        feedbackLabel.setText("");
        inputField.setText("");
    }

    public static void main(String[] args) {
        GuessMyNumberGUI app = new GuessMyNumberGUI();
        app.setVisible(true);
    }
}
