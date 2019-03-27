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
}