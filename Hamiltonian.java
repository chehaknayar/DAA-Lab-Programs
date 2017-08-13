import java.util.*;

class Hamiltonian {
	
	int x[],n,G[][];
	static int count = 0;

	void readData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number of Vertices :\t");
		n = sc.nextInt();
		G = new  int [n][n];
		x = new int[n];	
		
		System.out.println("Enter Adjacency Matrix :");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				G[i][j] = sc.nextInt();
		x[0] = 0;
		hamil(1);
		if(count == 0) {
			System.out.println("\nNo path Exists !!");
		}
	}

	void hamil(int k) {
		while(true){
			nextValue(k);
			if(x[k] == 0)
				return;

			if(k == n-1) display();
			else hamil(k+1);
		}
	}

	void nextValue(int k) {
		int j=0;
		while(true){

			x[k] = (x[k]+1) % (n);
			if(x[k] == 0) return;	

			if( G[x[k-1]][x[k]] != 0 ){
				for(j=0;j<k;j++)
					if(x[k] == x[j]) break;
				if(j == k)
					if( (k < n-1) || ((k == n-1) && (G[x[k]][x[0]] != 0)) ) return;
			}
		}
	}

	void display(){
		int i;
		count++;
		System.out.println("\nPath");
		for(i=0;i<n;i++)
			System.out.print((x[i]+1)+" --> ");
		System.out.println("1\n");
	}

	public static void main(String args[]) {
		Hamiltonian h = new Hamiltonian();
		h.readData();
	}

} 
