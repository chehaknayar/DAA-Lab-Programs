import java.util.*;
class Lab2b{
	Scanner inp = new Scanner(System.in);
	static String name,dob;
	public void getInfo(){
		System.out.print("Enter the name : ");
		name =inp.nextLine(); 	
		System.out.print("\nEnter the DOB (dd/mm/yyyy): ");
		dob = inp.nextLine();
	}
	public void  display(String d,String m,String y){
		System.out.println("\n Name\t\t:"+name+"\nDate of birth\t"+d+','+m+','+y);
	}
	

	public static void main(String[] args) {
		
 		Lab2b obj = new Lab2b();
 		int i=0;
 		String date[]=new String[3];
		obj.getInfo();
		StringTokenizer token = new StringTokenizer(obj.dob,"/");
		System.out.println("Name : "+name);
		while(token.hasMoreTokens()){
			date[i++]=token.nextToken();
		}
		obj.display(date[0],date[1],date[2]);
	}
}
