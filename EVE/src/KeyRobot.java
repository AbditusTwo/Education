import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyRobot {

    private Robot robot;

    public static void main(String[] args) {
        new KeyRobot();
        // new Undock();
    }

    public KeyRobot() {
        try {
            robot = new Robot();
            robot.setAutoDelay(50);
            //robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
            robot.keyPress(KeyEvent.VK_2);
            robot.keyRelease(KeyEvent.VK_2);
            robot.keyPress(KeyEvent.VK_3);
            robot.keyRelease(KeyEvent.VK_3);
            //robot.keyRelease(KeyEvent.VK_ALT);
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }

 //   public Undock() {
  //      try {
     //       robot = new Robot();
        //    robot.setAutoDelay(50);
        //    robot.keyPress(KeyEvent.VK_3);
          //  robot.keyRelease(KeyEvent.VK_3);
      //  } catch (AWTException ex) {
     //       ex.printStackTrace();
     //   }
   // }
}
