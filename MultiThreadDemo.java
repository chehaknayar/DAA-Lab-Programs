import java.util.*;
import java.util.Random;
import java.io.*;


class GenerateNumber extends Thread
{
	static int num;
	String name;
	GenerateNumber(String name) {
		super(name);		
		start();
	}
	public void run()
	{
		Random rand=new Random();
		for(int i=0;i<=10;i++)
		{
			num=rand.nextInt(50);
			System.out.println("Thread :"+Thread.currentThread().getName()+" Generates "+num);
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
			}
		}
	}
}
class FindSquare extends Thread
{
	String name;	
	FindSquare(String name) {
		super(name);
		start();
	}
	public void run()
	{
		//Random rand=new Random();
                for(int i=0;i<=10;i++)
                {
                        //int num=rand.nextInt(50);
			System.out.println("Thread:"+Thread.currentThread().getName()+" Finds "+(int)Math.pow(GenerateNumber.num,2));
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
			}
		}
	}
}

class FindCube extends Thread
{
	String name;
	FindCube(String name) {
		super(name);
		start();
	}
	public void run()
        {
                
                //Random rand=new Random();
                for(int i=0;i<=10;i++)
                {
                  //      int num=rand.nextInt(50);
                        System.out.println("Thread :"+Thread.currentThread().getName()+" Finds "+(int)Math.pow(GenerateNumber.num,3));
                        try
                        {
                                Thread.sleep(1000);
                        }
                        catch(InterruptedException e)
                        {
                        }
                }
       	}
}

class MultiThreadDemo
{
	public static void main(String args[])
	{
		Random ra = new Random();
		System.out.println((int)Math.pow(ra.nextInt(50),2));
		GenerateNumber n=new GenerateNumber();//"Generator_Thread");
		FindSquare s=new FindSquare();//"Square_Thread");
		FindCube c= new FindCube();//"Cube_Thread");
		//n.start();
		//s.start();
		//c.start();
	}
}
