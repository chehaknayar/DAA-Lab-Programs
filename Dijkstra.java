import java.util.*;
public class Dijkstra
{
	public int distance[]=new int[10];
	public int cost[][]=new int[10][10];
	static int INF_VAL=Integer.MAX_VALUE%100;
	public void calcDist(int n,int s)
	{
		int flag[]=new int[n+1];
		int minpos=1,c,minimum;
		for(int i=1;i<=n;i++)
		{
			flag[i]=0;
			this.distance[i]=this.cost[s][i];
		}
		c=2;
		while(c<=n)
		{
			System.out.println("Hi");
			minimum=INF_VAL;
			for(int k=1;k<=n;k++)
			{
				if((this.distance[k]<minimum)&&(flag[k]!=1))
				{
					minimum=this.distance[k];
					minpos=k;
				}
			}
			c++;
		}
		flag[minpos]=1;
		
		for(int k=1;k<=n;k++)
		{
			if(this.distance[minpos]+this.cost[minpos][k]<distance[k]&&flag[k]!=1)
			this.distance[k]=this.distance[minpos]+this.cost[minpos][k];
		}
	}
	public static void main(String args[])
	{
		int nodes,source,i,j;
		Scanner in= new Scanner(System.in);
		System.out.println("Enter the number of nodes");
		nodes=in.nextInt();
		Dijkstra d= new Dijkstra();
		System.out.println("Enter the cost matrix weights");
		for(i=1;i<=nodes;i++)
		{
			for(j=1;j<=nodes;j++)
			{
				d.cost[i][j]=in.nextInt();
				if(d.cost[i][j]==0)
					d.cost[i][j]=INF_VAL;
			}
		}
		System.out.println("enter the source vertex");
		source=in.nextInt();
		d.calcDist(nodes,source);
		System.out.println("The shortest path cost from <"+source+">to all other vertices are ");
		for(i=1;i<=nodes;i++)
		{
			if(i!=source)
			{
				System.out.println(source+"\t"+i+"\t\t"+d.distance[i]);
			}
		}
	}
}			
