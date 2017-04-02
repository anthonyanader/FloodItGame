import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The class <b>GameController</b> is the controller of the game. It has a method
 * <b>selectColor</b> which is called by the view when the player selects the next
 * color. It then computes the next step of the game, and  updates model and view.
 *
 *
 */


public class GameController implements ActionListener {

    private GameModel gameModel;
    private GameView gameView;

    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size the size of the board on which the game will be played
     */
    public GameController(int size) {

        gameModel = new GameModel(size);
        gameView = new GameView(gameModel, this);
        //flood();
        gameView.update();
    }

    /**
     * resets the game
     */
    public void reset(){

        gameModel.reset();
        //flood();
        gameView.update();
    }

    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand() == "Reset"){

            reset();

        }else if(e.getActionCommand() == "Quit") {

            System.exit(0);
        }
    }

    /**
     * <b>selectColor</b> is the method called when the user selects a new color.
     * If that color is not the currently selected one, then it applies the logic
     * of the game to capture possible locations. It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives two options: start a new game, or exit
     * @param color the newly selected color
     */
    public void selectColor(int color) {

        if (gameModel.getCurrentSelectedColor() != color) {

            gameModel.setCurrentSelectedColor(color);
            gameModel.step();

            GameStack gameStack = new GameStack(gameModel.getSize() * gameModel.getSize());

            for (int i = 0; i < gameModel.getSize(); i++) {
                for (int j = 0; j < gameModel.getSize(); j++) {

                    if (gameModel.isCaptured(i, j)) {

                        gameStack.push(gameModel.get(i, j));
                    }
                }
            }

            while (!gameStack.isEmpty()) {


                //TODO need to fix this logic doesn't go to an arrayOutOfBounds error


            }

        }

    }

    public void printBoard(){

        System.out.println(gameModel);
    }
}
