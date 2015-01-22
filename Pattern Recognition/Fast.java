import java.util.Arrays;

public class Fast {

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

		// for(int i = 0;i < num;i++)
		// StdOut.print(points[i].toString()+"\n");

		for (int i = 0; i < num; i++) {
			Point temp[] = new Point[num];
			for (int j = 0; j < num; j++)
				temp[j] = points[j];
			Arrays.sort(temp, points[i].SLOPE_ORDER);
			// for(int j = 0;j < num;j++)
			// StdOut.print(temp[j].toString()+"\n");
			for (int j = 1; j < num - 2; j++) 
			{
				if (temp[0].compareTo(temp[j]) == -1 && temp[j].compareTo(temp[j + 1]) == -1
						&& temp[j + 1].compareTo(temp[j + 2]) == -1) 
				{
					int k = -1;
					if (temp[0].slopeTo(temp[j]) == temp[j].slopeTo(temp[j + 1])
							&& temp[j].slopeTo(temp[j + 1]) == temp[j + 1].slopeTo(temp[j + 2])) 
					{
							k = j + 2;
							while (temp[k].compareTo(temp[k + 1]) == -1 && (k + 1) < num && temp[k - 1].slopeTo(temp[k]) == temp[k].slopeTo(temp[k + 1]))
								k++;
					}
					if(k != -1)
					{
						StdOut.print(temp[0].toString() + "->");
						temp[0].drawTo(temp[j]);
					}
					
					while(j < k)
					{
						StdOut.print(temp[j].toString() + "->");
						temp[j].drawTo(temp[j+1]);
						j++;
					}
					if(k != -1)
						StdOut.print(temp[k].toString());
					StdOut.print("\n");
						
				}
			}
		}
	}
}
