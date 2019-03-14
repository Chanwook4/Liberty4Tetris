import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class GameView {

   private static final int SCALE = 20;
   
   private static final int XWINDOW = 500;
   private static final int YWINDOW = 500;

   private final GameModel model;
   
   private final GraphicsContext gc;
   
   private final GameController controller;
   
   public GameView(Stage stage, GameModel model, GameController controller) {
      this.model = model;
      this.controller = controller;
      Group root = new Group();
      Scene s = new Scene(root, XWINDOW, YWINDOW, Color.WHITE);
      Canvas canvas = new Canvas(XWINDOW,YWINDOW);
      gc = canvas.getGraphicsContext2D();
      root.getChildren().add(canvas);
      stage.setScene(s);
      
      canvas.requestFocus();
      canvas.setOnKeyPressed(e -> this.onKeyPressed(e));
      
      drawField();
      
   }
   
   private void onKeyPressed(KeyEvent e) {
        boolean handled = this.handleKeyPress(e.getCode());
        if (handled) {
         PlayField field = this.model.getField();
         boolean [] grid = field.getGrid();
         grid[1] = true;
         drawField();
         
        }
    }

   private boolean handleKeyPress(KeyCode code) {
        switch (code) {
            // Arrow keys correspond to movement actions.
            case LEFT:
                return this.controller.moveLeft();
            case RIGHT:
                return this.controller.moveRight();
            default:
                return false;
            }
  }
  
   private void drawField() {
      PlayField field = this.model.getField();
      boolean [] grid = field.getGrid();
      int width = field.getWidth();
      int height = field.getHeight();
      gc.clearRect(0, 0, 300, 300); 
      gc.setFill(Color.ORANGE);
      gc.setStroke(Color.BLUE);
      for(int y = 0; y < height; y++) {
         for(int x = 0; x < width; x++) {
            if (grid [y * width + x] == true) {       
               gc.fillRect(x * SCALE, y * SCALE, SCALE, SCALE);
            } else {
               gc.strokeRect(x * SCALE, y * SCALE, SCALE, SCALE);
            }
         }
      }
   }
}

