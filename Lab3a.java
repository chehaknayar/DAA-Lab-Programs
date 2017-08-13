import java.util.*;

class Lab3a{
	int a,b;
	public void getInfo(){
		Scanner inp = new Scanner(System.in);
		a = inp.nextInt();
		b=inp.nextInt();
		try{
			int c = a/b;
			System.out.println("Answer : "+c);
		}catch(Exception e){
			System.out.println("The Exception Caught is : "+e);
		}
	}

	public static void main(String ar[]){
		Lab3a obj = new Lab3a();
		obj.getInfo();
	}
}