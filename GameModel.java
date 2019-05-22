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
   
   private Piece randomPiece() {
      int r = (int)(Math.random() * 7);
      switch (r) {
         case 0: return new LPiece(3, 0);
         
         case 1: return new JPiece(3, 0);
         
         case 2: return new IPiece(3, 0);
         
         case 3: return new OPiece(3, 0);
         
         case 4: return new SPiece(3, 0);
         
         case 5: return new ZPiece(3, 0);
         
         default: return new TPiece(3, 0);
         
      }

   }
   
   public void nextPiece() {
      this.piece = randomPiece();
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