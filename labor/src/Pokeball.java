
public class Pokeball implements DrawerInterface {

	@Override
	public void drawOnto(GraphAreaInterface gA) {
		Bresenham.drawNiceCircle(gA.getPixelArray(), 25, 25, 2,
				GraphAreaInterface.color.BLACK);
		Fuelleimer.iterSeedFill(gA.getPixelArray(), 25, 25,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawNiceCircle(gA.getPixelArray(), 25, 25, 5,
				GraphAreaInterface.color.BLACK);
		Fuelleimer.iterSeedFill(gA.getPixelArray(), 25, 22,
				GraphAreaInterface.color.WHITE);
		Bresenham.drawNiceCircle(gA.getPixelArray(), 25, 25, 20,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 5, 25, 20, 25,
				GraphAreaInterface.color.BLACK);
		Bresenham.drawLine(gA.getPixelArray(), 30, 25, 45, 25,
				GraphAreaInterface.color.BLACK);
		Fuelleimer.iterSeedFill(gA.getPixelArray(), 0, 20,
				GraphAreaInterface.color.GRAY);
		Fuelleimer.iterSeedFill(gA.getPixelArray(), 6, 24,
				GraphAreaInterface.color.RED);
		Fuelleimer.iterSeedFill(gA.getPixelArray(), 6, 26,
				GraphAreaInterface.color.WHITE);
	}

}
