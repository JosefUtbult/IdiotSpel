package uppgifter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame {

    private Display display;
    private Point location;
    private Dimension windowSize;
    private Dimension screenSize;

    public Window(){
        super("Idiot-Spel");

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        location = new Point((int)screenSize.getWidth() / 4, (int)screenSize.getHeight() / 4);

        this.setLocation(location);
        this.setSize(new Dimension((int)screenSize.getWidth() / 2, (int)screenSize.getHeight() / 2));
        this.windowSize = new Dimension((int)screenSize.getWidth() / 2, (int)screenSize.getHeight() / 2);

        display = new Display(this);

        //this.setContentPane(display);
        this.getContentPane().add(display);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }


    public Display getDisplay() {
        return display;
    }


    public Dimension getWindowSize() {
        return windowSize;
    }

    public boolean checkWindowPosition(Point point) {
        return (location.getX() + point.getX() >= 0 &&
                location.getX() + point.getX() + 100 < screenSize.getWidth() &&
                location.getY() + point.getY() >= 0 &&
                location.getY() + point.getY() + 100 < screenSize.getHeight());

    }

    public Point getLocation(){
        return location;
    }

    public void moveWindow(Point point){

        location.setLocation(location.getX() + point.getX(), location.getY() + point.getY());
        this.setLocation(location);

    }
}
