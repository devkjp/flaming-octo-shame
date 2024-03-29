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
		
		double[] knotenvektorU2 = new double[] { 0, 0,  6, 6 };
		double[] knotenvektorV2 = new double[] { 0, 0, 6, 6 };
		
		// Radius zur Verschiebung
		double r = 1.0;
		double le = 1.0; // Laengeneinheit
		
		
		Point3d[][] kontrollpunkteFlaecheX = new Point3d[][] {
				{new Point3d(r,r,0),       new Point3d(r,0,0),       new Point3d(r,0,r)},
				{new Point3d(r+1*le,r,0),  new Point3d(r+1*le,0,0),  new Point3d(r+1*le,0,r)},
				{new Point3d(r+2*le,r,0),  new Point3d(r+2*le,0,0),  new Point3d(r+2*le,0,r)},
				
		};
		
		BSplinePatch bSplineFlaecheX = new BSplinePatch(gradU, gradV,knotenvektorU, knotenvektorV, 3, 3, kontrollpunkteFlaecheX); 
		
		Point3d[][] kontrollpunkteFlaecheY = new Point3d[][] {
				{new Point3d(r,r,0),       new Point3d(0,r,0),       new Point3d(0,r,r)},
				{new Point3d(r,r+1*le,0),  new Point3d(0,r+1*le,0),  new Point3d(0,r+1*le,r)},
				{new Point3d(r,r+2*le,0),  new Point3d(0,r+2*le,0),  new Point3d(0,r+2*le,r)},
				
		};
		
		BSplinePatch bSplineFlaecheY = new BSplinePatch(gradU, gradV,knotenvektorU, knotenvektorV, 3, 3, kontrollpunkteFlaecheY); 
		
		Point3d[][] kontrollpunkteFlaecheZ = new Point3d[][] {
				{new Point3d(0,r,r),       new Point3d(0,0,r),       new Point3d(r,0,r)},
				{new Point3d(0,r,r+1*le),  new Point3d(0,0,r+1*le),  new Point3d(r,0,r+1*le)},
				{new Point3d(0,r,r+2*le),  new Point3d(0,0,r+2*le),  new Point3d(r,0,r+2*le)},
				
		};
		BSplinePatch bSplineFlaecheZ = new BSplinePatch(gradU, gradV,knotenvektorU, knotenvektorV, 3, 3, kontrollpunkteFlaecheZ); 
		
		Point3d[][] kontrollpunkteFlaecheXZ = new Point3d[][] {
				{ new Point3d(r, 0, r), 		 new Point3d(r + 1*le, 0, r), 	     new Point3d(r + 2*le, 0, r) },
				{ new Point3d(r, 0, r + 1 * le), new Point3d(r + 1*le, 0, r + 1*le), new Point3d(r + 2*le, 0, r + 1*le) },
				{ new Point3d(r, 0, r + 2 * le), new Point3d(r + 1*le, 0, r + 2*le), new Point3d(r + 2*le, 0, r + 2*le) } };

		BSplinePatch bSplineFlaecheXZ = new BSplinePatch(gradU, gradV,
				knotenvektorU, knotenvektorV, 3, 3, kontrollpunkteFlaecheXZ);
		
		Point3d[][] kontrollpunkteFlaecheXY = new Point3d[][] {
				{ new Point3d(0, r, r), 	   new Point3d(0, r + 1*le, r),        new Point3d(0, r + 2*le, r) },
				{ new Point3d(0, r, r + 1*le), new Point3d(0, r + 1*le, r + 1*le), new Point3d(0, r + 2*le, r + 1*le) },
				{ new Point3d(0, r, r + 2*le), new Point3d(0, r + 1*le, r + 2*le), new Point3d(0, r + 2*le, r + 2*le) } };

		BSplinePatch bSplineFlaecheXY = new BSplinePatch(gradU, gradV, knotenvektorU, knotenvektorV, 3, 3, kontrollpunkteFlaecheXY);
		
		Point3d[][] kontrollpunkteFlaecheYZ = new Point3d[][] {
				{ new Point3d(r, r, 0),        new Point3d(r, r + 1*le, 0),        new Point3d(r, r + 2*le, 0) },
				{ new Point3d(r + 1*le, r, 0), new Point3d(r + 1*le, r + 1*le, 0), new Point3d(r + 1*le, r + 2*le, 0) },
				{ new Point3d(r + 2*le, r, 0), new Point3d(r + 2*le, r + 1*le, 0), new Point3d(r + 2*le, r + 2*le, 0) } };

		BSplinePatch bSplineFlaecheYZ = new BSplinePatch(gradU, gradV, knotenvektorU, knotenvektorV, 3, 3, kontrollpunkteFlaecheYZ);
		
		Point3d[][] kontrollpunkteFlaecheDreieck = new Point3d[][] {
				{ new Point3d(r, r, 0), new Point3d(r, 0, 0), new Point3d(r, 0, r)},
				{ new Point3d(0, r, 0), new Point3d(0, 0, 0), new Point3d(0, 0 , r)},
				{ new Point3d(0, r, r), new Point3d(0, r, r), new Point3d(0, r, r)}
		};
		
		BSplinePatch bSplineFlaecheDreieck = new BSplinePatch(2, 2, knotenvektorU2, knotenvektorV2, 3, 3, kontrollpunkteFlaecheDreieck);
		
		// Visualisierung definieren

		Group[] g = new Group[] {
				bSplineFlaecheXZ.kontrollPolygon(3, 3, kontrollpunkteFlaecheXZ),
				bSplineFlaecheXZ.kontrollPunkte(0.05f, 3, 3,	kontrollpunkteFlaecheXZ, new Color3f(1f, 1f, 1f)),
				bSplineFlaecheXZ.segmentierteFlaeche(bSplineFlaecheXZ.umin(), bSplineFlaecheXZ.vmin(),bSplineFlaecheXZ.umax(), bSplineFlaecheXZ.vmax(), 20, 20, new Color3f(1f, 0f,	0f)), 
				
				bSplineFlaecheX.kontrollPolygon(3, 3, kontrollpunkteFlaecheX),
				bSplineFlaecheX.kontrollPunkte(0.05f, 3, 3,	kontrollpunkteFlaecheX, new Color3f(1f, 1f, 1f)),
				bSplineFlaecheX.segmentierteFlaeche(bSplineFlaecheX.umin(), bSplineFlaecheX.vmin(),bSplineFlaecheX.umax(), bSplineFlaecheX.vmax(), 20, 20, new Color3f(1f, 1f,	0f)), 
				
				bSplineFlaecheXY.kontrollPolygon(3, 3, kontrollpunkteFlaecheXY),
				bSplineFlaecheXY.kontrollPunkte(0.05f, 3, 3,	kontrollpunkteFlaecheXY, new Color3f(1f, 1f, 1f)),
				bSplineFlaecheXY.segmentierteFlaeche(bSplineFlaecheXY.umin(), bSplineFlaecheXY.vmin(),bSplineFlaecheXY.umax(), bSplineFlaecheXY.vmax(), 20, 20, new Color3f(0f, 0f,	1f)),
				
				bSplineFlaecheY.kontrollPolygon(3, 3, kontrollpunkteFlaecheY),
				bSplineFlaecheY.kontrollPunkte(0.05f, 3, 3,	kontrollpunkteFlaecheY, new Color3f(1f, 1f, 1f)),
				bSplineFlaecheY.segmentierteFlaeche(bSplineFlaecheY.umin(), bSplineFlaecheY.vmin(),bSplineFlaecheY.umax(), bSplineFlaecheY.vmax(), 20, 20, new Color3f(0f, 1f,	1f)), 

				bSplineFlaecheYZ.kontrollPolygon(3, 3, kontrollpunkteFlaecheYZ),
				bSplineFlaecheYZ.kontrollPunkte(0.05f, 3, 3,	kontrollpunkteFlaecheYZ, new Color3f(1f, 1f, 1f)),
				bSplineFlaecheYZ.segmentierteFlaeche(bSplineFlaecheYZ.umin(), bSplineFlaecheYZ.vmin(),bSplineFlaecheYZ.umax(), bSplineFlaecheYZ.vmax(), 20, 20, new Color3f(0f, 1f,	0f)),
		
				bSplineFlaecheZ.kontrollPolygon(3, 3, kontrollpunkteFlaecheZ),
				bSplineFlaecheZ.kontrollPunkte(0.05f, 3, 3,	kontrollpunkteFlaecheZ, new Color3f(1f, 1f, 1f)),
				bSplineFlaecheZ.segmentierteFlaeche(bSplineFlaecheZ.umin(), bSplineFlaecheZ.vmin(),bSplineFlaecheZ.umax(), bSplineFlaecheZ.vmax(), 20, 20, new Color3f(1f, 0f,	1f)), 
				
				bSplineFlaecheDreieck.kontrollPolygon(3, 3, kontrollpunkteFlaecheDreieck),
				bSplineFlaecheDreieck.kontrollPunkte(0.05f, 3, 3,	kontrollpunkteFlaecheDreieck, new Color3f(1f, 1f, 1f)),
				bSplineFlaecheDreieck.segmentierteFlaeche(bSplineFlaecheDreieck.umin(), bSplineFlaecheDreieck.vmin(),bSplineFlaecheDreieck.umax(), bSplineFlaecheDreieck.vmax(), 20, 20, new Color3f(0.6f, 0.6f, 0.6f))
		
		};

		// Visualisierung starten
		Visualisierung3D v = new Visualisierung3D(g);
		v.setTitle("Testat Computergrafik TIT12 - Gruppe Reutebuch, Schulz, Polkehn");
	}

}
