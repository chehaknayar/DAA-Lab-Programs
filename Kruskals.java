import java.util.*;

class Kruskals {
	
	int g[][] = new int[10][10];
	int t[][] = new int[10][2];
	int parent[] = new int[10];

	class Edge {
		int u,v,wt;
		boolean done=false;
	}
	int n;
	int count=0;
	Edge e[] = new Edge[30];
	
	void create() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of vertices ?\t");
		n=sc.nextInt();
		System.out.println("Enter the Cost Matrix\n");
		int k=0;
		for(int i=0;i<n;++i)
			for(int j=0;j<n;++j) {
				g[i][j] = sc.nextInt();
				if(g[i][j] != 0 && j<=i) {
					e[k] = new Edge();
					e[k].u = i;
					e[k].v = j;
					e[k++].wt = g[i][j];
				}	
			}
		count=k;
		/*for(int i=0;i<count;++i)

			System.out.println(e[i].u+" -- "+e[i].v+"  :  "+e[i].wt);*/
	}
	
	void MST() {
		for(int i=0;i<n;++i)
			parent[i] = i;
		int num = 0;
		while(num<n-1) {
			Edge x = getmin();
			int a=findparent(x.u); int b=findparent(x.v);
			/*System.out.println("a : "+a+" b : "+b);
			for(int ayu=0;ayu<n;++ayu)
				System.out.print(parent[ayu]);*/
			if(a!=b) {
				t[num][0] = x.u;
				t[num][1] = x.v;
				++num;
				union(a,b);
			}
		}
		display();
	}
	
	Edge getmin() {
		int min=999,minpos=-1,i;
		for(i=0;i<count;++i) {
			if(e[i].done==false && e[i].wt < min ) {
				min = e[i].wt;
				minpos = i;
			}
		}
		e[minpos].done = true;
		//System.out.println("\n"+e[minpos].wt);
		return e[minpos];
	}

	void union(int a, int b) {
		parent[b] = a;
	}
	
	int findparent(int i) {
		while(i!=parent[i]) i=parent[i];
		return i;
	}

	void display() {
		System.out.println("The Minimum cost Spanning tree :\n");
		int mincost = 0;
		for(int i=0;i<n-1;++i) {
			mincost+=g[t[i][0]][t[i][1]];
			System.out.println(t[i][0]+" -- "+t[i][1]+" : "+g[t[i][0]][t[i][1]]);
		}
		System.out.println("The Minimum Cost :\t"+mincost);
	}
	
	
	public static void main(String args[]) {
		Kruskals k = new Kruskals();
		k.create();
		k.MST();
	}
}
