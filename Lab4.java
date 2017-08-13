import java.util.*;
import java.io.*;

class QuickSort{
	int i,tmp,pivot,j;
	public int partition(int s[],int left,int right){
		pivot = s[(left+right)/2];
		i=left;
		j=right;
		while(i<j){
			while (s[i]<pivot)
				i++;
			while(s[j]>pivot)
				j--;
			if (i<=j){
				tmp = s[i];
				s[i]=s[j];
				s[j]=tmp;
				i++;
				j--;
			}
		}
		return i;
	}
	public void quicksort(int s[],int left,int right){
		int index = partition(s,left,right);
		if (left < index-1)
			quicksort(s,left,index-1);
		if (index<right)
			quicksort(s,index,right);
	}
}
public class Lab4{
	public static void main(String Agr []) throws IOException{
		QuickSort obj = new QuickSort();
		FileWriter fe = new FileWriter("QuickSort.txt");
		BufferedWriter bw = new BufferedWriter(fe);
		Random r = new Random();
		for(int i=5000;i<1000000;i+=500){
			int arr[] = new int[i];
			int k =0;
			for(int j=0;j<i;j++){
				arr[k]=r.nextInt(i);
				k++;
			}
		System.out.println("\n\n");
		double start = System.currentTimeMillis();
		obj.quicksort(arr,0,(arr.length)-1);
		double end = System.currentTimeMillis();
		double elapse = end-start;
		bw.write(i+"\t" + elapse*0.001 + "\n");
		//System.out.println("\nTime Taken to Sort" + i + "is : " + elapse*0.001);
		}
		bw.close();
		fe.close();
	}
}
