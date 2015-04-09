import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GraphArea extends JPanel {

	// Constants
	final int graphAreaWidth;
	final int graphAreaHeight;
	final int marginH;
	final int marginV;

	Boolean[][] pixel;

	public GraphArea(int gaWidth, int gaHeight, int marginH, int marginV) {
		this.graphAreaWidth = gaWidth;
		this.graphAreaHeight = gaHeight;
		this.marginH = marginH;
		this.marginV = marginV;
		
		this.setSize(graphAreaWidth + marginH, graphAreaHeight + marginV);
		
		pixel = new Boolean[gaWidth / 10][gaHeight / 10];
		
		for (int i=0; i < pixel.length; i++){
			pixel[i] = new Boolean[gaHeight/10];
			for (int j=0; j<pixel[i].length; j++){
				pixel[i][j] = false;
			}
		}

	}
	
	public Boolean[][] getPixelArray(){
		return pixel;
	};
	
	public void setPixelArray(Boolean[][] pixel){
		this.pixel = pixel;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(Color.black);
		for (int j = 0; j < graphAreaWidth; j = j + 10) {
			g2D.drawRect(j, 10, 10, 10);
			for (int i = 0; i < graphAreaHeight; i = i + 10) {
				g2D.drawRect(j, i, 10, 10);
				if (pixel[j/10][i/10]) {
					g2D.fillRect(j, i, 10, 10);
				}
			}
		}
	}
}