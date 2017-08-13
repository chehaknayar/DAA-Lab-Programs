import java.util.Scanner;

class Staff{
	int staffid,sal,phone;
	String name;
	public Staff(){
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter staffid");
		staffid = inp.nextInt();
		System.out.println("Enter Staff_Name");
		name = inp.next();
		System.out.println("Enter Staff_PhNo");
		phone = inp.nextInt();
		System.out.println("Enter Staff_Salary");
		sal = inp.nextInt();	
	}
	void display(){
		System.out.println("\nStaff_ID\t"+staffid+"\nStaff_Name\t"+name+"\nStaff_phNo\t"+phone+"\nStaff_Salary\t"+sal);
	}
}

class Teaching extends Staff{
	String domian,pub; 
	Teaching(){
		//super();
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter Domain and Publications");
		domian = inp.nextLine();
		pub = inp.nextLine();
	}
	void display(){
		super.display();
		System.out.println("Domain\t"+domian+"  and Publications\t"+pub);

	}
}

class Technical extends Staff{
	String skills; 
	Technical(){
		//super();
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter skills");
		skills= inp.nextLine();
		
	}
	void display(){
		super.display();
		System.out.println("Skills\t"+skills);

	}
}

class Contract extends Staff{
	String period; 
	Contract(){
		//super();
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter period");
		period= inp.nextLine();
		
	}
	void display(){
		super.display();
		System.out.println("period\t"+period);

	}
}
class Lab2a{

	public static void main(String arg[]){
		//new Staff();
		Teaching obj1[] = new Teaching[2];
		for (int i=0;i<2;i++){
			System.out.println("Enter Teaching record"+(i+1));
			obj1[i]=new Teaching();
		}
		
		Technical obj2[] = new Technical[2];
		for (int j=0;j<2;j++){
			System.out.println("Enter Technical record"+(j+1));
			obj2[j]=new Technical();
		}
		
		Contract obj3[] = new Contract[2];
		for (int k=0;k<2;k++){
			System.out.println("Enter Contract record"+(k+1));
			obj3[k]=new Contract();
		}
		
		for (int i=0;i<2;i++){
			System.out.println("Teaching record"+(i+1));
			obj1[i].display();
		}
		
		for (int j=0;j<2;j++){
			System.out.println("Technical record"+(j+1));
			obj2[j].display();
		}
		
		for (int k=0;k<2;k++){
			System.out.println("Contract record"+(k+1));
			obj3[k].display();
		}
}
}
