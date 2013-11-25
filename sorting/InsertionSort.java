package sorting;

public class InsertionSort {
	public static void insertionSort(int[] array){
		if(array == null)
			return;
		for(int counter=1; counter<array.length; counter++){
			int nextValue = array[counter];
			int j=counter-1;
			for(; j>=0 && nextValue < array[j]; j--){
				array[j+1] = array[j];
			}
			array[j+1] = nextValue;
		}
	}
}
