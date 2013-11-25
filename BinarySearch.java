
public class BinarySearch {
	public static void main(String[] args){
		int[] input = {1, 2, 3, 3, 3, 4, 4, 7, 10, 10, 10, 11};
		System.out.println(binarySearch(input, 0, input.length-1, 7));
	}
	public static int binarySearch(int[] arr, int start, int end, int search){
		int middle = start+(end-start+1)/2;
		if(start > end)
			return -1;
		if(arr[middle] < search)
			return binarySearch(arr, middle+1, end, search);
		else if(arr[middle] > search)
			return binarySearch(arr, start, middle-1, search);
		else{
			int counter=middle-1;
			for(; counter>=start; counter--)
				if(arr[counter] != search)
					return counter+1;
			return start;
		}
	}
}
