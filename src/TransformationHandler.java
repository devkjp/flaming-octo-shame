import Jama.Matrix;

public class TransformationHandler {
	private int turnBaseX = 0;
	private int turnBaseY = 0;

	private Matrix rotationMat;
	private Matrix scaleMat;
	private Matrix transMat;

	public enum Transformation {
		ROTATE("Rotate"), SCALE("Scale"), TRANSLATE("Translate"), NONE("None");

		String desc;

		private Transformation(String desc) {
			this.desc = desc;
		}

		public String toString() {
			return desc;
		}
	};

	private Transformation[] transformations = { Transformation.ROTATE,
			Transformation.TRANSLATE, Transformation.SCALE };

	public TransformationHandler() {
		initMatrices();
	}

	public Transformation[] getTransformationArray() {
		return transformations;
	}

	public void setTransformationArray(Transformation[] transformations) {
		this.transformations = transformations;
	}

	private Matrix getMatrixByTransformation(Transformation t) {
		switch (t) {
		case ROTATE:
			return rotationMat;
		case SCALE:
			return scaleMat;
		case TRANSLATE:
			return transMat;
		default:
			double[][] ones = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
			return new Matrix(ones);
		}
	}

	public Matrix getTranslationMatrix() {
		return new Matrix(transMat.getArray());
	}

	public Matrix getScaleMatrix() {
		return new Matrix(scaleMat.getArray());
	}

	public Matrix getRotationMat() {
		return new Matrix(rotationMat.getArray());
	}

	public void initMatrices() {
		double[][] transArr = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		transMat = new Matrix(transArr);

		double[][] scaleArr = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		scaleMat = new Matrix(scaleArr);

		double[][] rotationArr = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		rotationMat = new Matrix(rotationArr);
	}

	public void setTransformationBasePoint(int x, int y) {
		this.turnBaseX = x;
		this.turnBaseY = y;
	}

	public void setScale(double sX, double sY) {
		double[][] scaleArr = { { sX, 0, 0 }, { 0, sY, 0 }, { 0, 0, 1 } };
		scaleMat = new Matrix(scaleArr);
	}

	public GraphAreaInterface.color[][] getTransformedCanvas(
			GraphAreaInterface.color[][] canvas) {
		GraphAreaInterface.color[][] resultCanvas = new GraphAreaInterface.color[canvas.length][canvas[0].length];

		for (int i = 0; i < resultCanvas.length; i++) {
			for (int j = 0; j < resultCanvas[i].length; j++) {
				resultCanvas[i][j] = GraphAreaInterface.color.BLANK;
			}
		}

		if (transformations.length > 0) {
			Matrix transformation = getMatrixByTransformation(transformations[0]);
			for (int i = 1; i < transformations.length; i++) {
				transformation = transformation
						.times(getMatrixByTransformation(transformations[i]));
			}

			Matrix vector = new Matrix(3, 1);
			Matrix resultVector = new Matrix(3, 1);
			vector.set(2, 0, 1);
			int newX, newY;
			for (double x = 0; x < resultCanvas[0].length; x++) {
				for (double y = 0; y < resultCanvas.length; y++) {
					vector.set(0, 0, x - this.turnBaseX);
					vector.set(1, 0, y - this.turnBaseY);
					resultVector = transformation.times(vector);
					newX = (int) resultVector.get(0, 0);
					newY = (int) resultVector.get(1, 0);
					int oldX = (int) x;
					int oldY = (int) y;

					if (0 <= newX && newX < resultCanvas[0].length && 0 <= newY
							&& newY < resultCanvas.length) {
						resultCanvas[newX][newY] = canvas[oldX][oldY];
					}
				}
			}
			return resultCanvas;
		} else {
			return canvas;
		}
	}

	public void setAngle(int angle) {
		double cosA = Math.cos(Math.toRadians(angle));
		double sinA = Math.sin(Math.toRadians(angle));

		double[][] rotationArr = { { cosA, -sinA, turnBaseX },
				{ sinA, cosA, turnBaseY }, { 0, 0, 1 } };
		rotationMat = new Matrix(rotationArr);
	}

	public void setTranslation(int x, int y) {
		double[][] transArr = { { 1, 0, x }, { 0, 1, y }, { 0, 0, 1 } };
		transMat = new Matrix(transArr);
	}

}
