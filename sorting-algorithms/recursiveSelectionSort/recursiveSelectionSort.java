class recursiveSelectionSort{
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		recSelectionSort(arr, 0, sizeofArr);
		print(arr);
	}

	static int minIndex (int [] arr, int a, int b){
		if (a == b) return a;

		int p = minIndex(arr, a, b - 1);
		if (arr[p] > arr[b]) return b;
		else return p;
	}

	static void recSelectionSort(int [] arr, int index, int n){
		int temp;
		if (index == n) return;

	   	int p = minIndex(arr, index, n - 1);
		if (p != index){
			temp = arr[index];
			arr[index] = arr[p];
			arr[p] = temp;
		}
		recSelectionSort(arr, index + 1, n);
	}

	static void print (int [] arr){
		for (int a : arr)
			System.out.print(" "+a);
	}
}

