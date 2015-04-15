import java.awt.Point;
import java.util.Stack;

public class Fuelleimer {

	public static void recSeedFill(GraphAreaInterface.color[][] canvas, int startX,
			int startY, GraphAreaInterface.color code) {
		if (startX >= 0 && startX < canvas[0].length) {
			if (startY >= 0 && startY < canvas.length) {
				canvas[startX][startY] = code;

				if (startX - 1 >= 0
						&& canvas[startX - 1][startY] == GraphAreaInterface.color.BLANK) {
					recSeedFill(canvas, startX - 1, startY, code);
				}
				if (startX + 1 < canvas[0].length
						&& canvas[startX + 1][startY] == GraphAreaInterface.color.BLANK) {
					recSeedFill(canvas, startX + 1, startY, code);
				}
				if (startY - 1 >= 0
						&& canvas[startX][startY - 1] == GraphAreaInterface.color.BLANK) {
					recSeedFill(canvas, startX, startY - 1, code);
				}
				if (startY + 1 < canvas.length
						&& canvas[startX][startY + 1] == GraphAreaInterface.color.BLANK) {
					recSeedFill(canvas, startX, startY + 1, code);
				}
			}
		}
	}

	public static void iterSeedFill(GraphAreaInterface.color[][] canvas, int x, int y,
			GraphAreaInterface.color code) {
		Stack<Point> s = new Stack<Point>();
		Point p;
		if (isInCanvas(x, y, canvas))
			s.push(new Point(x, y));
		while (!s.isEmpty()) {
			p = s.pop();
			x = (int) p.getX();
			y = (int) p.getY();
			canvas[x][y] = code;
			if (!isBorder(x - 1, y, canvas))
				s.push(new Point(x - 1, y));
			if (!isBorder(x + 1, y, canvas))
				s.push(new Point(x + 1, y));
			if (!isBorder(x, y - 1, canvas))
				s.push(new Point(x, y - 1));
			if (!isBorder(x, y + 1, canvas))
				s.push(new Point(x, y + 1));
		}

	}

	private static boolean isBorder(int i, int j, GraphAreaInterface.color[][] canvas) {
		return (!isInCanvas(i, j, canvas) || !isBlank(i, j, canvas));
	}

	private static boolean isBlank(int i, int j, GraphAreaInterface.color[][] canvas) {
		return canvas[i][j] == GraphAreaInterface.color.BLANK;
	}

	private static boolean isInCanvas(int i, int j, GraphAreaInterface.color[][] canvas) {
		return (i >= 0 && i < canvas[0].length && j >= 0 && j < canvas.length);
	}
}
