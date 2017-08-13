import java.util.*;

public class SumofSubsets{

	int[]x;
	int[]w;
	int sum;

	private void getData(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the no. of elements: ");
		int n=sc.nextInt();
		w=new int[n+1];
		x=new int[n+1];
		int total=0;
		System.out.println("Enter " + n + " elements in non decreasing order");
		for(int i=1;i<n+1;i++){

			w[i]=sc.nextInt();
			total+=w[i];
		}
		System.out.println("Enter the sum to obtain: ");
		sum=sc.nextInt();
		if (total<sum){
			System.out.println("Not possible to obtain subset");
			System.exit(1);
		}
		Subset(0,1,total);
	}
	private void Subset(int s,int k, int r){
		try {
			x[k]=1;
			if(s + w[k] == sum){
				System.out.println();
				for(int i=1;i<=k;i++){
					if(x[i]==1)
						System.out.print("\t"+w[i]);
				}
			}
			else if((s + w[k] + w[k+1]) <= sum){
				Subset(s + w[k], k + 1, r - w[k]);
			}
			if((s + r - w[k]) >= sum && (s + w[k+1]) <= sum){
				x[k]=0;
				Subset(s, k + 1, r - w[k]);
			}
		}
		catch (Exception e) {
			System.out.println("\nk = " + k);
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		new SumofSubsets().getData();
	}
}
