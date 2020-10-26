import java.util.Collections;
import java.util.*;

class bucketSort
	public static void main(String [] args){
		float [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		float [] sortedArr = new float [sizeofArr];
		sortedArr = bucketSort(arr, sizeofArr);
	}

	static float [] bucketSort(float [] arr, int sizeofArr){
		int j=0;
		arr = normaliseIt(arr, n);
		Vector<Int>[] buckets = new Vector[10];
		for (int i=0;i<10;i++) buckets[i] = new Vector<Int>();
		for (int i=0;i<n;i++) buckets[(int) arr[i]*10].add(arr[i]);
		for (int i=0;i<10;i++) Collections.sort(buckets[i]);
		for (int i=0;i<n;i++) for (int k=0;k<buckets[i].size();k++)
			arr[j++] = buckets[i].get(k);
		return deNormaliseIt(arr);
		
	}

	static float [] denormaliseIt(float [] arr, int n){
		float max = getMax(arr, n);
		for (int i=0;i<n;i++) arr[i] *= max;
		return arr;
	}

	static float [] normaliseIt(float [] arr, int n){
		float max = getMax(arr, n);
		for (int i=0;i<n;i++) arr[i] /= max;
		return arr;
	}

	static float getMax(float [] arr, int n){
		float max = 0;
		for (int i=0;i<n;i++) if (max < arr[i]) max = arr[i];
	}
}
