public class TransformationHandler {
	private int x = 0;
	private int y = 0;

	public TransformationHandler(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setTransformationBasePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public GraphAreaInterface.color[][] turnCanvasByAngle(
			GraphAreaInterface.color[][] canvas, int alpha) {
		GraphAreaInterface.color[][] resultCanvas  = new GraphAreaInterface.color[canvas.length][canvas[0].length];

		for (int i = 0; i < resultCanvas.length; i++) {
			for (int j = 0; j < resultCanvas[i].length; j++) {
				resultCanvas[i][j] = GraphAreaInterface.color.BLANK;
			}
		}
		double cosA = Math.cos(Math.toRadians(alpha));
		double sinA = Math.sin(Math.toRadians(alpha));

		int xD = this.x;
		int yD = this.y;

		for (double x = 0; x < resultCanvas[0].length; x++) {
			for (double y = 0; y < resultCanvas.length; y++) {
				int newX = (int) (xD + cosA*(x-xD) - sinA*(y-yD));
				int newY = (int) (yD + sinA*(x-xD) + cosA*(y-yD));

				if (0 <= newX && newX < resultCanvas[0].length && 0 <= newY	&& newY < resultCanvas.length) {
					resultCanvas[newX][newY] = canvas[(int)x][(int)y];
				} else {
//					System.out.printf("Result out of Bounds: x %d, y %d\n",
//							newX, newY);
				}
			}
		}

		return resultCanvas;
	}

}
