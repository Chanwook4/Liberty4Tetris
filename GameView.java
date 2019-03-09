import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.stage.*;

public class GameView {

   private static final int SCALE = 20;
   
   private static final int XWINDOW = 500;
   private static final int YWINDOW = 500;

   private final GameModel model;
   
   private final GraphicsContext gc;
   
   public GameView(Stage stage, GameModel model) {
      Group root = new Group();
      Scene s = new Scene(root, XWINDOW, YWINDOW, Color.WHITE);
      Canvas canvas = new Canvas(XWINDOW,YWINDOW);
      gc = canvas.getGraphicsContext2D();
      root.getChildren().add(canvas);
      stage.setScene(s);
      this.model = model;
      drawField();
     
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

