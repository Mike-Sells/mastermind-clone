public class CodeBreaker {
    public static final int NO_OF_COLOURS = 7;

    // The guesses for the game
    private Code[] guesses;
    
    // A position for the current guess
    private int attempt;
    
    // The code to break
    private Answer answer;
    
    // The scoring algorithm (how many matches)
    private Scorer scorer;

    /**
     * Constructor. Creates a new instance of the CodeBreaker with the 
     * given code length and number of attempts.
     * @param codeLength Length of the code to break
     * @param noOfAttempts Number of attempts allowed
     */
    public CodeBreaker(int codeLength, int noOfAttempts)
    {
        attempt = 0;
        answer = new Answer(codeLength);

        guesses = new Code[noOfAttempts];

        for (int i = 0; i < noOfAttempts; i++)
            guesses[i] = new Code(codeLength);

        scorer = new Scorer();
    }

    /**
     * Updates the current guess with the selected colour.
     * @param colour Selected colour
     * @return Integer array composed of current attempt and 
     * updated position of the guess
     */
    public int[] updateGuess(int colour)
    {
        int updatedPosition = guesses[attempt].setValue(colour);
        return new int[] { attempt, updatedPosition };
    }

    /**
     * Moves to the next attempt.
     */
    public void updateAttempt()
    {
        attempt++;
    }

    /**
     * Determines the current attempt.
     * @return Attempt
     */
    public int getAttempt()
    {
        return attempt;
    }

    /**
     * Determines the answer.
     * @return Answer code
     */
    public Code getAnswer()
    {
        return answer;
    }

    /**
     * Checks whether the current attempt/guess has a complete code.
     * @return Boolean
     */
    public boolean isGuessComplete()
    {
        return guesses[attempt].isComplete();
    }

    
    /**
     * Compares current guess with the answer and calculates the score.
     * @return Integer array composed of completely and partially correct code values
     */
    public int[] calculateScore()
    {
        int partiallyCorrectCount = 0;

        // Get the number of completely correct code values and update the icons
        int correctCount = scorer.compareCorrect(guesses[attempt], answer);

        // If they're not all correct, then check for partially correct answers
        if (correctCount < answer.getLength())
            partiallyCorrectCount = scorer.comparePartiallyCorrect(guesses[attempt], answer);

        return new int[] { correctCount, partiallyCorrectCount };
    }
}
