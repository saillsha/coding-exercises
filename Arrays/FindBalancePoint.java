package Arrays;

public class FindBalancePoint {
	public static int findBalancePoint(int[] arr){
		if(arr.length < 3)
			return -1;
		int leftSum = 0;
		int pivot = 0;
		int rightSum =0;
		for(int counter=1; counter<arr.length; counter++)
			rightSum+=arr[counter];
		for(;pivot < arr.length - 1; pivot++){
			leftSum += arr[pivot];
			rightSum -= arr[pivot+1];
			if(leftSum == rightSum)
				return pivot+1;
		}
		return -1;
	}
}
