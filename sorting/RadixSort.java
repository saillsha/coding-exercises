package sorting;

public class RadixSort {
	public static void radixSort(int[] arr, int numDigits){
		int[] sorted = new int[arr.length];
		for(int i=1; i<=numDigits; i++){
			countingSort(arr, sorted, 9, i);
			int[] temp = sorted;
			sorted = arr;
			arr = temp;
		}
	}
	public static int extractDigit(int n, int d){ //digit 1 is units digit, 2 is tens digit, etc.
		return n/((int)Math.pow(10, d-1))%10;
	}
	public static void countingSort(int[] unsorted, int[] sorted, int max, int digit){
		int[] countArray = new int[max+1];
		for(int i=0; i<unsorted.length; i++)
			countArray[extractDigit(unsorted[i], digit)]++;
		for(int i=1; i<=max; i++)
			countArray[i] += countArray[i-1];
		for(int i=sorted.length-1; i >= 0; i--){
			sorted[countArray[extractDigit(unsorted[i], digit)]-1] = unsorted[i];
			countArray[extractDigit(unsorted[i], digit)]--;
		}
	}
}
