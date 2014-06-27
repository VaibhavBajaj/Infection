import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Balls{

	static int infected = 0;

	int x;
	int y;

	int dx;
	int dy;

	float hue;
	float saturation;
	float brightness;

	ArrayList <Balls> balls;

	public Balls() {
		x = (int) (Math.random() * 795);
		y = (int) (Math.random() * 795);

		dx = (int) (Math.random() * 11) - 5;
		dy = (int) (Math.random() * 11) - 5;

		if (Math.random() < 0.01) {
			hue = 0;
			saturation = 1;
			brightness = 1;
		}
		else if (Math.random() < 0.02) {
			hue = 0.3f;
			saturation = 1;
			brightness = 1;
		}
		else {
			hue = 0;
			saturation = 0;
			brightness = 0;
		}
		/*hue = (float)(Math.random());
		saturation = (float)(Math.random());
		brightness = (float)(Math.random());*/
	}

	public void setBalls(ArrayList <Balls> theBalls) {
		balls = theBalls;
	}

	public void paint(Graphics g){

		g.setColor(Color.BLACK);
		g.setColor(Color.getHSBColor(hue, saturation, brightness));
		g.fillOval(x - 5, y - 5, 10, 10);
	}

	public boolean isInfected() {
		if (hue == 0 && saturation == 1 && brightness == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	public void move() {

		x = x + dx;
		y = y + dy;
		if (x >= 795) {
			dx = -dx;
			x = x + dx; 
		}
		if (y >= 795) {
			dy = -dy;
			y = y + dy;
		}
		if (x <= 5) {
			dx = -dx;
			x = x + dx;
		}
		if (y <= 27) {
			dy = -dy;
			y = y + dy;
		}
		if ( dx == 0 && dy == 0 ) {
			dx = 5;
			dy = 5;
		}
		for(Balls b: balls) {

			if(this != b && Math.abs(x - b.x) <= 10 && Math.abs(y - b.y) < 10) {

				dx = (int) (Math.random() * 11) - 5;
				dy = (int) (Math.random() * 11) - 5;
				b.dx = (int) (Math.random() * 11) - 5;
				b.dy = (int) (Math.random() * 11) - 5;
				if( saturation > 0) {
					b.hue = hue;
					b.saturation = saturation;
					b.brightness = brightness;
				}
			}

		}

	}

}
