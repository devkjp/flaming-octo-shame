public class Bresenham {

	public static void drawLine(Boolean[][] canvas, int startX, int startY,	int endX, int endY) {
		// Only works in Octant I
		
		// Steigungsdreieck berechnen ( m = deltaY / deltaX ) 
		int deltaX = endX - startX;
		int deltaY = endY - startY;
		
		// Fehlervariable initialisierun
		int eps = deltaY - deltaX;
		int y = startY;
		
		// Laufe von startX bis endX schritt für schritt
		for (int x = startX; x < endX; x++) {
			// Setze das aktuelle Pixel
			canvas[x][y] = true; 
			
			// Erreicht Fehler den Schwellwert?
			if (eps > 0) {
				// Springe ein Pixel nach oben und resette Fehler
				y++;
				eps -= deltaX;
			}
			// Fehler erhöhen
			eps += deltaY;
		}
	}

	public static void drawCircle(Boolean[][] canvas, int midX, int midY, int radius) {
		// Source: 
		// http://www-lehre.inf.uos.de/~cg/2002/skript/node37.html

		int xh, yh, d, dx, dxy;

		xh = 0; // Koordinaten retten
		yh = radius;
		d = 1 - radius;
		dx = 3;
		dxy = -2 * radius + 5;

		while (yh >= xh) { // Fuer jede x-Koordinate
			canvas[midX + xh][midY + yh] = true; // alle 8 Oktanden werden
			canvas[midX + yh][midY + xh] = true; // gleichzeitig gesetzt
			canvas[midX + yh][midY - xh] = true;
			canvas[midX + xh][midY - yh] = true;
			canvas[midX - xh][midY - yh] = true;
			canvas[midX - yh][midY - xh] = true;
			canvas[midX - yh][midY + xh] = true;
			canvas[midX - xh][midY + yh] = true;

			if (d < 0) { // Falls noch im Kreis
				d += dx;
				dx += 2;
				dxy += 2;
				xh++; // passend aktualisieren
			} else { // Aus dem Kreis gelaufen
				d += dxy;
				dx += 2;
				dxy += 4;
				xh++;
				yh--; // passend aktualisieren
			}
		}

	};

}
