public class GameController {

   private final GameModel model;
   
   public GameController(GameModel model) {
      this.model = model;
   }   
   
   public PieceState moveLeft() {
      Piece piece = model.getPiece();
      int x = piece.getX();
      if(x == 0) {
         return PieceState.NONE;
      } else {
         piece.setX(x - 1);
         return PieceState.MOVE;
      }
   }
   
   public PieceState moveRight() {
      Piece piece = model.getPiece();
      int x = piece.getX();
      int w = model.getField().getWidth() - 1;
      if(x == w) {
         return PieceState.NONE;
      } else {
         piece.setX(x + 1);
         return PieceState.MOVE;
      }

   }
   
   public PieceState moveDown() {
      Piece piece = model.getPiece();
      int y = piece.getY();
      int h = model.getField().getHeight() - 1;
      if(y == h) {
         model.nextPiece();
         return PieceState.DROP;
      } else {
         piece.setY(y + 1);
         return PieceState.MOVE;
      }

   }

}