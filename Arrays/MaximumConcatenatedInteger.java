package Arrays;

import java.util.Arrays;

//http://www.careercup.com/question?id=7781671
// given a list of integers, sort in such a way that the concatenated list of sorted integers
// represents the maximum possible number
public class MaximumConcatenatedInteger {
	public static void main(String[] args){
		int[] array = {4,94,9,14,1};
		ArrayFactory.printArray(sortDigits(array));
	}
	public static int[] sortDigits(int [] arr){
		int[] sortedArr = new int[arr.length];
		int maxDigit = 0;
		for(int i : arr)
			maxDigit = Math.max(maxDigit, getNumDigits(i));
		for(int d=1; d <= maxDigit; d++){
			sortByDigit(arr,sortedArr, d);
			int[] temp = sortedArr;
			sortedArr = arr;
			arr = temp;
		}
		return arr;
	}
	public static void sortByDigit(int[] unsorted, int[] sorted, int digit){
		int[] countArray = new int[10];
		for(int i=0; i<unsorted.length; i++)
			countArray[getDigit(unsorted[i], digit)]++;
		for(int i=countArray.length-2; i >= 0; i--)
			countArray[i] += countArray[i+1];
		for(int i=sorted.length-1; i >= 0; i--){
			sorted[countArray[getDigit(unsorted[i], digit)]-1] = unsorted[i];
			countArray[getDigit(unsorted[i], digit)]--;
		}
	}
	public static int getNumDigits(int i){
		int numDigits=0;
		for(;i>0;numDigits++,i/=10);
		return numDigits;
	}
	public static int getDigit(int i, int digit){
		for(; digit > 1; digit--, i/=10)
			if(i/10 == 0)
				return i;
		return i%10;
	}
}
