package sorting;

public class QuickSort {
	public static void quickSort(int[] arr, int start, int end){
		if(arr == null)
			return;
		if(start < end){
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot-1);
			quickSort(arr, pivot+1, end);
		}
	}
	public static int partition(int[] arr, int start, int end){
		int partition = start-1;
		int pivot = arr[end];
		for(int counter=start; counter<end; counter++){
			if(arr[counter] < pivot){
				partition++;
				int temp = arr[partition];
				arr[partition] = arr[counter];
				arr[counter] = temp;
			}
		}
		partition++;
		arr[end] = arr[partition];
		arr[partition] = pivot;
		return partition;
	}
}
