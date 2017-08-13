import java.util.Scanner;
public class KnapsackDynamic{

		int n,w;
		int W[],v[];
		int V[][];

		void initializeData(){
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter no. of items:");
			n=sc.nextInt();
			System.out.print("Enter w of knapsack");
			w=sc.nextInt();
			W=new int[n];
			v=new int[n];
			System.out.println("Enter ws and vs of items");
			for(int i=0;i<n;i++){
				W[i]=sc.nextInt();
				v[i]=sc.nextInt();
			}
			V=new int[n+1][w+1];
			for(int i=0;i<=w;i++)
				V[0][i]=0;
		}
		void knapsacksolution(){
			int x[]=new int[n+1];
			for(int i=1;i<=n;i++){
				for(int j=0;j<=w;j++){
					if((W[i-1]<=j)&&(v[i-1]+V[i-1][j-W[i-1]]>V[i-1][j])){
						V[i][j]=v[i-1]+V[i-1][j-W[i-1]];
						x[i]=1;
					}
					else{
						V[i][j]=V[i-1][j];
						x[i]=0;
					}
				}
			}
			System.out.println("Solution");
			for(int i=1;i<=n;i++){
				for(int j=0;j<=w;j++){
					System.out.printf("%5d",V[i][j]);
				}
				System.out.println("\n");
			}
			System.out.println("Max profit:"+V[n][w]);
		}
		public static void main(String[] args){
			KnapsackDynamic obj=new KnapsackDynamic();
			obj.initializeData();
			obj.knapsacksolution();
		}
}
