package sorting;

public class HeapSort {
	public static void main(String[] args){
		int[] array = {4, 7, 1, 6, 9, 2, 5, 10, 2, 3};
		
	}
	public static void heapSort(int[] array){
		
	}
	public static void buildHeap(int[] array){
		
	}
	public static void heapify(int[] array, int start, int end){
		if(start < end){
			int maxIndex = array[start*2] > array[start*2+1] ? start*2 : start*2+1;
			if(array[maxIndex] > start){
				int temp = array[maxIndex];
				array[maxIndex] = array[start];
				array[start] = temp;
				heapify(array, maxIndex, end);
			}
		}
	}
}
