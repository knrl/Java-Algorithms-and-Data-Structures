
class shakerSort{
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = shakerSort(arr, sizeofArr);
		print(sortedArr);
	}

	static int [] shakerSort(int [] arr, int sizeofArr){
		int temp, check;
		for (int i=0;i<(sizeofArr/2 +1); i++){
			check = 1;
			for (int k=0;k<sizeofArr-i-1;k++){
				if (arr[k] > arr[k+1]){
					temp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = temp;
				}
				check = 0;
			}
			for (int k=sizeofArr-1-i;k>0;k--){
				if (arr[k-1] > arr[k]){
					temp = arr[k];
					arr[k] = arr[k-1];
					arr[k-1] = temp;
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
