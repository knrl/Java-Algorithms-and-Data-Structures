
class bubbleSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = bubleSort(arr, sizeofArr);
		print(sortedArr);
	}

	static int [] bubbleSort(int [] arr, int sizeofArr){
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

	static void print (int [] arr){
		for (int a : arr)
		System.out.print(" "+a);
	}
}
