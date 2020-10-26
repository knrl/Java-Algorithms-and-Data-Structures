import java.util.Scanner;

class linearSearch{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int [] arr = {1, 5, 2, 4, 1, 2, 5, 9, 7, 0, 3};
		int key = scan.nextInt();
		if (findIt(arr, key)) System.out.print("here");
		else System.out.print("It is not here");
	}

	static int findIt(int [] arr, int key){
		int sizeOfArr = arr.length;
		for (int i=0;i<sizeOfArr;i++) if (key == arr[i]) return 1;
		return 0;
}
