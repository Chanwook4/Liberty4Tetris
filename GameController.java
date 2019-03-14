public class GameController {

   private final GameModel model;
   
   public GameController(GameModel model) {
      this.model = model;
   }   
   
   public boolean moveLeft() {
      return true;
   }
   
   public boolean moveRight() {
      return true;
   }
}