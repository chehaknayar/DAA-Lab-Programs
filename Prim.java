import java.util.Scanner;
class Prim
{
	 void myPrim(int adj[][],int N)
	{
		int i,j=0,nv,min=999,mincost=0,u=0,v=0;
		int visit[]=new int[N];
		for(i=0;i<N;i++)
		{
			visit[i]=0;
		}
		visit[0]=1;
		nv=1;
		while(nv<N)
		{
			min=999;
			for(i=0;i<N;i++)
			{
				for(j=0;j<N;j++)
				{
					if(visit[i]==1 && visit[j]==0 && adj[i][j]<min)
					{
						min=adj[i][j];
						u=i;
						v=j;
					}
				}
			}
			if(visit[u]==1 && visit[v]==0)
			{
				visit[v]=1;
				mincost+=min;
				nv++;
				adj[u][v]=999;
				System.out.println("Edge"+u+"-"+v+":"+"("+min+")\n");
			}
		}
		System.out.println("cost:"+mincost);
	}
	public static void main(String args[])
	{
		int[][]adj;
		int N,i,j;
		Prim my=new Prim();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of nodes in the graph");
		N=sc.nextInt();
		adj=new int[N][N];
		System.out.println("Enter matrix");
		System.out.println("Enter 999 for no connection and weights for connection\n");
		for(i=0;i<N;i++)
		{
			for(j=0;j<N;j++)
			{
				adj[i][j]=sc.nextInt();
			}
		}
		my.myPrim(adj,N);
	}
}
