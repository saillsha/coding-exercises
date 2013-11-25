package Arrays;
import java.util.*;
//generalization of binary search that can operate on a rotated sorted array
public class RotatedBinarySearch {
	public static void main(String[] args){
		int[] arr = {1,3,4,6,7};
		int[] original = Arrays.copyOf(arr, arr.length);
		for(int i=0; i<arr.length; i++){
			Rotate.rotate(arr, i);
			System.out.println(rotatedBinarySearch(arr, 4, 0, arr.length-1));
			ArrayFactory.printArray(arr);
			arr = Arrays.copyOf(original, original.length);
		}
	}
	public static int rotatedBinarySearch(int[] arr, int target, int start, int end){
		int mid = (start+end)/2;
		if(arr[mid] == target)
			return mid;
		if(start == end)
			return -1;
		if(arr[start] <= arr[mid])
			if(arr[start] <= target && target < arr[mid]) //properly sorted array with target inside the range
				return rotatedBinarySearch(arr, target, start, mid-1);
			else
				return rotatedBinarySearch(arr, target, mid+1, end);
		else{
			if(arr[mid] < target && arr[end] >= target) //properly sorted array with target inside the range
				return rotatedBinarySearch(arr, target, mid+1, end);
			else
				return rotatedBinarySearch(arr, target, start, mid-1);
		}
	}
}
