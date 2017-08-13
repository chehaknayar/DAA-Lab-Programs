import java.util.Scanner;
public class lab1a
{
	String USN,name,branch;
	long phno;
	public void getinfo()
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("enter USN");
		USN=sc.nextLine();

		System.out.println("enter name");
		name=sc.nextLine();

		System.out.println("enter branch");
		branch=sc.nextLine();

		System.out.println("enter phone number");
		phno=sc.nextLong();
	}

	public void printinfo()
	{
		System.out.println(USN+"\t"+name+"\t"+branch+"\t"+phno);
	
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("enter the number of students:");

		int n=sc.nextInt();

		lab1a s[]=new lab1a[n];

		for(int i=0;i<n;i++)
		{
			System.out.println("enter the details of student");

			s[i]=new lab1a();

			s[i].getinfo();
		}
		
		System.out.println("details of students:");
		System.out.println("USN\t\t"+"Name\t"+"Branch\t"+"PhNo");
		
		for(int i=0;i<n;i++)
		{
			s[i].printinfo();
		}
	}
}
