import java.util.Comparator;

public class Point implements Comparable<Point> {

	public final Comparator<Point> SLOPE_ORDER = new PointCmp();

	private final int x; // x coordinate
	private final int y; // y coordinate

	public Point(int x, int y) {
		/* DO NOT MODIFY */
		this.x = x;
		this.y = y;
	}

	public void draw() {
		/* DO NOT MODIFY */
		StdDraw.point(x, y);
	}

	public void drawTo(Point that) {
		/* DO NOT MODIFY */
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	public double slopeTo(Point that) {
		/* YOUR CODE HERE */
		if (this.compareTo(that) == 0)
			return Double.POSITIVE_INFINITY*-1;
		else if (this.x == that.x)
			return Double.POSITIVE_INFINITY;
		else if (this.y == that.y)
			return +0;
		else
			return (that.y - this.y) * 1.0 / (that.x - this.x);
	}

	private class PointCmp implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			if (slopeTo(o1) < slopeTo(o2) || (slopeTo(o1) == slopeTo(o2) && o1.compareTo(o2) == -1))
				return -1;
			else if (slopeTo(o1) > slopeTo(o2) || (slopeTo(o1) == slopeTo(o2) && o1.compareTo(o2) == 1))
				return 1;
			else
				return 0;
		}

	}

	@Override
	public int compareTo(Point that) {
		// TODO Auto-generated method stub
		if (this.y < that.y || (this.y == that.y && this.x < that.x))
			return -1;
		else if (this.y == that.y && this.x == that.x)
			return 0;
		else
			return 1;
	}

	public String toString() {
		/* DO NOT MODIFY */
		return "(" + x + ", " + y + ")";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in = new In(args[0]);
		int num = in.readInt();
		Point points[] = new Point[num];
		for (int i = 0; i < num; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}
		
		
	}

}
