import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class GraphAreaJ2D extends GraphAreaInterface {

	public GraphAreaJ2D(int gaWidth, int gaHeight, DrawerInterface image) {
		super(gaWidth, gaHeight, 1, image);
	}

	@Override
	public void paintComponent(Graphics g) {
		GraphAreaInterface.color[][] imgCanvas = this.transformationHandler.getTransformedCanvas(pixel);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(Color.black);
		for (int j = 0; j < pixel[0].length; j++) {
			for (int i = 0; i < pixel.length; i++) {
				if (imgCanvas[j][i] != color.BLANK) {
					g2D.setColor( this.getColorFromCode(imgCanvas[j][i]));
					g2D.drawLine(j, i, j, i);
					g2D.setColor(Color.BLACK);
				}
			}
		}

	}

}
