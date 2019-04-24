public class GameModel {
   private final PlayField field;
   private Piece piece;
   
   public GameModel() {
      this.field = new PlayField(10, 20);
      this.piece = new Piece(5,0);
   }
   
   public PlayField getField() {
      return this.field;
   }
   
   public Piece getPiece() {
      return this.piece;
   }
   
   public void nextPiece() {
      this.piece = new Piece(5,0);
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