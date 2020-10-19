
class oddEvenSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = oddEvenSort(arr, sizeofArr);
		print(sortedArr);
	}

	static int [] oddEvenSort(int [] arr, int sizeofArr){
		int temp, check;
		for (int i=0;i<sizeofArr;i++){
			check = 1;
			for (int k=0;k<sizeofArr-1-i;k++){
				if (arr[k] > arr[k+1]){
					temp = arr[k+1];
					arr[k+1] = arr[k];
					arr[k] = temp;
					//--
					temp = arr[k-1];
					arr[k-1] = arr[k];
					arr[k] = temp;
				}
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
