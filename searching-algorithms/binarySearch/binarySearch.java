import java.util.Scanner;
import java.lang.Math;

class binarySearch{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int [] arr = {1, 5, 2, 4, 1, 2, 5, 9, 7, 0, 3};
		int key = scan.nextInt();
		if (findIt(arr, key)) System.out.print("here");
		else System.out.print("It is not here");
	}

	static int findIt(int [] arr, int key){
		int a=0, b=arr.length, r=0;
		arr = sort(arr, b);
		while (a <= b){
			r = (a+b)/2;
			if (arr[r] == key) return 1;
			else if (arr[r] > key) b = r-1;
			else if (arr[r] < key) a = r+1;
		}
		return 0;
	}

	static int [] sort(int [] arr, int sizeofArr){
		int temp, gapValue=sizeofArr-2;
		for (int i=gapValue;i>0;i--){
			for (int k=0;k<sizeofArr-i;k++)
				if (arr[k] > arr[k+i]){
					temp = arr[k];
					arr[k] = arr[k+i];
					arr[k+i] = temp;
				}
		}
		return arr;	
	}
}
