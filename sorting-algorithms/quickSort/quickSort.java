class quickSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		quickSort ob = new quickSort();
		ob.sort(arr, 0, arr.length-1);
		for (int i : arr)
			System.out.print(i);
	}

	void sort(int [] arr, int l, int h){
		if (l < h){
			int j = 0, pivot = arr[h], temp = 0;
			for (int i=l;i<h;i++){
				if (arr[i] < pivot){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					j++;
				}
			}
			
			temp = arr[j+1];
			arr[j+1] = arr[h];
			arr[h] = temp;

			sort(arr, l, j);
			sort(arr, j+2, h);
		}
	}
}
