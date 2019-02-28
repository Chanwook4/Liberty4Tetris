public class Square {
   public static final int Size = 25
   
   private final BoundedPoint position;
   
   private final BoundedSize size;
   
   public Square () {
      this.size = new BoundedSize(Size, Size, 3 * Size);
      this.position = new BoundedPoint(100, 100, 300, 300)
   }
}