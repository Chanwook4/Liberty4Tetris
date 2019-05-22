import java.util.*;

public class GameModel {
   private final Grid field;
   private Piece piece;
   
   public GameModel() {
      this.field = new Grid(10, 20);
      nextPiece();
   }
   
   public Grid getField() {
      return this.field;
   }
   
   public Piece getPiece() {
      return this.piece;
   }
   
   public void nextPiece() {
      int r = (int)(Math.random() * 3);
      if (r == 0) {
         piece = new LPiece(3,0);
      } else if (r == 1) {
         piece = new IPiece(3,0);
      } else {
         piece = new OPiece(3,0);
      }
   }
   
   public void clearLines() {
      for (int y = 0; y < field.getHeight(); y++) {
         boolean lineCleared = true;
         for (int x = 0; x < field.getWidth(); x++) {
            if (field.getSquare(x, y) == false) {
               lineCleared = false;
            } 
         }
         if (lineCleared == true) {
            for (int x = 0; x < field.getWidth(); x++) {
               field.setSquare(x, y, false);
            }
            shiftRows(y);
         }
      }
   }
   private void shiftRows(int endRow) {
      for(int y = endRow; y > 0; y--) {   
         for (int x = 0; x < field.getWidth(); x++) {
            boolean box = field.getSquare(x,y-1);
            field.setSquare(x, y, box);
         }
      }
   }
}