import java.awt.Point;


public class NewtonInterpolation implements DrawerInterface {
	
	private Point[] basePoints;
	
	public NewtonInterpolation(Point[] basePoints){
		this.basePoints = basePoints;
	}

	@Override
	public void drawOnto(GraphAreaInterface gA) {
		GraphAreaInterface.color[][] canvas = gA.getPixelArray();
		int x,y;
		for (Point p: basePoints){
			x = (int) p.getX(); y = (int) p.getY();
			if ( 0 <= x && x < canvas[0].length && 0 <= y && y < canvas.length ){
				canvas[x][y] = GraphAreaInterface.color.RED;
			}
		}

	}

}
