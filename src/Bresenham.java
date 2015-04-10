public class Bresenham {

	public static void drawLine(Boolean[][] canvas, int startX, int startY,
			int endX, int endY) {
		int deltaX = endX - startX;
		int deltaY = endY - startY;
		int eps = deltaY - deltaX;
		int y = startY;

		for (int x = startX; x < endX; x++) {
			canvas[x][y] = true;
			if (eps > 0) {
				y++;
				eps -= deltaX;
			}
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
