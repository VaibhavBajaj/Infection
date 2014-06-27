import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;


public class BouncingBalls extends JFrame{
	
	ArrayList <Balls> balls;

	public static void main(String[] args) {

		new BouncingBalls();
		
	}

	public BouncingBalls() {

		super("Bouncing Balls");
		
		balls = new ArrayList <Balls> () ;
		
		for ( int x = 0; x <= 2000; x++) {
			Balls b = new Balls();
			b.setBalls(balls);
			balls.add(b);
		}
		
		setSize(800, 800);
		setVisible(true);
		
	}

	public void paint(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.BLACK);
		g.drawString("Infected: " + balls.get(0).infected, 20, 50);
		for (Balls b : balls) {
			b.paint(g);
			b.move();
		}
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) { }
		
		repaint();
	}

}
