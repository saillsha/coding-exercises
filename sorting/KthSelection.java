package sorting;
import java.util.*;
public class KthSelection {
	public static int kthSelection(int[] arr, int k, int start, int end){
		if(k < 0 || k >= arr.length)
			return -1;
		Random r = new Random(System.currentTimeMillis());
		int randomPivot = r.nextInt(end-start+1)+start;
		int temp = arr[end];
		arr[end] = arr[randomPivot];
		arr[randomPivot] = temp;
		int partition = QuickSort.partition(arr, start, end);
		if(partition < k) //recur on right side
			kthSelection(arr, k, partition+1, end);
		else if(partition > k)//recur on left side
			kthSelection(arr, k, start, partition-1);
		return arr[k];
	}
}
