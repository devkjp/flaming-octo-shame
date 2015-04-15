import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class GraphAreaJ2D extends GraphAreaInterface {

	public GraphAreaJ2D(int gaWidth, int gaHeight) {
		super(gaWidth, gaHeight, 1);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(Color.black);
		for (int j = 0; j < pixel[0].length; j++) {
			for (int i = 0; i < pixel.length; i++) {
				if (pixel[j][i] != color.BLANK) {
					g2D.setColor( this.getColorFromCode(pixel[j][i]));
					g2D.drawLine(j, i, j, i);
					g2D.setColor(Color.BLACK);
				}
			}
		}

	}

}
