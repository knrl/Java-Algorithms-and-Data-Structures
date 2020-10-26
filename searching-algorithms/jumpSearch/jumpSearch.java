import java.util.Scanner;
import java.lang.Math;

class linearSearch{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int [] arr = {1, 5, 2, 4, 1, 2, 5, 9, 7, 0, 3};
		int key = scan.nextInt();
		if (findIt(arr, key)) System.out.print("here");
		else System.out.print("It is not here");
	}

	static int findIt(int [] arr, int key){
		int n = arr.length, steps = Math.pow(n, 1/2), index=0;
		arr = sort(arr, n);
		for (int i=0;i<i=n/steps+steps-1;i++){
			if (key == arr[index]) return 1;
			else if (key < arr[index]){
				index += 1 - steps;
				steps = 1;
			}
			else index += steps;
		}
		return 0;
	}

	static int [] sort(int [] arr, int sizeofArr){
		int temp, check;
		for (int i=0;i<sizeofArr;i++ ){
			check=1;
			for (int k=0;k<sizeofArr-i-1 && arr[k] > arr[k+1];k++ ){
				temp = arr[k];
				arr[k] = arr[k+1];
				arr[k+1] = temp;
				check = 0;
			}
			if (check) break;
		}
		return arr;
	}
}
