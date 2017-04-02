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
    private DotButton dotBoard[][];

    private JLabel score;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.white);
        gamePanel.setLayout(new GridLayout(gameModel.getSize(), gameModel.getSize()));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        dotBoard = new DotButton[gameModel.getSize()][gameModel.getSize()];



        for(int i = 0; i < gameModel.getSize(); i++){
            for(int j = 0; j < gameModel.getSize(); j++){
//                dotBoard[i][j] = new DotButton(i,j, gameModel.getColor(i,j),
//                        (gameModel.getSize() < 26 ? DotButton.MEDIUM_SIZE : DotButton.SMALL_SIZE));
                gamePanel.add(dotBoard[i][j]);
            }
        }

        add(gamePanel, BorderLayout.CENTER);

        JButton quit = new JButton("Quit");
        quit.setFocusPainted(false);

        JButton reset = new JButton("Reset");
        reset.setFocusPainted(false);

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
