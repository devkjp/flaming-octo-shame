import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Jama.Matrix;

public class NewtonInterpolation implements DrawerInterface {

	private Point[] basePoints;
	private int grade;
	private Matrix coefficients;
	private int dX = 1;
	final private double le = 1;

	public NewtonInterpolation(Point[] basePoints) {
		this.basePoints = basePoints;
		grade = this.basePoints.length;
		coefficients = new Matrix(grade + 1, 1);

		doInterpolation();

	}

	private void doInterpolation() {
		/***
		 * TODO: Newton Interpolationsverfahren der dividierten Differenzen -
		 * Koeffizienten in die Matrix coefficients schreiben ((0|0) ist die
		 * höchste Potenz) - Ergebnisse zwischenspeichern - Schleife löschen,
		 * die ist nur platzhalter
		 * 
		 * 
		 *** Pseudocode: 0. Grad: Delta_0 = y_i 1. Grad: Delta_1 = (Delta_0 -
		 * Delta_i-1) / (x_i - x_i-1) 2. Grad: Delta_2 = (
		 * 
		 * Schleife über die Iterationsgrade dX =
		 * 
		 */
		// for(int i=0; i<=coefficients.getRowDimension()-1;i++){
		// coefficients.set(i,0,1.0);
		// }
		List<Double>[] wertListen = new ArrayList[this.grade];

		for (int i=0; i<wertListen.length; i++) {
			wertListen[i] = new ArrayList<Double>();
		}

		for (int i = 0; i < basePoints.length; i++) {
			wertListen[0].add(basePoints[i].getY());
		}

		for (int i = 1; i <= coefficients.getRowDimension() - 1; i++) {
			List<Double> last = wertListen[i - 1];
			Iterator<Double> lastListIterator = last.iterator();
			double lastF = lastListIterator.next();
			int j = i;
			double currentF, newF;
			while (lastListIterator.hasNext()) {
				currentF = lastListIterator.next();
				System.out.println();
				System.out.printf(" (%f - %f) / (%f - %f)\n", currentF, lastF,basePoints[j].getX(), basePoints[j-i].getX());
				newF = ((currentF - lastF)
						/ (basePoints[j].getX() - basePoints[j - i].getX()));
				System.out.printf("= %f\n",newF);

				wertListen[i].add(newF);
				lastF = currentF;
				j++;
			}
		}
		
		for (int i=0; i<wertListen.length; i++) {
			System.out.printf("Liste %d - ",i+1);
			wertListen[i].forEach(x -> System.out.printf("%.3f ", x));
			System.out.println();
		}
		
		double p = wertListen[0].get(0);
		for (int i=0; i<coefficients.getRowDimension()-1; i++){
			System.out.printf("Liste %d\n",this.grade-i);
			coefficients.set(i, 0, wertListen[this.grade-i-1].get(0));
		}
	}

	/*
	 * purpose: calculates the result of the Newton-Interpolation-Polynom
	 */
	private double p(double x) {
		Matrix vectorX = new Matrix(1,grade + 1);
//		System.out.printf("p(%f)...\n",x);

		// set x powers (dt. Potenz)
		vectorX.set(0, grade, 1);
		double xValue = 1;
		for (int i = 0; i < vectorX.getColumnDimension() - 1; i++) {
//			vectorX.set(0, i, Math.pow(x, grade - i));
			vectorX.set(0, i, xValue);
//			System.out.printf("X: %f\n",xValue);
			xValue = xValue * (x - basePoints[i].getX());
		}

		// add up
		return vectorX.times(coefficients).get(0, 0);
	}

	@Override
	public void drawOnto(GraphAreaInterface gA) {
		GraphAreaInterface.color[][] canvas = gA.getPixelArray();
		int x, y;

		// Draw Base Points
		for (Point p : basePoints) {
			x = (int) p.getX();
			y = (int) p.getY();
			if (0 <= x && x < canvas[0].length && 0 <= y && y < canvas.length) {
				canvas[x][y] = GraphAreaInterface.color.RED;
			}
		}

		// Draw Function
		int maxX = gA.getPixelArray()[0].length - 1;
		int maxY = gA.getPixelArray().length - 1;
		int lastX = (int) basePoints[0].getX();
		int lastY = (int) (p(basePoints[0].getX() * le) / le);
		lastY = (lastY <= maxY) ? lastY : maxY;
		lastY = (lastY >= 0) ? lastY : 0;
		int imgY;
		double matX, matY;
		for (int imgX = lastX + dX; imgX < maxX; imgX += dX) {
			matX = imgX * le;
			System.out.printf("p(%f) = ", matX);
			matY = p(matX);
			System.out.println(matY);
			imgY = (int) (matY / le);
			imgX = (imgX <= maxX) ? imgX : maxX;
			imgY = (imgY <= maxY) ? imgY : maxY;
			imgY = (imgY >= 0) ? imgY : 0;
			System.out.printf("%d %d %d %d\n",lastX, lastY, imgX, imgY);
			Bresenham.drawLine(gA.getPixelArray(), lastX, lastY, imgX, imgY,
					GraphAreaInterface.color.BLACK);

			lastX = imgX;
			lastY = imgY;
		}

	}

}
