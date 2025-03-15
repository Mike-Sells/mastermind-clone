public class ScorePanel extends ImagePanel {
    private int iterator = 0;

    public ScorePanel(int length, int rows)
    {
        super(length, rows);
    }

    /**
     * Helper function.  Updates the image based on the correctness of the guess.
     * @param correct True if the guess was correct, false otherwise.
     */
    private void updateImage(boolean correct)
    {
        setImage(iterator++, "icons/Score_" + (correct ? "0" : "1") + ".png");
    }

    /**
     * Updates the score panel based on the correctness of the guess.
     * Correct guesses are represented by a black image, partial guesses are represented by a white image.
     * Correct guesses are added first, before partial guesses.
     * @param correct Number of correct guesses.
     * @param partial Number of partial guesses.
     */
    public void updateScore(int correct, int partial)
    {
        while (correct-- > 0)
            updateImage(true);
        
        while (partial-- > 0)
            updateImage(false);
    }
}
