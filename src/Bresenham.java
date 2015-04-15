public class Bresenham {

	public static void drawLine(GraphArea.color[][] canvas, int startX, int startY,	int endX, int endY, GraphArea.color colorCode) {
	    int w = endX - startX ;
	    int h = endY - startY ;
	    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
	    if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
	    if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
	    if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
	    int longest = Math.abs(w) ;
	    int shortest = Math.abs(h) ;
	    if (!(longest>shortest)) {
	        longest = Math.abs(h) ;
	        shortest = Math.abs(w) ;
	        if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
	        dx2 = 0 ;            
	    }
	    int numerator = longest >> 1 ;
	    for (int i=0;i<=longest;i++) {
	        canvas[startX][startY] = colorCode ;
	        numerator += shortest ;
	        if (!(numerator<longest)) {
	            numerator -= longest ;
	            startX += dx1 ;
	            startY += dy1 ;
	        } else {
	            startX += dx2 ;
	            startY += dy2 ;
	        }
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
