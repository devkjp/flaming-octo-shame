public class TransformationHandler {
	private int turnBaseX = 0;
	private int turnBasey = 0;
	private int angle = 0;
	private double scaleX = 1;
	private double scaleY = 1;
	private double transX = 0;
	private double transY = 0;

	public TransformationHandler(int x, int y) {
		this.turnBaseX = x;
		this.turnBasey = y;
	}

	public void setTransformationBasePoint(int x, int y) {
		this.turnBaseX = x;
		this.turnBasey = y;
	}
	
	public void setScale(double sX, double sY){
		this.scaleX = sX;
		this.scaleY = sY;
	}

	public GraphAreaInterface.color[][] getTransformedCanvas(GraphAreaInterface.color[][] canvas) {
		GraphAreaInterface.color[][] resultCanvas  = new GraphAreaInterface.color[canvas.length][canvas[0].length];
		GraphAreaInterface.color[][] stepOneCanvas  = new GraphAreaInterface.color[canvas.length][canvas[0].length];
		GraphAreaInterface.color[][] stepTwoCanvas  = new GraphAreaInterface.color[canvas.length][canvas[0].length];

		for (int i = 0; i < resultCanvas.length; i++) {
			for (int j = 0; j < resultCanvas[i].length; j++) {
				resultCanvas[i][j] = GraphAreaInterface.color.BLANK;
				stepOneCanvas[i][j] = GraphAreaInterface.color.BLANK;
				stepTwoCanvas[i][j] = GraphAreaInterface.color.BLANK;
			}
		}
		rotate(canvas, stepOneCanvas);
		scale(stepOneCanvas, stepTwoCanvas);
		translate(stepTwoCanvas, resultCanvas);

		return resultCanvas;
	}
	
	private void translate(GraphAreaInterface.color[][] canvas,
			GraphAreaInterface.color[][] resultCanvas){
		for (double x = 0; x < resultCanvas[0].length; x++) {
			for (double y = 0; y < resultCanvas.length; y++) {
				int newX = (int) (x + transX);
				int newY = (int) (y + transY);

				if (0 <= newX && newX < resultCanvas[0].length && 0 <= newY	&& newY < resultCanvas.length) {
					resultCanvas[newX][newY] = canvas[(int)x][(int)y];

				}
			}
		}
	}

	
	private void scale(GraphAreaInterface.color[][] canvas,
			GraphAreaInterface.color[][] resultCanvas){
		for (double x = 0; x < resultCanvas[0].length; x++) {
			for (double y = 0; y < resultCanvas.length; y++) {
				int newX = (int) (x * scaleX);
				int newY = (int) (y * scaleY);

				if (0 <= newX && newX < resultCanvas[0].length && 0 <= newY	&& newY < resultCanvas.length) {
					resultCanvas[newX][newY] = canvas[(int)x][(int)y];

				}
			}
		}
	}

	private void rotate(GraphAreaInterface.color[][] canvas,
			GraphAreaInterface.color[][] resultCanvas) {
		double cosA = Math.cos(Math.toRadians(angle));
		double sinA = Math.sin(Math.toRadians(angle));

		int xD = this.turnBaseX;
		int yD = this.turnBasey;

		for (double x = 0; x < resultCanvas[0].length; x++) {
			for (double y = 0; y < resultCanvas.length; y++) {
				int newX = (int) (xD + cosA*(x-xD) - sinA*(y-yD));
				int newY = (int) (yD + sinA*(x-xD) + cosA*(y-yD));

				if (0 <= newX && newX < resultCanvas[0].length && 0 <= newY	&& newY < resultCanvas.length) {
					resultCanvas[newX][newY] = canvas[(int)x][(int)y];

				}
			}
		}
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public void setTranslation(int x, int y) {
		transX = x;
		transY = y;
		
	}

}
