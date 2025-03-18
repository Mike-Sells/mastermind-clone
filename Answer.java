import java.util.Random;

public class Answer extends Code {

    /**
     * Constructor. Creates a new instance of the Answer with a random code.
     * @param numSymbols Number of symbols to include in the code
     */
    public Answer(int numSymbols) {
        super(numSymbols);
        // Generate random code based on no. of colours
        for (int i = 0; i < numSymbols; i++) setValue(
            new Random().nextInt(CodeBreaker.NO_OF_COLOURS)
        );
    }
}
