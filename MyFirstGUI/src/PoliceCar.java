import java.awt.Color;
import java.awt.Graphics;

public class PoliceCar extends MutableCar {
	public PoliceCar(double xPos, double yPos, Color carColor, int speed, int direction) {
		
		super(xPos, yPos, Color.BLUE, speed, direction);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
	}

}
