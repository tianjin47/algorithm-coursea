public class Percolation {

	private UF uf;
	private int N;
	private int [][] map;
	
	public Percolation(int N)
	{
		if (N <= 0) 
			throw new IllegalArgumentException();
		this.N = N;
		uf = new UF((N+2)*(N+2));
		map = new int[N+2][N+2];
		map[0][0] = 1;
		map[N+1][0] = 1;
		int i;
		for(i = 1;i <= N;i++)
		{
			int index1 = N+2+i;
			int index2 = 0;
			uf.union(index1, index2);
		}
		for(i = 1;i <= N;i++)
		{
			int index1 = N*(N+2)+i;
			int index2 = (N+1)*(N+2);
			uf.union(index1, index2);
		}
	}
	
	public void open(int i,int j)
	{
		if(i < 1 || i > N || j < 1 || j > N)
			throw new IndexOutOfBoundsException();
		int index1 = i*(N+2)+j;
		int index2;
		if(map[i][j] == 1)
			return;
		map[i][j] = 1;
		if(i-1 >= 1)
		{
			if(map[i-1][j] == 1)
			{
				index2 = (i-1)*(N+2)+j;
				uf.union(index1, index2);	
			}
		}
		if(i+1 <= N)
		{
			if(map[i+1][j] == 1)
			{
				index2 = (i+1)*(N+2)+j;
				uf.union(index1, index2);	
			}
		}
		if(j-1 >= 1)
		{
			if(map[i][j-1] == 1)
			{
				index2 = i*(N+2)+j-1;
				uf.union(index1, index2);	
			}
		}
		if(j+1 <= N)
		{
			if(map[i][j+1] == 1)
			{
				index2 = i*(N+2)+j+1;
				uf.union(index1, index2);	
			}
		}
	}
	
	public boolean isOpen(int i,int j)
	{
		if(i < 1 || i > N || j < 1 || j > N)
			throw new IndexOutOfBoundsException();
		if(map[i][j] == 1)
			return true;
		else
			return false;
	}
	
	public boolean isFull(int i,int j)
	{
		if(i < 1 || i > N || j < 1 || j > N)
			throw new IndexOutOfBoundsException();
		if(N == 1)
			return isOpen(1,1);
		int k;
		int index1 = i*(N+2)+j;
		int index2 = 0;
		if(isOpen(i,j))
			return uf.connected(index1, index2);
		else
			return false;
	}
	
	public boolean percolates()
	{
		if(N == 1)
			return isOpen(1,1);
		int index1 = 0;
		int index2 = (N+1)*(N+2);
		return uf.connected(index1, index2);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("ni hao");
		Percolation p = new Percolation(5);
		//p.open(1, 1);
		//p.open(1, 2);
		p.open(1, 3);
		p.open(2, 3);
		p.open(3, 2);
		p.open(2, 2);
		p.open(5, 1);
		p.open(4, 1);
		p.open(3, 1);
		for(int i = 1;i <= 5;i++)
		{
			for(int j = 1;j <=5;j++)
				System.out.print(p.map[i][j]+" ");
			System.out.print("\n");
		}
		for(int i = 1;i <= 5;i++)
		{
			for(int j = 1;j <=5;j++)
				System.out.print(p.isFull(i,j)+" ");
			System.out.print("\n");
		}
		System.out.print(p.percolates());
	}

}