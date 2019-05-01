public class Piece {

   private int x;
   
   private int y;
   
   private final Grid grid;
   
   public Piece(int x, int y) {
      this.grid = new Grid (2,2);
      grid.setSquare(0, 0, true);
      grid.setSquare(1, 0, true);
      grid.setSquare(0, 1, true);
      grid.setSquare(1, 1, true);
      this.x = x;
      this.y = y;
      
   }
   
   public int getX() {
      return this.x;
   }
   
   public int getY() {
      return this.y;
   }
   
   public void setX(int x) {
      this.x = x;
   }
   
   public void setY(int y) {
      this.y = y;
   }
   
   public Grid getGrid() {
      return this.grid;
   }

}