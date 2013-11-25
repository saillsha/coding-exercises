package sorting;

public class CountingSort {
	public static int[] countingSort(int[] unsorted, int[] sorted, int max){
		int[] countArray = new int[max+1];
		for(int i : unsorted)
			countArray[i]++;
		for(int i=1; i<=max; i++)
			countArray[i] += countArray[i-1];
		for(int i=sorted.length-1; i >= 0; i--){
			sorted[countArray[unsorted[i]]-1] = unsorted[i];
			countArray[unsorted[i]]--;
		}
		return sorted;
	}
}
