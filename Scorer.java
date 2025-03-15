import java.util.HashMap;
import java.util.Map;

public class Scorer {

    public static int comparePartiallyCorrect(Code guess, Code answer) {
        int[] guessArray = guess.getCode();
        int[] answerArray = answer.getCode();

        // Step 1: Count occurrences of numbers in answerArray, excluding exact matches
        Map<Integer, Integer> answerFrequency = new HashMap<>();
        for (int i = 0; i < answerArray.length; i++) {
            if (guessArray[i] != answerArray[i]) { // Only consider incorrect positions
                answerFrequency.put(
                    answerArray[i],
                    answerFrequency.getOrDefault(answerArray[i], 0) + 1
                );
            }
        }

        // Step 2: Count how many of these appear in guessArray in incorrect positions
        int partialCorrect = 0;
        for (int i = 0; i < guessArray.length; i++) {
            if (
                guessArray[i] != answerArray[i] &&
                answerFrequency.getOrDefault(guessArray[i], 0) > 0
            ) {
                partialCorrect++;
                answerFrequency.put(
                    guessArray[i],
                    answerFrequency.get(guessArray[i]) - 1
                );
            }
        }

        return partialCorrect;
    }
}
