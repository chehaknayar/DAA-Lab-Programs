import java.io.*;
import java.util.*;
public class stack{

int top;
int size,maxsize;
int[] stk;
	public stack(){	
		Scanner sc = new Scanner(System.in);		
		System.out.println("enter stack size");
		size=sc.nextInt();
		maxsize=size;
		stk = new int[maxsize];	
		top=-1;
	}
	public void push(){
		int ele;
		Scanner sc = new Scanner(System.in);
		if(top==maxsize-1){
			System.out.println("stack overflow");
		}
		else{
			System.out.println("enter the element");
			ele=sc.nextInt();
			
			stk[++top]=ele;
		}
	}
	public void pop(){
		if(top<0){
			System.out.println("underflow");
		}
		else{
			top--;
		}
	}
	public void disp(){
		for(int i=top;i>0;i--)
			System.out.println(stk[top]);	
	}
	public static void main(String args[]){
		stack obj = new stack();
		int opt;
		Scanner sc = new Scanner(System.in);
		boolean check= true;
		do{
			System.out.println("1.push \t 2.pop \t 3.display \t 4.exit");
			opt=sc.nextInt();
			switch(opt){
				case 1:obj.push();
					break;
				case 2:obj.pop();
					break;
				case 3:obj.disp();
					break;
				case 4:check=false;
					break;
				default:break;
			}
		}while(check ==true);
	
	}
}
