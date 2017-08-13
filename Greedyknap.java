import java.util.*;
import java.lang.*;

public class Greedyknap{
	private float benefit;
	private float weight;
	private float value;
	private float weight_chosen;		
	private static int W ;
	private static int n ;
	private static float profit_earned;
	private static Greedyknap[] obj = new Greedyknap[10];
	private Greedyknap(float b, float w,float v,int f){
		this.benefit = b;
		this.weight = w;
		this.value = v;
		this.weight_chosen = f;
	}
	public static void main(String[] args){
		take_input();
		sort();
		profit_earned = compute();
		show_output();
	}
	public static void take_input(){
		int a,b,d;
		float c;
		System.out.println("Enter the number of elements");
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		System.out.println("Enter the weight and benefit of each element one by one");
		for(int i=0;i<n;i++){
			a = input.nextInt();
			b = input.nextInt();
			c = ((float)b)/a;
			d = 0;
			obj[i] = new Greedyknap(b,a,c,d);
		}
		System.out.println("ENter the weight of knapsack");
		W = input.nextInt();
	}
	public static void sort(){
		for (int i=0;i<n;i++){
			for (int j=i+1;j<n;j++){
				if (obj[i].value < obj[j].value){
					float temp = obj[i].benefit;
					obj[i].benefit = obj[j].benefit;
					obj[j].benefit = temp;
					temp = obj[i].weight;
					obj[i].weight = obj[j].weight;
					obj[j].weight = temp;
					temp = obj[i].value;
					obj[i].value = obj[j].value;	
					obj[j].value = temp;
				}
			}	
		}
	}
	public static float compute(){
		float sum=0;
		float profit=0;
		float remaining=0;
		for(int i=0;i<n;i++){
			if(sum+obj[i].weight < W){
				obj[i].weight_chosen = obj[i].weight;
				sum += obj[i].weight;
				profit += obj[i].benefit;
			}
			else{
				remaining = W - sum;
				obj[i].weight_chosen = remaining;
				profit += remaining*obj[i].value;
				sum += remaining;
			}
		}
		return profit;
	}
	public static void show_output(){
		System.out.println("Weight\tbenefit\tvalue\t\tweight_chosen");
		for(int i=0;i<n;i++){
			System.out.print(obj[i].weight+"\t"+obj[i].benefit+"\t"+obj[i].value+"\t\t"+obj[i].weight_chosen+"\n");
		}
		System.out.println("The total profit earned is "+profit_earned);
	}
}
