import java.awt.Point;

import Jama.Matrix;


public class NewtonInterpolation implements DrawerInterface {
	
	private Point[] basePoints;
	private int grade;
	private Matrix coefficients;
	private int dX = 1;
	final private double le = 0.02;
	
	public NewtonInterpolation(Point[] basePoints){
		this.basePoints = basePoints;
		grade = this.basePoints.length;
		coefficients = new Matrix(grade+1, 1);
		
		doInterpolation();
		
	}

	private void doInterpolation() {
		/***
		 * TODO: Newton Interpolationsverfahren der dividierten Differenzen
		 * - Koeffizienten in die Matrix coefficients schreiben ((0|0) ist die höchste Potenz)
		 * - Ergebnisse zwischenspeichern
		 * - Schleife löschen, die ist nur platzhalter
		 */
		for(int i=0; i<=coefficients.getRowDimension()-1;i++){
			coefficients.set(i,0,1.0);
		}
	}
	
	private double f(double x){
		Matrix vectorX = new Matrix(grade+1,1);
		Matrix ones = new Matrix(1, grade+1);
		
		// set ones
		for (int i=0; i<ones.getColumnDimension(); i++){
			ones.set(0,i,1);
		}
		
		// set x powers
		vectorX.set(grade, 0, 1);
		for(int i=0; i<vectorX.getRowDimension()-1;i++){
			vectorX.set(i,0,Math.pow(x, grade-i));
		}
		
		// add up
		return vectorX.times(ones).get(0, 0);
	}

	@Override
	public void drawOnto(GraphAreaInterface gA) {
		GraphAreaInterface.color[][] canvas = gA.getPixelArray();
		int x,y;
		
		// Draw Base Points
		for (Point p: basePoints){
			x = (int) p.getX(); y = (int) p.getY();
			if ( 0 <= x && x < canvas[0].length && 0 <= y && y < canvas.length ){
				canvas[x][y] = GraphAreaInterface.color.RED;
			}
		}
		
		// Draw Function
		int maxX = gA.getPixelArray()[0].length-1;
		int maxY = gA.getPixelArray().length-1;
		int lastX = (int) basePoints[0].getX(); int lastY = (int) (f(basePoints[0].getX()*le)/le);
		int imgY; 
		double matX, matY;
		for (int imgX = lastX+dX; imgX <= basePoints[basePoints.length-1].getX(); imgX+=dX){
			matX = imgX * le; matY = f(matX);
			imgY = (int) (matY / le);
			imgX = (imgX<=maxX)?imgX:maxX;
			imgY = (imgY<=maxY)?imgY:maxY;
			
			Bresenham.drawLine(gA.getPixelArray(), lastX, lastY, imgX, imgY, GraphAreaInterface.color.BLACK);
			
			lastX = imgX; lastY = imgY;
		}

	}

}
