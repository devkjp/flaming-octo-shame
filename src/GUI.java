import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUI extends JFrame {

	// Constants
	final int marginH = 20;
	final int marginV = 30;

	public GUI( GraphAreaInterface gA) {
		int graphAreaWidth = gA.getWidth();
		int graphAreaHeight = gA.getHeight();
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(0, 0, graphAreaWidth + marginH, graphAreaHeight + marginV);
		Container content = this.getContentPane();
		content.add(gA);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		
		// Pokeball
		GraphAreaInterface gA = new GraphArea(500, 500);
		Bresenham.drawNiceCircle(gA.getPixelArray(), 25,25,2, GraphAreaInterface.color.BLACK);
		Fuelleimer.iterSeedFill(gA.getPixelArray(), 25, 25, GraphAreaInterface.color.BLACK);
		Bresenham.drawNiceCircle(gA.getPixelArray(), 25,25,5, GraphAreaInterface.color.BLACK);
		Fuelleimer.iterSeedFill(gA.getPixelArray(), 25, 22, GraphAreaInterface.color.WHITE);
		Bresenham.drawNiceCircle(gA.getPixelArray(), 25,25,20, GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 5, 25, 20, 25, GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 30, 25, 45, 25, GraphAreaInterface.color.BLACK);
		Fuelleimer.iterSeedFill(gA.getPixelArray(), 0, 20, GraphAreaInterface.color.GRAY);
		Fuelleimer.iterSeedFill(gA.getPixelArray(), 6, 24, GraphAreaInterface.color.RED);
		Fuelleimer.iterSeedFill(gA.getPixelArray(), 6, 26, GraphAreaInterface.color.WHITE);
		GUI g = new GUI(gA);
		
		// Linientest, auskommentieren wenn nicht GraphAreaJ2D verwendet wird (Pixelgröße)
		GraphAreaInterface gA2 = new GraphAreaJ2D(500,500);
		Bresenham.drawNiceCircle(gA2.getPixelArray(), 250,250,249, GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 250,250,125,125,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 250,250,250,125,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 250,250,375,125,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 250,250,125,250,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 250,250,375,250,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 250,250,125,375,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 250,250,250,375,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 250,250,375,375,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 125,125,375,125,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 125,125,125,375,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 375,375,375,125,GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA2.getPixelArray(), 375,375,125,375,GraphAreaInterface.color.BLACK);
		
		Fuelleimer.iterSeedFill(gA2.getPixelArray(), 126, 127, GraphAreaInterface.color.GRAY);
		
		GUI g2 = new GUI(gA2);
		
		
		
		
	}

}
