import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * In the application <b>FloodIt</b>, a <b>DotButton</b> is a specialized color of
 * <b>JButton</b> that represents a dot in the game. It can have one of six colors
 *
 * The icon images are stored in a subdirectory ``data''. We have 3 sizes, ``normal'',
 * ``medium'' and ``small'', respectively in directory ``N'', ``M'' and ``S''.
 *
 * The images are
 * ball-0.png => grey icon
 * ball-1.png => orange icon
 * ball-2.png => blue icon
 * ball-3.png => green icon
 * ball-4.png => purple icon
 * ball-5.png => red icon
 *
 */

public class DotButton extends JButton {

        public static final int NUMBER_OF_SIZES = 3;
        public static final int SMALL_SIZE = 0;
        public static final int MEDIUM_SIZE = 1;
        public static final int NORMAL_SIZE = 2;

        private static final ImageIcon[][] imageIcon = new ImageIcon[NUMBER_OF_SIZES][GameModel.NUMBER_OF_COLORS];

        private int row;
        private int column;
        private int color;
        private int iconSize;


    /**
     * Constructor used for initializing a cell of a specified color.
     *
     * @param row the row of this Cell
     * @param column the column of this Cell
     * @param color specifies the color of this cell
     * @param iconSize specifies the size to use, one of SMALL_SIZE, MEDIUM_SIZE or MEDIUM_SIZE
     */

    public DotButton(int row, int column, int color, int iconSize) {

        this.row = row;
        this.column = column;
        this.color = color;
        this.iconSize = iconSize;

        setBackground(Color.WHITE);
        setIcon(getImageIcon());
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        setBorder(emptyBorder);
        setBorderPainted(false);

   }

 /**
     * Other constructor used for initializing a cell of a specified color.
     * no row or column info available. Uses "-1, -1" for row and column instead
     *
     * @param color specifies the color of this cell
     * @param iconSize specifies the size to use, one of SMALL_SIZE, MEDIUM_SIZE or MEDIUM_SIZE
     */
    public DotButton(int color, int iconSize) {

        this(-1,-1,color,iconSize);

    }

    /**
     * Changes the cell color of this cell. The image is updated accordingly.
     *
     * @param color the color to set
     */

    public void setColor(int color) {

        this.color = color;
        setIcon(getImageIcon());
   }

    /**
     * Getter for color
     *
     * @return color
     */
    public int getColor(){

        return color;

    }

    /**
     * Getter method for the attribute row.
     *
     * @return the value of the attribute row
     */

    public int getRow() {

        return row;

    }

    /**
     * Getter method for the attribute column.
     *
     * @return the value of the attribute column
     */

    public int getColumn() {

        return column;

    }


    private ImageIcon getImageIcon(){

        String directory = (iconSize == SMALL_SIZE ? "S": (iconSize == MEDIUM_SIZE ? "M" : "N"));

        if (imageIcon[iconSize][color] == null) {
            imageIcon[iconSize][color] = new ImageIcon("data/" + directory + "/ball-" + Integer.toString(color) + ".png");
        }

        return imageIcon[iconSize][color];
    }
}
