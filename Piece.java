public abstract class Piece {

   private int x0;
   
   private int y0;
   
   private final Grid grid;
   
   private final int[] rotations;
   
   private int rotationIndex = 0;
   
   protected Piece(int x0, int y0, int hex0, int hex1, int hex2, int hex3) {
      this.grid = new Grid (4,4);
    
      this.rotations = new int[] {hex0, hex1, hex2, hex3};
      
      setBitmap();
    
      this.x0 = x0;
      this.y0 = y0;
      
   }
   
   private void setBitmap() {
      int hex = this.rotations[rotationIndex];
      for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
               boolean square = (hex % 2 == 1);
               hex = hex / 2;
               grid.setSquare(x , y, square);
            }
         }

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
   
   public void rotate(int dr) {
      rotationIndex = (rotationIndex + dr + 4) % 4;
      setBitmap();
   }

}