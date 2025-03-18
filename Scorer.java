import java.util.ArrayList;
import java.util.List;

public class Scorer {

    /**
     * Method. Returns the number of correct values in the guess array
     *   compared to the answer array.
     * @param guess The user's guess as a Code object.
     * @param answer The answer sequence as a Code object.
     * @return The number of correct guesses.
     */
    public static int compareCorrect(Code guess, Code answer) {
        int correctCount = 0;
        int[] guessArray = guess.getCode(); // Extract int[] from Code
        int[] answerArray = answer.getCode(); // Extract int[] from Code

        for (int i = 0; i < answerArray.length; i++) {
            if (guessArray[i] == answerArray[i]) {
                correctCount++;
            }
        }
        return correctCount;
    }

    /**
     * Method. Returns the size of the intersection of the user guess array
     *   and the game's true answer, excluding correct guesses.
     * @param guess The user's guess as a Code object.
     * @param answer The answer sequence as a Code object.
     * @return The number of partially correct guesses.
     */
    public static int comparePartiallyCorrect(Code guess, Code answer) {
        int[] guessArray = guess.getCode(); // Extract [Array: int] from Code
        int[] answerArray = answer.getCode(); // Extract [Array: int] from Code

        // Convert arrays to lists for use of lsit standard functions
        List<Integer> guessList = new ArrayList<>();
        for (int g : guessArray) {
            guessList.add(g);
        }

        List<Integer> answerList = new ArrayList<>();
        for (int a : answerArray) {
            answerList.add(a);
        }

        boolean[] matched = new boolean[answerArray.length];

        // Remove correct guesses from the intersection
        for (int i = 0; i < answerArray.length; i++) {
            if (guessArray[i] == answerArray[i]) {
                matched[i] = true;
                guessList.set(i, null);
                answerList.set(i, null);
            }
        }

        int partialCorrect = 0;
        for (int i = 0; i < guessList.size(); i++) {
            Integer g = guessList.get(i);
            if (g != null && answerList.contains(g)) {
                partialCorrect++;
                answerList.remove(g); //prevents double counting
            }
        }

        return partialCorrect;
    }
}
