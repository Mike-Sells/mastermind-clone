import java.util.Arrays;

public class Code {

    private int[] codeSequence;
    private int currentPosition;

    public Code(int maxLength) {
        this.currentPosition = 0;
        this.codeSequence = new int[maxLength];
    }

    public int setValue(int node) {
        if (currentPosition >= codeSequence.length) {
            throw new ArrayIndexOutOfBoundsException(
                "Error: Array Overflow..."
            );
        }

        codeSequence[currentPosition] = node;
        return currentPosition++;
    }

    public int getLength() {
        return currentPosition;
    }

    public boolean isComplete() {
        return currentPosition == codeSequence.length;
    }

    public String getCodeAsString() {
        String stringCode = Arrays.toString(codeSequence);

        return stringCode;
    }

    public int[] getCode() {
        return codeSequence;
    }
}
