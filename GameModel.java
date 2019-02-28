public class GameModel {
   private final Square box;
   
   public GameModel() {
      this.box = new Square();
   }
   
   public Square getBox() {
      return this.box;
   }
}