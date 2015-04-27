import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public abstract class GraphAreaInterface extends JPanel {
	
	public static enum color { BLANK, BLACK, RED, WHITE, GRAY, TURN };
	
	// Constants
	protected final int graphAreaWidth;
	protected final int graphAreaHeight;
	
	protected int angle;
	protected final TransformationHandler transformationHandler = new TransformationHandler();
	
	protected final DrawerInterface image;
	
	protected final int pixelWidth;
	protected color[][] pixel;
	
	public GraphAreaInterface(int gaWidth, int gaHeight, int pixelSize, DrawerInterface image) {
		this.image = image;
		this.graphAreaWidth = gaWidth;
		this.graphAreaHeight = gaHeight;
		
		this.setSize(graphAreaWidth, graphAreaHeight);
		
		this.pixelWidth = pixelSize;
		
		pixel = new color[gaWidth / pixelWidth][gaHeight / pixelWidth];
		
		this.reset();
		
	}
	
	public TransformationHandler getTransformationHandler(){
		return transformationHandler;
	}
	
	public void rotate(int angle){
		transformationHandler.setAngle(angle);
	}
	
	public void scale(double x, double y){
		transformationHandler.setScale(x, y);
	}
	
	public void translate(int x, int y){
		transformationHandler.setTranslation(x,y);
	}
	
	public void reset(){
		for (int i=0; i < pixel.length; i++){
			pixel[i] = new color[graphAreaHeight/pixelWidth];
			for (int j=0; j<pixel[i].length; j++){
				pixel[i][j] = color.BLANK;
			}
		}
		
		transformationHandler.setTransformationBasePoint(0, 0);
		transformationHandler.initMatrices();
		
		image.drawOnto(this);
	}
	
	public color[][] getPixelArray(){
		return pixel;
	};
	
	public void setPixelArray(color[][] pixel){
		this.pixel = pixel;
	}
	
	public void setTransformationBasePoint(int canvasX, int canvasY){
		reset();
		transformationHandler.setTransformationBasePoint(canvasX, canvasY);
		for (int i=0; i<1; i++){
			for (int j=0; j<1; j++){
				System.out.printf("X: %d - Y: %d \n", canvasX, canvasY);
				if (0<=canvasX+i && canvasX+i < pixel[0].length && 0<=canvasY+j && canvasY+j<pixel.length)
				pixel[canvasX+i][canvasY+j] = color.TURN;
			}
		}
		rotate(0);
		repaint();
	}
	
	protected Color getColorFromCode( color code ){
		switch(code){
		case BLACK: return Color.BLACK;
		case RED: return Color.RED;
		case WHITE: return Color.WHITE;
		case GRAY: return Color.GRAY;
		case TURN: return Color.BLUE;
		default: return Color.GREEN;
		}
	}

	public abstract void paintComponent(Graphics g);

	public int getPixelWidth() {
		return pixelWidth;
	}

}