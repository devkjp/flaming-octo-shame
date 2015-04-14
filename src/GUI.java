import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUI extends JFrame {

	// Constants
	final int marginH = 20;
	final int marginV = 30;

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
		GraphArea gA = new GraphArea(500, 500);
		Bresenham.drawCircle(gA.getPixelArray(), 25,25,2, GraphArea.color.BLACK);
		Bresenham.drawCircle(gA.getPixelArray(), 25,25,4, GraphArea.color.RED);
		Bresenham.drawCircle(gA.getPixelArray(), 25,25,8, GraphArea.color.WHITE);
		Bresenham.drawCircle(gA.getPixelArray(), 25,25,16, GraphArea.color.GRAY);
		Bresenham.drawCircle(gA.getPixelArray(), 25,25,20, GraphArea.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 5, 25, 22, 25, GraphArea.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 30, 25, 45, 25, GraphArea.color.BLACK);
		GUI g = new GUI(gA);
	}

}
