
public class TestFigure implements DrawerInterface {

	public void drawOnto(GraphAreaInterface gA) {
		Bresenham.drawNiceCircle(gA.getPixelArray(), 250, 250, 249,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 250, 250, 125, 125,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 250, 250, 250, 125,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 250, 250, 375, 125,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 250, 250, 125, 250,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 250, 250, 375, 250,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 250, 250, 125, 375,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 250, 250, 250, 375,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 250, 250, 375, 375,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 125, 125, 375, 125,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 125, 125, 125, 375,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 375, 375, 375, 125,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 375, 375, 125, 375,
				GraphAreaInterface.color.BLACK);

		Fuelleimer.iterSeedFill(gA.getPixelArray(), 126, 127,
				GraphAreaInterface.color.GRAY);
	}

}
