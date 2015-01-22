public class Brute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);

		In in = new In(args[0]);
		int num = in.readInt();
		Point points[] = new Point[num];
		for (int i = 0; i < num; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
			points[i].draw();
		}

		for (int i = 0; i < num; i++)
			for (int j = 0; j < num - i - 1; j++) {
				if (points[j].compareTo(points[j + 1]) == 1) {
					Point temp = points[j];
					points[j] = points[j + 1];
					points[j + 1] = temp;
				}
			}

		for (int i = 0; i < num; i++)
			for (int j = i + 1; j < num; j++)
				for (int k = j + 1; k < num; k++)
					for (int l = k + 1; l < num; l++) {
						if (points[i].slopeTo(points[j]) == points[j].slopeTo(points[k])
								&& points[j].slopeTo(points[k]) == points[k].slopeTo(points[l])) {
							StdOut.print(points[i].toString() + "->" + points[j].toString() + "->"
									+ points[k].toString() + "->" + points[l].toString() + "\n");
							points[i].drawTo(points[l]);
						}
					}
	}

}
