public class GameModel {
   private final PlayField field;
   
   public GameModel() {
      this.field = new PlayField(10, 20);
        
   }
   
   public PlayField getField() {
      return this.field;
   }
}