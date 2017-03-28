import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;

import javax.swing.JComponent;

import java.awt.Graphics2D;
import java.awt.Rectangle;
public class MyFirstComponent extends JComponent {
	
	private static int counter = 0;
	
	private static MutableCar theCars[];
	
	private static Random genRand = new Random();
	
    static boolean SomeCarWon = false;
	
    static final int laneWidth = 40;
	
	 public static boolean getSomeCarWon() { return SomeCarWon; }
	
	public MyFirstComponent(int numCars) {
		theCars = new MutableCar[numCars];
		for(int i=0; i < numCars; i++) {
			int laneY = i * laneWidth;
			theCars[i] = new MutableCar(0, laneY, Color.CYAN, 0, 1);
		}
	}
	
	public boolean carCrash(MutableCar c) {
		if (c.getCarDirection() > 0) {
			if (c.getxPos() + 60 >= this.getWidth()) {
				return true;
			}
		}
		
		else if (c.getCarDirection() < 0) {
			if (c.getxPos() <= 0) {
				return true;
			}
		}
		
		return false;
		
		//return ((c.getCarDirection() > 0) && (c.getxPos() + 60 >= this.getWidth ()) 
		//		|| 
		//		(c.getxPos()<= 0));
	
	}		
	
	public boolean carTopOrBottom(MutableCar c) {
		if (c.getCarDirectionY() > 0) {
			return (c.getyPos() + 30 > this.getHeight());
		}
		else {
			return (c.getyPos() - 30 < 0);
		}
	}
	
	public void paintComponent(Graphics g) {
		
		int iMax = 0;
		for(int i=0; i < theCars.length; i++ ){
			theCars[i].draw(g);
			theCars[i].move(genRand.nextInt(10),0);
			theCars[i].setColor(Color.RED);
			if(theCars[iMax].getxPos() < theCars[i].getxPos()) {
				iMax = i;
			}
			if (this.carCrash(theCars[i])) {
				this.SomeCarWon = true;
			}
		}
		
		theCars[iMax].setColor(Color.GREEN);
		
	System.out.println("Painted " + counter++ + " times");
				
}
	}
		