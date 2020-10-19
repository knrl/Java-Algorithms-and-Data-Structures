
class gnomeSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = gnomeSort(arr, sizeofArr);
		print(sortedArr);
	}

	static int [] gnomeSort(int [] arr, int sizeofArr){
		int temp;
		for (int i=0;i<sizeofArr;i++){
			for (int k=0;k<sizeofArr-1-i;k++)
				if (arr[k] > arr[k+1]){
					temp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = temp;
				}
			for (int k=sizeofArr-1-i;k>i;k--)
				if (arr[k-1] > arr[k]){
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
