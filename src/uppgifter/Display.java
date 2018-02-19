package uppgifter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Display extends JPanel implements KeyListener {

	private Point playerPosition;
	private Dimension windowSize;
	private Window window;
	private int MOVELENGTH = 100;

	public Display(Window window) {

		this.windowSize = window.getWindowSize();
		this.window = window;

		playerPosition = new Point((int)windowSize.getWidth() / 2 - 50, (int)windowSize.getHeight() / 2 - 50);

		this.addKeyListener(this);
		this.setFocusable(true);

	}

	@Override
	public void paintComponent(Graphics graphics){

		super.paintComponent(graphics);

		JLayeredPane jLayeredPane = new JLayeredPane();

		BufferedImage player = null;
		BufferedImage background = null;

		try {
			player = ImageIO.read(new File("images/Player.png"));
			background = ImageIO.read(new File("images/background.png"));
		} catch (IOException e) {
			System.out.println("Could not draw image.");
			return;
		}

		graphics.drawImage(background, 0, 0, (int)windowSize.getWidth(), (int)windowSize.getHeight(), jLayeredPane);
		graphics.drawImage(player, playerPosition.x, playerPosition.y, 100, 100, jLayeredPane);

		this.add(jLayeredPane);
	}

	public void setPlayerPosition(Point position){
		this.playerPosition = position;
	}

	public void updatePlayerPosition(Point point){
		playerPosition.setLocation(playerPosition.x + point.x, playerPosition.y + point.y);

		this.repaint();
	}

	private boolean checkPlayerPosition(Point delta){
		return (playerPosition.getX() + delta.getX() > 0 &&
				playerPosition.getX() + delta.getX() + 100 <= window.getWindowSize().getWidth() &&
				playerPosition.getY() + delta.getY() > 0 &&
				playerPosition.getY() + delta.getY() + 100 <= window.getWindowSize().getHeight() );
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Point delta = new Point();
		Point negativDelta = new Point();

		switch (Character.toLowerCase(e.getKeyChar())){
			case 'w':

				delta.setLocation(0, 100);
				break;

			case 's':

				delta.setLocation(0, -100);
				break;

			case 'd':

				delta.setLocation(-100, 0);
				break;

			case 'a':

				delta.setLocation(100, 0);
				break;

			default:

				return;

		}

		negativDelta.setLocation(-1 * (int)delta.getX(), -1 * (int)delta.getY());
		//System.out.format("Delta: " + delta.toString() + "		Negativ delta: " + negativDelta.toString());

		if(window.checkWindowPosition(delta) && this.checkPlayerPosition(negativDelta)){

			this.updatePlayerPosition(negativDelta);
			window.moveWindow(delta);

			System.out.format("Window location: %.0f, %.0f		Player location: %.0f, %.0f\n", window.getLocation().getX(), window.getLocation().getY(), playerPosition.getX(), playerPosition.getY());

			this.repaint();

		}


	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
