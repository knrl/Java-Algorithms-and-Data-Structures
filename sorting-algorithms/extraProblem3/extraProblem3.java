import java.util.Random;
import java.util.Scanner;

class extraProblem3{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int [] arr = createArr(n, 0, 100);
		int [] medianMod = findMedianMod(arr, n);
	}

	static int [] findMedianMod(int [] arr, int n){
		arr = sort(arr, n);
		int [] medianMod = new int [2];
		if (n < 2) medianMod[0] = arr[0];
		else medianMod = (n % 2 == 0) ? (arr[n/2] + arr[(n/2)-1])/2 : arr[(int) n/2];
		int [] tempArr = new int [n];
		int maxIndex = 0;
		for (int i=0;i<n-1;i++){
			tempArr[i] = arr[i];
			for (int k=i+1;k<n;i++) if (arr[k] == tempArr[i]) tempArr[i]++;
			if (tempArr[maxIndex] - arr[maxIndex] < tempArr[i] - arr[i]) maxIndex = i;
		}
		medianMod[1] = arr[maxIndex];
		return medianMod;
	}

	static int [] sort(int [] arr, int n){
		for (int i=0;i<n;i++){
			index = i;
			for (int k=i+1;k<n;k++) if (arr[index] > arr[k]) index = k;
			temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		return arr;
	} 

	static int [] createArr(int sizeOfArr, int start, int end){
		Random rand = new Random();
		int [] arr = new int [sizeOfArr];
		for (int i=0;i<sizeOfArr;i++) arr[i] = rand.nextInt(start, end);
		return arr;
	}
}
