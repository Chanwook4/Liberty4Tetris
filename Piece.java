public abstract class Piece {

   private int x0;
   
   private int y0;
   
   private final Grid grid;
   
   protected Piece(int x0, int y0, int hex) {
      this.grid = new Grid (4,4);
      for (int y = 0; y < grid.getHeight(); y++) {
         for (int x = 0; x < grid.getWidth(); x++) {
            boolean square = (hex % 2 == 1);
            hex = hex / 2;
            grid.setSquare(x , y, square);
         }
      }
    
      
//       grid.setSquare(0, 0, true);
//       grid.setSquare(1, 0, true);
//       grid.setSquare(0, 1, true);
//       grid.setSquare(1, 1, true);
      this.x0 = x0;
      this.y0 = y0;
      
   }
   
   public int getX() {
      return this.x0;
   }
   
   public int getY() {
      return this.y0;
   }
   
   public void setX(int x) {
      this.x0 = x;
   }
   
   public void setY(int y) {
      this.y0 = y;
   }
   
   public Grid getGrid() {
      return this.grid;
   }

}