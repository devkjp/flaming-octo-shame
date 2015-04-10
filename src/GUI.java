import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUI extends JFrame {

	// Constants
	final int marginH = 10;
	final int marginV = 10;

	public GUI( GraphArea gA) {
		int graphAreaWidth = gA.getWidth();
		int graphAreaHeight = gA.getHeight();
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(0, 0, graphAreaWidth + marginH, graphAreaHeight + marginV);
		Container content = this.getContentPane();
		content.add(gA);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		GraphArea gA = new GraphArea(500, 400, 10, 10);
//		Bresenham.drawLine(gA.getPixelArray(), 5, 30, 30, 5);
		Bresenham.drawCircle(gA.getPixelArray(), 20, 20, 10);
		GUI g = new GUI(gA);
	}

}
