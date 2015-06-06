import javax.media.j3d.Group;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;

import kern.Visualisierung3D;
import beispiele.BSplinePatch;

/**
 * Einstiegsklasse fuer das Testat Computergrafik TIT12
 * Gruppe: Reutebuch, Schulz, Polkehn
 * 
 * Zweck: Stellt die Main-Methode als Einstiegspunkt bereit
 */

/**
 * @author Jonas
 *
 */
public class Main {

	/**
	 * @param args
	 *            Programmparameter
	 */
	public static void main(String[] args) {

		// B-Spline der GDV-API anlegen
		int gradU = 2;
		int gradV = 2;
		double[] knotenvektorU = new double[] { 0, 0, 6, 6 };
		double[] knotenvektorV = new double[] { 0, 0, 6, 6 };
		Point3d[][] kontrollpunktMatrix = new Point3d[][] {
				{ new Point3d(0, 0, 0), new Point3d(1, 1, 0),
						new Point3d(2, 0, 0) },
				{ new Point3d(0, 1, 1), new Point3d(1, 2, 1),
						new Point3d(2, 1, 1) },
				{ new Point3d(0, 0, 2), new Point3d(1, 1, 2),
						new Point3d(2, 0, 2) } };
		BSplinePatch patch = new BSplinePatch(gradU, gradV, knotenvektorU,
				knotenvektorV, 3, 3, kontrollpunktMatrix);

		// Visualisierung definieren

		Group[] g = new Group[] {
				patch.kontrollPolygon(3, 3, kontrollpunktMatrix),
				patch.kontrollPunkte(0.05f, 3, 3, kontrollpunktMatrix,
						new Color3f(0f, 1f, 0f)),
				patch.segmentierteFlaeche(patch.umin(), patch.vmin(), patch
						.umax(), patch.vmax(), 20, 20, new Color3f(1f, 1f, 0f)) };
		
		// Visualisierung starten
		Visualisierung3D v = new Visualisierung3D(g);
		v.setTitle("Testat Computergrafik TIT12 - Gruppe Reutebuch, Schulz, Polkehn");
	}

}
