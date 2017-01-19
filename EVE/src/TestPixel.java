        import java.awt.Color;
        import java.awt.MouseInfo;
        import java.awt.Point;
        import java.awt.PointerInfo;
        import java.awt.Robot;

public class TestPixel {
    public static void main(String[] args) throws Exception {
        PointerInfo pointer;
        pointer = MouseInfo.getPointerInfo();
        Point coord = pointer.getLocation();

        Robot robot = new Robot();
        robot.delay(2000);

        while(true) {
            coord = MouseInfo.getPointerInfo().getLocation();
            Color color = robot.getPixelColor((int)coord.getX(), (int)coord.getY());
            if(color.getGreen() == 255 && color.getBlue() == 255 && color.getRed() == 255) {
                System.out.println("WHITE FOUND");
            }
            robot.delay(1000);
        }
    }
}