import javafx.application.*;
import javafx.stage.*;

public class Chetricks extends Application {
   @Override
   public void start(Stage primaryStage) {
      primaryStage.setTitle("Chetricks");
      
      GameModel model = new GameModel();
      //insert controller later
      GameView view = new GameView(primaryStage, model);
      
      primaryStage.show();
   }
}