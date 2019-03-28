public class PlayField {
   private final boolean [] grid; 
   private final int width;
   private final int height;
   
   public PlayField(int width, int height) {
      grid = new boolean [width * height];
      this.width = width;
      this.height = height;
//       this.makeX();

   }
//    
//    private void makeX() {
//       for(int i = 0; i < grid.length; i+= width + 1) {
//          grid [i] = true; 
//       }
//   }
   public boolean getSquare(int x, int y) {
      if(y >= height || x >= width || x < 0) {
         return true;
      } else {
         return grid[y * width + x];
      }
      
   }
   
   public void setSquare(int x, int y, boolean value) {
      grid[y * width + x] = value;
   // complete soon
   }
   
   public int getWidth() {
      return width;
   }
   
   public int getHeight() {
      return height;
   }
}