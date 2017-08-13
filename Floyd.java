import java.util.*;

class FloydAlgo{

	Scanner sc=new Scanner (System.in);
	int graph[][]=new int[10][10];
	int size=0;

	void GenerateGraph(){
		System.out.println("Number of vertices");
		size=sc.nextInt();
		System.out.println("Enter cost matrix");
		for(int i=0;i<size;i++){
			for (int j=0;j<size;j++){

				graph[i][j]=sc.nextInt();
			}
		}
	}

	void Algo(){
		for(int k=0;k<size;k++){

			for(int i=0;i<size;i++){

				for(int j=0;j<size;j++){

					if(graph[i][j]<graph[i][k]+graph[k][j])
						graph[i][j]=graph[i][j];

					else
						graph[i][j]=graph[i][k]+graph[k][j];
				}
			}
		}
	}
	
	void Display(){
		System.out.println("Solution graph");
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				System.out.print(graph[i][j]+" ");

			}
			System.out.print("\n");
		}
	}
}

class Floyd{
	public static void main(String args[]){

		FloydAlgo flo= new FloydAlgo();
		flo.GenerateGraph();
		flo.Algo();
		flo.Display();
	}
}
