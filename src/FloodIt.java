

/**
 * The class <b>FloodIt</b> launches the game
 *
 *
 */
public class FloodIt {


   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If a game size (<12) is passed as parameter, it is 
     * used as the board size. Otherwise, a default value is passed
     * 
     * @param args command line parameters
     */
     public static void main(String[] args) {

         GameController gameController = new GameController(10);

         gameController.reset();
         gameController.printBoard();
         gameController.selectColor(2);




   }


}
