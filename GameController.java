public class GameController {

   private final GameModel model;
   
   public GameController(GameModel model) {
      this.model = model;
   }
   
   private PieceState moveLeftRight(int dx) {
      Grid field = model.getField();
      Piece piece = model.getPiece();
      int y = piece.getY();
      int x = piece.getX();
      Grid grid = piece.getGrid();
      int nextX = x + dx;
      if (!field.checkClear(grid, nextX, y)) {
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
      Grid field = model.getField();
      Piece piece = model.getPiece();
      int y = piece.getY();
      int nextY = y + 1; 
      int x = piece.getX();
      Grid grid = piece.getGrid();
      if(!field.checkClear(grid, x, nextY)) {
         dropPiece(field, grid, x, y);
         return PieceState.DROP;
      } else {
         piece.setY(nextY);
         return PieceState.MOVE;
         
      }

   }
   
   private void dropPiece(Grid field, Grid grid, int x0, int y0) {
       for (int y = 0; y < grid.getHeight(); y++) {
          for (int x = 0; x < grid.getWidth(); x++) {   
            if (grid.getSquare(x, y)) {     
               field.setSquare(x + x0, y + y0, true);
            }
          }
       }
       model.nextPiece();
       model.clearLines();
   }

}