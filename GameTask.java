import java.util.*;

public class GameTask extends TimerTask {

   private final Runnable task;
   
   public GameTask (Runnable task) {
      this.task = task;
   }
   
   public void run() {
      task.run();
   }
   
}