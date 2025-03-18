import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CodeBreakerWindow extends JFrame implements ActionListener {
    // Constant colour for the game background
    public static final Color BROWN = new Color(153, 102, 0);

    private JPanel mainPanel;
    private JPanel guessesPanel;
    private JPanel inputPanel;
    private JButton[] inputButtons;

    int codeLength, noOfAttempts;

    CodeBreaker codeBreaker;

    /**
     * Constructor. Creates a new instance of the CodeBreakerWindow with all UI panels.
     * @param codeLength Length of the code to break
     * @param noOfAttempts Number of attempts allowed
     */
    public CodeBreakerWindow(int codeLength, int noOfAttempts)
    {
        this.codeLength = codeLength;
        this.noOfAttempts = noOfAttempts;
        codeBreaker = new CodeBreaker(codeLength, noOfAttempts);

        this.setTitle("Code Breaker!");

        // Set up the guesses panel
        guessesPanel = new JPanel();
        guessesPanel.setLayout(new GridLayout(this.noOfAttempts, 1));

        // Populate guessPanels into array backwards so that the first guess goes at the
        // bottom
        for (int i = this.noOfAttempts - 1; i >= 0; i--) {
            JPanel guessPanel = new JPanel();
            guessPanel.setLayout(new BorderLayout());
            guessPanel.add("Center", new GuessPanel(this.codeLength, 1));
            guessPanel.add("East", new ScorePanel(this.codeLength, 2));
            guessPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            guessesPanel.add(guessPanel);
        }

        // Set up the input buttons for the code colours
        inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inputPanel.setLayout(new GridLayout(1, CodeBreaker.NO_OF_COLOURS));
        inputPanel.setBackground(BROWN);
        inputButtons = new JButton[CodeBreaker.NO_OF_COLOURS];

        for (int i = 0; i < CodeBreaker.NO_OF_COLOURS; i++) {
            inputButtons[i] = new JButton(new Image("icons/Colour_" + i + ".png"));
            inputButtons[i].setBorder(BorderFactory.createEmptyBorder());
            inputButtons[i].setBackground(BROWN);
            inputButtons[i].addActionListener(this);
            inputPanel.add(inputButtons[i]);
        }

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(BROWN);
        mainPanel.add("Center", guessesPanel);
        mainPanel.add("South", inputPanel);

        this.setContentPane(mainPanel);
        this.setBackground(BROWN);
        this.setSize(600, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Helper function.  Finds the guess panel for the current attempt and updates it
     * based on which colour button (number value) we click.
     * @param attempt The current attempt number.
     * @param position The current position in the guess from 0.
     * @param colour The colour value of the button clicked.
     */
    private void updateGuessPanel(int attempt, int position, int colour)
    {
        JPanel guessPanel = (JPanel) (guessesPanel.getComponent(this.noOfAttempts - 1 - attempt));
        GuessPanel codePanel = (GuessPanel) ((BorderLayout) guessPanel.getLayout())
                .getLayoutComponent(BorderLayout.CENTER);
        codePanel.updateGuess(colour);
    }

    /**
     * Helper function.  Finds the score panel for the current attempt and updates it.
     * @param attempt The current attempt number.
     * @param correctCount The number of correct colours in the guess.
     * @param partiallyCorrectCount The number of partially correct colours in the guess.
     */
    private void updateScorePanel(int attempt, int correctCount, int partiallyCorrectCount)
    {
        JPanel guessPanel = (JPanel) (guessesPanel.getComponent(this.noOfAttempts - 1 - attempt));
        ScorePanel scorePanel = (ScorePanel) ((BorderLayout) guessPanel.getLayout())
                .getLayoutComponent(BorderLayout.EAST);
        scorePanel.updateScore(correctCount, partiallyCorrectCount);
    }

    /**
     * Handles the user guesses.  If a colour button is clicked,
     * the current guess panel is updated.  End of game is when the code length
     * matches the correct code length.
     */
    public void actionPerformed(ActionEvent e)
    {
        boolean gameEnded = false;

        for (int i = 0; i < inputButtons.length; i++) {
            if (e.getSource() == inputButtons[i]) {
                int[] positions = codeBreaker.updateGuess(i);
                int currentAttempt = positions[0];
                int currentPosition = positions[1];
                updateGuessPanel(currentAttempt, currentPosition, i);

                if (codeBreaker.isGuessComplete()) {
                    int[] results = codeBreaker.calculateScore();
                    int correctCount = results[0];
                    int partiallyCorrectCount = results[1];
                    updateScorePanel(currentAttempt, correctCount, partiallyCorrectCount);
                    codeBreaker.updateAttempt();

                    if (correctCount == codeLength) {
                        endGame("Congratulations! You won the game!", "Winner!");
                        gameEnded = true;
                    }
                }
            }
        }

        // If max no. guesses has been reached
        if (!gameEnded && codeBreaker.getAttempt() == noOfAttempts)
            endGame("Oops! You lost this time. Try again!", "Game Over");
    }

    /**
     * Helper function. Disables all buttons in the input panel.
     */
    private void disableInputPanel()
    {
        for (JButton b : this.inputButtons)
            b.setEnabled(false);
    }

     /**
      * Ends the game with a message.
      * @param gameEndOutput The message to show to the user.
      * @param title The title of the message.
      */
    private void endGame(String gameEndOutput, String title) {
        System.out.println(gameEndOutput);
        JOptionPane.showMessageDialog(this, gameEndOutput, title, JOptionPane.INFORMATION_MESSAGE);
        System.out.println("The code to break was: " + codeBreaker.getAnswer().getCodeAsString());
        disableInputPanel();
    }
}