
public class Fuelleimer {
	
	
	public static void recSeedFill(GraphArea.color[][] canvas, int startX, int startY, GraphArea.color code){
		if (startX >= 0 && startX < canvas[0].length) {
			if (startY >= 0 && startY < canvas.length ){
				canvas[startX][startY] = code;
				
				if (startX - 1 >= 0 && canvas[startX-1][startY] == GraphArea.color.BLANK){
					recSeedFill(canvas, startX-1, startY, code);
				}
				if (startX + 1 < canvas[0].length && canvas[startX+1][startY] == GraphArea.color.BLANK){
					recSeedFill(canvas, startX+1, startY, code);
				}
				if (startY - 1 >= 0 && canvas[startX][startY-1] == GraphArea.color.BLANK){
					recSeedFill(canvas, startX, startY-1, code);
				}
				if (startY + 1 < canvas.length && canvas[startX][startY+1] == GraphArea.color.BLANK){
					recSeedFill(canvas, startX, startY+1, code);
				}
			}
		}
	};

}
