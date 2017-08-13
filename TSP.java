import java.util.*;
class TSP{
	int c[][];
	int TSP(int k,int s[],int n,int c[][]){
		if(n==1)
			return c[k][s[0]]+c[s[0]][1];
		else{

			int min=99;
			for(int i=0;i<n;i++){
				int t[]=new int[n-1];
				int z=0;
			for(int j=0;j<n;j++)
				if(j!=i){
					t[z]=s[j];
					z++;
				}
				if(min>(c[k][s[i]]+TSP(s[i],t,n-1,c)))
					min=c[k][s[i]]+TSP(s[i],t,n-1,c);
			}
			return min;
		}
	}
	public static void main(String args[]){
		TSP P1=new TSP();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size");
		int n=sc.nextInt();
		int c[][]=new int[n][n];
		System.out.println("Enter matrix");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				c[i][j]=sc.nextInt();
		int s[]= new int[n];
		for(int i=0;i<n;i++)
			s[i]=i;
			int minx;
		minx=P1.TSP(1,s,n,c);
		System.out.println("Shortest path is"+minx);
	}
}
