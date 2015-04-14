import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GraphArea extends JPanel {

	// Constants
	final int graphAreaWidth;
	final int graphAreaHeight;

	public static enum color { BLANK, BLACK, RED, WHITE, GRAY };

	color[][] pixel;
	

	public GraphArea(int gaWidth, int gaHeight) {
		this.graphAreaWidth = gaWidth;
		this.graphAreaHeight = gaHeight;
		
		this.setSize(graphAreaWidth, graphAreaHeight);
		
		pixel = new color[gaWidth / 10][gaHeight / 10];
		
		for (int i=0; i < pixel.length; i++){
			pixel[i] = new color[gaHeight/10];
			for (int j=0; j<pixel[i].length; j++){
				pixel[i][j] = color.BLANK;
			}
		}

	}
	
	private Color getColorFromCode( color code ){
		switch(code){
		case BLACK: return Color.BLACK;
		case RED: return Color.RED;
		case WHITE: return Color.WHITE;
		case GRAY: return Color.GRAY;
		default: return Color.BLACK;
		}
	}
	
	public color[][] getPixelArray(){
		return pixel;
	};
	
	public void setPixelArray(color[][] pixel){
		this.pixel = pixel;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(Color.black);
		for (int j = 0; j < graphAreaWidth; j = j + 10) {
			g2D.drawRect(j, 10, 10, 10);
			for (int i = 0; i < graphAreaHeight; i = i + 10) {
				g2D.drawRect(j, i, 10, 10);
				if (pixel[j/10][i/10] != color.BLANK) {
					g2D.setColor( this.getColorFromCode(pixel[j/10][i/10]));
					g2D.fillRect(j, i, 10, 10);
					g2D.setColor(Color.BLACK);
				}
			}
		}
	}
}