/*package uppgifter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyObserver implements KeyListener {

    private Window window;

    public KeyObserver(Window window){
        super();
        this.window = window;
        //this.addObserver(window.getDisplay());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Moved");

        if(Character.toLowerCase(e.getKeyChar()) == 'w' ||
           Character.toLowerCase(e.getKeyChar()) == 's' ||
           Character.toLowerCase(e.getKeyChar()) == 'd' ||
           Character.toLowerCase(e.getKeyChar()) == 'a'  ){

            window.movePlayer(Character.toLowerCase(e.getKeyChar()));


        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

*/
