import java.util.*;
import java.io.*;

class MergeSort{
	public void mergesort(int a[]){
		int mid = a.length/2;
		if (a.length>1){
			int b[] = new int[mid];
			int c[] = new int[a.length-mid];
			for (int i=0;i<mid;i++)
				b[i]=a[i];
			for (int i=mid,j=0; i<a.length; i++,j++)
				c[j]=a[i];
			mergesort(b);
			mergesort(c);
			simplemerge(a, b, c, b.length, c.length);
		}

	}
	public void simplemerge(int a[],int b[],int c[],int p,int q){
		int i=0,j=0,k=0;
		while (i<p && j<q){
			if (b[i]>c[j]){
				a[k]=c[j];
				j++;
			}
			else{
				a[k]=b[i];
				i++;
			}
			k++;
		}
		while (i<p){
			a[k]=b[i];
			i++;
			k++;
		}
		while (j<q){
			a[k]=c[j];
			k++;
			j++;
		}
	}
}

public class Lab5{
	public static void main(String arg[]) throws IOException{
		Random r = new Random();
		FileWriter fw = new FileWriter("MergeSort.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		MergeSort obj = new MergeSort();
		for (int i=5000;i<100000;i+=500){
			int arr[] = new int[i];
			int k=0;
			for (int j=0;j<i;j++){
				arr[k]=r.nextInt(i);
				k++;
			}
		double start = System.currentTimeMillis();
		obj.mergesort(arr);
		double end = System.currentTimeMillis();
		double elapse = end-start;
		bw.write(i +"\t" + elapse*0.001 +"\n");
		//System.out.println("\nTime take to sort " + i + "is : " + elapse*0.001);
		}
	bw.close();
	fw.close();
	}
}
