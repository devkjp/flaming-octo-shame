import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class GraphAreaInterface extends JPanel {
	
	public static enum color { BLANK, BLACK, RED, WHITE, GRAY };
	
	// Constants
	final int graphAreaWidth;
	final int graphAreaHeight;
	
	int pixelWidth;
	color[][] pixel;
	
	public GraphAreaInterface(int gaWidth, int gaHeight, int pixelWidth) {
		this.graphAreaWidth = gaWidth;
		this.graphAreaHeight = gaHeight;
		
		this.setSize(graphAreaWidth, graphAreaHeight);
		
		this.pixelWidth = pixelWidth;
		
		pixel = new color[gaWidth / pixelWidth][gaHeight / pixelWidth];
		
		for (int i=0; i < pixel.length; i++){
			pixel[i] = new color[gaHeight/pixelWidth];
			for (int j=0; j<pixel[i].length; j++){
				pixel[i][j] = color.BLANK;
			}
		}

	}
	
	public color[][] getPixelArray(){
		return pixel;
	};
	
	public void setPixelArray(color[][] pixel){
		this.pixel = pixel;
	}

	
	protected Color getColorFromCode( color code ){
		switch(code){
		case BLACK: return Color.BLACK;
		case RED: return Color.RED;
		case WHITE: return Color.WHITE;
		case GRAY: return Color.GRAY;
		default: return Color.BLACK;
		}
	}

	public abstract void paintComponent(Graphics g);

}