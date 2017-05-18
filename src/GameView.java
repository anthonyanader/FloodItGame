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
                dotBoard[i][j] = new DotButton(i,j, gameModel.getColor(i,j),
                        (gameModel.getSize() < 26 ? DotButton.MEDIUM_SIZE : DotButton.SMALL_SIZE));
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

        JPanel selectPanel = new JPanel();
        selectPanel.setBackground(Color.WHITE);
        selectPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY,3,true));

        DotButton button = new DotButton(0, 0, gameModel.COLOR_0, DotButton.NORMAL_SIZE);
        button.addActionListener(gameController);
        selectPanel.add(button);

        button = new DotButton(0, 0, gameModel.COLOR_1, DotButton.NORMAL_SIZE);
        button.addActionListener(gameController);
        selectPanel.add(button);

        button = new DotButton(0, 0, gameModel.COLOR_2, DotButton.NORMAL_SIZE);
        button.addActionListener(gameController);
        selectPanel.add(button);

        button = new DotButton(0, 0, gameModel.COLOR_3, DotButton.NORMAL_SIZE);
        button.addActionListener(gameController);
        selectPanel.add(button);

        button = new DotButton(0, 0, gameModel.COLOR_4, DotButton.NORMAL_SIZE);
        button.addActionListener(gameController);
        selectPanel.add(button);

        button = new DotButton(0, 0, gameModel.COLOR_5, DotButton.NORMAL_SIZE);
        button.addActionListener(gameController);
        selectPanel.add(button);


        score = new JLabel();

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.WHITE);

        controlPanel.add(reset);
        controlPanel.add(quit);
        controlPanel.add(score);


        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,1));
        southPanel.add(selectPanel);
        southPanel.add(controlPanel);
        southPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));
        southPanel.setBackground(Color.WHITE);
        add(southPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update(){

        for(int i = 0; i < gameModel.getSize(); i++){
            for(int j = 0; j < gameModel.getSize(); j++){
                dotBoard[i][j].setColor(gameModel.getColor(i,j));
            }
        }
        score.setText("Number of steps: " + gameModel.getNumberOfSteps());
        repaint();

    }

}
