package sorting;

public class SortingDriver {
	public static void main(String[] args){
		//radix sort
//		int[] radixArray = {4823, 2831, 138, 104, 4821, 9829, 8923, 3928, 7291, 8932};
//		RadixSort.radixSort(radixArray, 4);
//		ArrayFactory.printArray(radixArray);
		
		//insertion sort
//		int[] array = {15, 9, 12, 2, 4, 11, 1, 5, 4, 9};
//		InsertionSort.insertionSort(array);
//		ArrayFactory.printArray(array);
		
		{
			//kth selection
			int[] kthSelectionArray = {6, 10, 14, 1, 5, 7};
			System.out.println(KthSelection.kthSelection(kthSelectionArray, 3, 0, kthSelectionArray.length-1));
		}

//		int[] sortedArray = new int[array.length];		
		//ArrayFactory.printArray(countingSort(array, sortedArray, 15));
		//quickSort(array, 0, array.length-1);

	}
}
