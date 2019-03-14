import javafx.application.*;
import javafx.stage.*;

public class Chetricks extends Application {
   @Override
   public void start(Stage primaryStage) {
      primaryStage.setTitle("Chetricks");
      
      GameModel model = new GameModel();
      GameController controller = new GameController (model);
      GameView view = new GameView(primaryStage, model, controller);
      
      primaryStage.show();
   }
}