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
				{ new Point3d(0, 0, 0), new Point3d(1, 1, 0), new Point3d(2, 0, 0) },
				{ new Point3d(0, 0.5, 1), new Point3d(1, 2, 1),	new Point3d(2, 0.5, 1) },
				{ new Point3d(0, 0, 2), new Point3d(1, 1, 2), new Point3d(2, 0, 2) } };

		// Flaeche auf Y- Achse
		Point3d[][] kontrollpunkteFlaecheY = new Point3d[][] {
				{ new Point3d(0, 0, 0), new Point3d(1, 0, 0), new Point3d(2, 0, 0) },
				{ new Point3d(0, 0, 1), new Point3d(1, 0, 1), new Point3d(2, 0, 1) },
				{ new Point3d(0, 0, 2), new Point3d(1, 0, 2), new Point3d(2, 0, 2) } };

		BSplinePatch bSplineFlaecheY = new BSplinePatch(gradU, gradV,
				knotenvektorU, knotenvektorV, 3, 3, kontrollpunkteFlaecheY);

		// Flaeche auf Y- Achse
		Point3d[][] kontrollpunkteFlaecheX = new Point3d[][] {
				{ new Point3d(0, 0, 0), new Point3d(0, 1, 0), new Point3d(0, 2, 0) },
				{ new Point3d(0, 0, 1), new Point3d(0, 1, 1), new Point3d(0, 2, 1) },
				{ new Point3d(0, 0, 2), new Point3d(0, 1, 2), new Point3d(0, 2, 2) } };

		BSplinePatch bSplineFlaecheX = new BSplinePatch(gradU, gradV, knotenvektorU, knotenvektorV, 3, 3, kontrollpunkteFlaecheX);
		
		// Flaeche auf Z- Achse
		Point3d[][] kontrollpunkteFlaecheZ = new Point3d[][] {
				{ new Point3d(0, 0, 0), new Point3d(0, 1, 0), new Point3d(0, 2, 0) },
				{ new Point3d(1, 0, 0), new Point3d(1, 1, 0), new Point3d(1, 2, 0) },
				{ new Point3d(2, 0, 0), new Point3d(2, 1, 0), new Point3d(2, 2, 0) } };

		BSplinePatch bSplineFlaecheZ = new BSplinePatch(gradU, gradV, knotenvektorU, knotenvektorV, 3, 3, kontrollpunkteFlaecheZ);
		
		
		
		// Visualisierung definieren

		Group[] g = new Group[] {
				bSplineFlaecheX.kontrollPolygon(3, 3, kontrollpunkteFlaecheX),
				bSplineFlaecheX.kontrollPunkte(0.05f, 3, 3,	kontrollpunkteFlaecheX, new Color3f(0f, 1f, 0f)),bSplineFlaecheX.segmentierteFlaeche(bSplineFlaecheX.umin(), bSplineFlaecheX.vmin(),bSplineFlaecheX.umax(), bSplineFlaecheX.vmax(), 20, 20, new Color3f(1f, 1f,	0f)), 
				
				bSplineFlaecheY.kontrollPolygon(3, 3, kontrollpunkteFlaecheY),
				bSplineFlaecheY.kontrollPunkte(0.05f, 3, 3,	kontrollpunkteFlaecheY, new Color3f(1f, 0f, 0f)),bSplineFlaecheY.segmentierteFlaeche(bSplineFlaecheY.umin(), bSplineFlaecheY.vmin(),bSplineFlaecheY.umax(), bSplineFlaecheY.vmax(), 20, 20, new Color3f(1f, 0f,	1f)),

				bSplineFlaecheZ.kontrollPolygon(3, 3, kontrollpunkteFlaecheZ),
				bSplineFlaecheZ.kontrollPunkte(0.05f, 3, 3,	kontrollpunkteFlaecheZ, new Color3f(0f, 0f, 1f)),bSplineFlaecheZ.segmentierteFlaeche(bSplineFlaecheZ.umin(), bSplineFlaecheZ.vmin(),bSplineFlaecheZ.umax(), bSplineFlaecheZ.vmax(), 20, 20, new Color3f(0f, 1f,	1f))
		};

		// Visualisierung starten
		Visualisierung3D v = new Visualisierung3D(g);
		v.setTitle("Testat Computergrafik TIT12 - Gruppe Reutebuch, Schulz, Polkehn");
	}

}
