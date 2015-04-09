
public class Bresenham {
	
	public static void drawLine(Boolean[][] canvas, int startX, int startY, int endX, int endY){
		int deltaX = endX - startX;
		int deltaY = endY - startY;
		int eps = deltaY - deltaX;
		int y = startY;
		
		for (int x = startX; x < endX; x++){
			canvas[x][y] = true;
			if (eps > 0){
				y++;
				eps -= deltaX;
			}
			eps += deltaY;
		}
		
	}
	
	public static void drawCircle(Boolean[][] canvas, int midX, int midY, int radius){
		
	};
	
	
}
