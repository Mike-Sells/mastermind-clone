public class GuessPanel extends ImagePanel {
    private int iterator = 0;

    public GuessPanel(int length, int rows)
    {
        super(length, rows);
    }

    /**
     * Updates the guess panel with the colour represented by the number value.
     * @param colour The number value of the colour (indexes the icon filenames).
     */
    public void updateGuess(int colour)
    {
        setImage(iterator++, "icons/Colour_" + colour + ".png");
    }
}