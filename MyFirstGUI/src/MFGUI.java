import javax.swing.JFrame;

public class MFGUI {

	public static void main(String[] args) throws InterruptedException {
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(400, 300);
		mainFrame.setTitle("This is HERESY");
		
		int numCars = mainFrame.getHeight() / MyFirstComponent.laneWidth;
		MyFirstComponent theComponent = new MyFirstComponent(numCars);
		mainFrame.add(theComponent);
		
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(!theComponent.getSomeCarWon()) {
			mainFrame.repaint();
			Thread.sleep(100);
		}
	}

}
