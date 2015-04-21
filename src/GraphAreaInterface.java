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
	
	protected final TransformationHandler t = new TransformationHandler(0,0);
	
	protected final int pixelWidth;
	protected color[][] pixel;
	
	public GraphAreaInterface(int gaWidth, int gaHeight, int pixelSize) {
		final GraphAreaInterface me = this;
		
		this.graphAreaWidth = gaWidth;
		this.graphAreaHeight = gaHeight;
		
		this.setSize(graphAreaWidth, graphAreaHeight);
		
		this.pixelWidth = pixelSize;
		
		pixel = new color[gaWidth / pixelWidth][gaHeight / pixelWidth];
		
		this.clear();
		
		super.addMouseListener( new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicked");
				int canvasX = e.getX() / pixelWidth;
				int canvasY = e.getY() / pixelWidth;
				me.t.setTransformationBasePoint(canvasX, canvasY);
				for (int i=-2; i<3; i++){
					for (int j=-2; j<3; j++){
						if (0<=canvasX+i && canvasX+i < pixel[0].length && 0<=canvasY+j && canvasY+j<pixel.length)
						pixel[canvasX+i][canvasY+j] = color.TURN;
					}
				}
				me.repaint();
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});

	}
	
	public void rotate(int angle){
		pixel = t.turnCanvasByAngle(pixel, angle);
	}
	
	public void clear(){
		for (int i=0; i < pixel.length; i++){
			pixel[i] = new color[graphAreaHeight/pixelWidth];
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
		case TURN: return Color.BLUE;
		default: return Color.BLACK;
		}
	}

	public abstract void paintComponent(Graphics g);

}