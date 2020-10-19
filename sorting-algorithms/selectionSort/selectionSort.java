
class selectionSort{
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = selectionSort(arr, sizeofArr);
		print(sortedArr);
	}

	static int [] selectionSort(int [] arr, int sizeofArr){
		int minIndex=0, temp=0;
		for (int i=0;i<sizeofArr;i++){
			minIndex = i;
			for (int k=i+1;k<sizeofArr;k++)
				if (arr[minIndex] > arr[k]) minIndex = k;
			if (minIndex != i){
				temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
		return arr;
	}

	static void print (int [] arr){
		for (int a : arr)
			System.out.print(" "+a);
	}
}
