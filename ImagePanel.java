import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private JLabel[] images;

    /**
     * Constructor. Creates a new instance of the ImagePanel with an empty images grid.
     * @param length Images per row
     * @param rows Number of rows
     */
    public ImagePanel(int length, int rows)
    {
        this.setBackground(CodeBreakerWindow.BROWN);
        this.setLayout(new GridLayout(rows, length));
        images = new JLabel[length];

        for (int i = 0; i < length; i++) {
            images[i] = new JLabel(new Image("icons/Empty.png"));
            this.add(images[i]);
        }
    }

    /**
     * Set the image at the given index to the image with the given file name.
     * @param index The index of the image to set.
     * @param fileName The file name of the image to set.
     */
    public void setImage(int index, String fileName)
    {
        images[index].setIcon(new Image(fileName));
    }
}
