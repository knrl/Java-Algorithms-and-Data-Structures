
class insertionSort{
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = insertionSort(arr, sizeofArr);
		print(sortedArr);
	}

	static int [] insertionSort(int [] arr, int sizeofArr){
		int temp;
		for (int i=1;i<sizeofArr;i++){
			for (int k=i;k>0 && arr[k-1] >= arr[k];k--) {
				temp = arr[k];
				arr[k] = arr[k-1];
				arr[k-1] = temp; 
			}
		}
		return arr;
	}

	static void print (int [] arr){
		for (int a : arr)
		System.out.print(" "+a);
	}
}
