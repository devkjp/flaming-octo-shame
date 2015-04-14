public class Bresenham {

	public static void drawLine(GraphArea.color[][] canvas, int startX, int startY,	int endX, int endY, GraphArea.color colorCode) {
		// Steigungsdreieck berechnen ( m = deltaY / deltaX ) 
		int deltaX = endX - startX;
		int deltaY = endY - startY;
		
		// Fehlervariable initialisierun
		int eps = deltaY - deltaX;
		int y = startY;
		
		// Laufe von startX bis endX schritt für schritt
		for (int x = startX; x < endX; x++) {
			// Setze das aktuelle Pixel
			canvas[x][y] = colorCode; 
			
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

	public static void drawCircle(GraphArea.color[][] canvas, int midX, int midY, int radius, GraphArea.color colorCode) {
		// Vorbild: http://www-lehre.inf.uos.de/~cg/2002/skript/node37.html
		
		// Startkoordinaten
		int xh = 0; int yh = radius;
		int eps = 1 - radius; // Fehlervariable

		while (yh >= xh) {
			// Setze für jedes X ein Pixel in allen Oktanten
			canvas[midX + xh][midY + yh] = colorCode; 
			canvas[midX + yh][midY + xh] = colorCode; 
			canvas[midX + yh][midY - xh] = colorCode;
			canvas[midX + xh][midY - yh] = colorCode;
			canvas[midX - xh][midY - yh] = colorCode;
			canvas[midX - yh][midY - xh] = colorCode;
			canvas[midX - yh][midY + xh] = colorCode;
			canvas[midX - xh][midY + yh] = colorCode;

			if (eps < 0) {
				// Die Kreislinie wurde noch nicht verlassen
				eps += 2*xh + 3;
			} else {
				// Die Kreislinie wurde verlassen, yh muss vermindert werden
				yh--; 
				eps = 2*xh - 2*yh +5;
			}
			xh++;
		}

	};

}
