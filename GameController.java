public class GameController {

   private final GameModel model;
   
   public GameController(GameModel model) {
      this.model = model;
   }
   
   private PieceState moveLeftRight(int dx) {
      PlayField field = model.getField();
      Piece piece = model.getPiece();
      int y = piece.getY();
      int x = piece.getX();
       int nextX = x + dx;
      if(field.getSquare(nextX, y)) {
         return PieceState.NONE;
      } else {
         piece.setX(nextX);
         return PieceState.MOVE;
      }

   }
   
   public PieceState moveLeft() {
      return moveLeftRight(-1);   
   }
   
   public PieceState moveRight() {
      return moveLeftRight(1);  
   }
   
   public PieceState moveDown() {
      PlayField field = model.getField();
      Piece piece = model.getPiece();
      int y = piece.getY();
      int nextY = y + 1; 
      int x = piece.getX();
      if(field.getSquare(x, nextY) == true) {
         field.setSquare(x, y, true);
         model.nextPiece();
         return PieceState.DROP;
      } else {
         piece.setY(y + 1);
         return PieceState.MOVE;
         
      }

   }

}