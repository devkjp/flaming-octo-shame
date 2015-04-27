import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GraphArea extends GraphAreaInterface {

	public GraphArea(int gaWidth, int gaHeight, DrawerInterface image) {
		super(gaWidth, gaHeight, 5, image);
	}

	@Override
	public void paintComponent(Graphics g) {
		color[][] imgPixel = transformationHandler.getTransformedCanvas(pixel);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(Color.black);
		for (int j = 0; j < graphAreaWidth; j = j + pixelWidth) {
			g2D.drawRect(j, 10, pixelWidth, pixelWidth);
			for (int i = 0; i < graphAreaHeight; i = i + pixelWidth) {
				g2D.drawRect(j, i, pixelWidth, pixelWidth);
				if (imgPixel[j/pixelWidth][i/pixelWidth] != color.BLANK) {
					g2D.setColor( this.getColorFromCode(imgPixel[j/pixelWidth][i/pixelWidth]));
					g2D.fillRect(j, i, pixelWidth, pixelWidth);
					g2D.setColor(Color.BLACK);
				}
			}
		}
	}

}