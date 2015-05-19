import java.awt.Point;
import Jama.Matrix;


public class BezierCurve implements DrawerInterface {
	
	private Point[] points;
	
	/***
	 * Purpose: Generates a Bezier Curve Drawer Object based on given control points
	 * @param controlPoints 
	 * The control points for the bezier curve
	 */
	public BezierCurve(Point[] controlPoints){
		this.points = controlPoints;
	}
	
	/***
	 * Purpose: Return the point of the bezier curve to a given u
	 * @param u value of [0,1] determining the point
	 * @return point of curve at value u
	 */
	public Point p(double u){
		
		// Copy points as vectors to working array q
		Matrix[] q = new Matrix[points.length];
		for (int i=0; i<q.length; i++){
			q[i] = new Matrix(2,1);
			q[i].set(0, 0, points[i].getX());
			q[i].set(1,0, points[i].getY());
		}
		
		// Apply de Casteljau Algorithm
		for (int i=1; i<=q.length; i++){
			for (int j=0; j<q.length-i; j++){
				q[j] = q[j].times(1-u).plus(q[j+1].times(u));
			}
		}
		
		return new Point((int)q[0].get(0,0),(int)q[0].get(1, 0));
	}
	
	/***
	 * Purpose: Draw a bezier curve on the given graph area
	 */
	@Override
	public void drawOnto(GraphAreaInterface gA) {
		
		final double dU = 0.1;
		GraphAreaInterface.color[][] canvas = gA.getPixelArray();
		
		// Draw Bezier Curve
		Point start = points[0];
		for (double u=0+dU; u<=1; u+=dU){
			Point end = p(u);
			int startX = (int) Math.round(start.getX());
			int startY = (int) Math.round(start.getY());
			int endX = (int) Math.round(end.getX());
			int endY = (int) Math.round(end.getY());
			
			Bresenham.drawLine(canvas, startX, startY, endX, endY, GraphAreaInterface.color.BLACK);
			start = end;
		}
		
		// Draw Base Points
		for (Point p : points) {
			int x = (int) (p.getX());
			int y = (int) p.getY();
			if (0 <= x && x < canvas[0].length && 0 <= y && y < canvas.length) {
				canvas[x][y] = GraphAreaInterface.color.RED;
			}
		}
		
	}

}
