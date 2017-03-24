import java.awt.*;

import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out the actual game and
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 */

public class GameView extends JFrame {

    private GameModel gameModel;
    private GameController gameController;

    /**
     * Constructor used for initializing the Frame
     *
     * @param model the model of the game (already initialized)
     * @param gameController the controller
     */

    public GameView(GameModel model, GameController gameController) {

        super("FloodIt");
        this.gameModel = model;
        this.gameController = gameController;


        setBackground(Color.white);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JButton quit = new JButton("Quit");
        JButton reset = new JButton("Reset");

        quit.addActionListener(gameController);
        reset.addActionListener(gameController);

        quit.setActionCommand("Quit");
        reset.setActionCommand("Reset");

        JPanel bottomPanel = new JPanel(new FlowLayout());

        bottomPanel.add(reset);
        bottomPanel.add(quit);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update(){

// ADD YOUR CODE HERE

    }

}
