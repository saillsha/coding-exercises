package Arrays;
import java.util.*;

/* 
   Randomized algorithm to find the Kth largest element in an array. Performs successive partitions similar to quicksort
*/
public class KthLargest {
	public static int KthLargest(int[] array, int k){
		if(array == null || k < 0 || k >= array.length)
			return -1;
		return KthLargestAux(array, k, 0, array.length-1);
	}

	private static int KthLargestAux(int[] array, int k, int left, int right){
		Random rand = new Random(System.currentTimeMillis());
		int swap = rand.nextInt(right-left+1)+left;
		int temp = array[right];
		array[right] = array[swap];
		array[swap] = temp;
		int pivot = array[right];
		int pivotIndex = left;
		for(int index=left; index<right; index++){
			if(array[index] < pivot){
				temp = array[index];
				array[index] = array[pivotIndex];
				array[pivotIndex] = temp;
				pivotIndex++;
			}
		}
		array[right] = array[pivotIndex];
		array[pivotIndex] = pivot;
		if(pivotIndex == k)
			return array[k];
		else if(pivotIndex < k)
			return KthLargestAux(array, k, pivotIndex+1, right);
		else
			return KthLargestAux(array, k, left, pivotIndex-1);
	}
}
