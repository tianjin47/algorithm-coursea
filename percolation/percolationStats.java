import java.util.Random;


public class PercolationStats {
	
	private int N;
	private int T;
	private long []count;
	
	public PercolationStats(int N, int T)
	{
		if(N <= 0 || T <= 0)
			throw new IllegalArgumentException();
		count = new long[T];
		this.N = N;
		this.T = T;
		for(int k = 0;k < T;k++)
		{
			Percolation p = new Percolation(N);
			while(!p.percolates())
			{
				//Random random = new Random();
				int i = (int) ((Math.random()*N)+1);
				int j = (int) ((Math.random()*N)+1);
				if(!p.isOpen(i, j))
				{
					p.open(i, j);
					count[k]++;
				}	
			}
		}
	}
	
	public double mean()
	{
		double u;
		long sum = 0;
		for(int i = 0;i < T;i++)
			sum += count[i];
		u = (sum*1.0/T)/(N*N);
		return u;
	}
	
	public double stddev()
	{
		double u = mean();
		double sum = 0;
		for(int i = 0;i < T;i++)
		{
			double x = count[i]*1.0/(N*N);
			sum = sum + (x-u)*(x-u);
		}
		double stddev = Math.sqrt(sum/(T-1));
		return stddev;
	}
	
	public double confidenceLo()
	{
		double u = mean();
		double stddev = stddev();
		double lo = u - (1.96*stddev/Math.sqrt(T));
		return lo;
	}
	
	public double confidenceHi()
	{
		double u = mean();
		double stddev = stddev();
		double hi = u + (1.96*stddev/Math.sqrt(T));
		return hi;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("hello");
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		PercolationStats p = new PercolationStats(N,T);
		System.out.print("mean:\t\t\t\t\t");
		System.out.print("= "+p.mean()+"\n");
		System.out.print("stddev:\t\t\t\t\t");
		System.out.print("= "+p.stddev()+"\n");
		System.out.print("95% confidence interval\t\t\t");
		System.out.print("= "+p.confidenceLo()+",");
		System.out.print(p.confidenceHi()+"\n");
	}

}
