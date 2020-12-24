import java.util.Scanner;
import java.lang.Math;

class recursiveBinarySearch{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int key = scan.nextInt();
		System.out.println(recBinarySearch(arr, 0, arr.length - 1, key));
	}

	static String recBinarySearch(int [] arr, int a, int b, int key){
		if (a < b){
			int m = (a + b) / 2;
			if (key == arr[m]) return "I found it.";
			else if (key > arr[m]) return recBinarySearch(arr, m + 1, b, key);
			else return recBinarySearch(arr, a, m - 1, key);
		}
		else return "I couldnt find it.";
	}
}
