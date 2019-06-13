import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import java.util.*;


public class GameView {

   private static final int SCALE = 20;
   
   private static final int XWINDOW = 500;
   private static final int YWINDOW = 500;

   private final GameModel model;
   
   private final GraphicsContext gridLayer;
   
   private final GraphicsContext pieceLayer;
   
   private final GameController controller;
   
   private final Timer gravityTimer;
   
   public GameView(Stage stage, GameModel model, GameController controller) {
      this.model = model;
      this.controller = controller;
      
      Canvas grid = new Canvas(XWINDOW,YWINDOW);
      gridLayer = grid.getGraphicsContext2D();
      
      Canvas piece = new Canvas(XWINDOW,YWINDOW);
      pieceLayer = piece.getGraphicsContext2D();

      StackPane root = new StackPane(grid, piece);
      
      Scene s = new Scene(root, XWINDOW, YWINDOW, Color.WHITE);
      stage.setScene(s);
      
      grid.requestFocus();
      grid.setOnKeyPressed(e -> this.onKeyPressed(e));
      
      drawField();
      drawPiece();
      
      this.gravityTimer = new Timer();
      
      GameTask gravity = new GameTask(() -> onKeyPressed(KeyCode.DOWN));
      gravityTimer.schedule(gravity, 750, 750);

   }
   
   private void onKeyPressed(KeyEvent e) {
      onKeyPressed(e.getCode());
   }
    
    private void onKeyPressed(KeyCode code) {
      PieceState state = this.handleKeyPress(code);
        switch (state) {
            case MOVE:
               drawPiece();
               break;
            case NONE:
               break;
            case DROP:
               drawPiece();
               drawField();
               break;
        }

    }

   private PieceState handleKeyPress(KeyCode code) {
        switch (code) {
            // Arrow keys correspond to movement actions.
            case LEFT:
               return this.controller.moveLeft();
            case RIGHT:
               return this.controller.moveRight();
            case DOWN:
               return this.controller.moveDown();
            case Z:
               return this.controller.rotateLeft();
            case X:
               return this.controller.rotateRight();
            default:
                return PieceState.NONE;
            }
  }
  
   private void drawField() {
      Grid field = this.model.getField();
      
      int width = field.getWidth();
      int height = field.getHeight();
      gridLayer.clearRect(0, 0, XWINDOW, YWINDOW); 
      gridLayer.setFill(Color.ORANGE);
      gridLayer.setStroke(Color.BLUE);
      for(int y = 0; y < height; y++) {
         for(int x = 0; x < width; x++) {
            if (field.getSquare(x, y) == true) {       
               gridLayer.fillRect(x * SCALE, y * SCALE, SCALE, SCALE);
            } else {
               gridLayer.strokeRect(x * SCALE, y * SCALE, SCALE, SCALE);
            }
         }
      }
   }
   
   private void drawPiece() {
      Piece piece = this.model.getPiece();
      int x0 = piece.getX();
      int y0 = piece.getY();
      Grid grid = piece.getGrid();
      pieceLayer.clearRect(0, 0, XWINDOW, YWINDOW); 
      pieceLayer.setFill(Color.BLUE);
      pieceLayer.setStroke(Color.GREEN);
      for (int y = 0; y < grid.getHeight(); y++) {
         for (int x = 0; x < grid.getWidth(); x++) {
            if (grid.getSquare(x, y) == true) {
               drawSquare(x + x0, y + y0);
            }
         }
      } 
         
   }
   
   private void drawSquare(int x, int y) {
      pieceLayer.fillRect(x * SCALE, y * SCALE, SCALE, SCALE);
      pieceLayer.strokeRect(x * SCALE, y * SCALE, SCALE, SCALE);
   }
}

