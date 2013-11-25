package Arrays;

//Find maximum subarray of 2D matrix. accomplishes it in O(n^3) time. see me bitches!
public class FindMaxSubArray {
	static int[][] subArraySums;
	public static int maxSubArray(int[][] arr){
		generateSubArraySums(arr); //O(n^2)
		int maxSum = Integer.MIN_VALUE;
		int[] tempArray = new int[arr[0].length];
		for(int rowStart=0; rowStart<arr.length; rowStart++){
			for(int rowEnd = rowStart; rowEnd < arr.length; rowEnd++){
				for(int col=0; col<tempArray.length; col++)
					tempArray[col] = computeSum(rowStart, col, rowEnd, col);
				int tempSum = maxSum1D(tempArray);
				maxSum = Math.max(maxSum, tempSum);
			}
		}
		return maxSum;
	}
	public static void generateSubArraySums(int[][] arr){
		subArraySums = new int[arr.length][arr[0].length];
		for(int i=0; i<arr.length; i++)
			for(int j=0; j<arr[0].length; j++)
				if(i == 0 && j== 0)
					subArraySums[i][j] = arr[i][j];
				else if(i == 0) //row 0
					subArraySums[i][j] = subArraySums[i][j-1]+arr[i][j];
				else if(j == 0) //column 0
					subArraySums[i][j] = subArraySums[i-1][j] + arr[i][j];
				else
					subArraySums[i][j] = subArraySums[i-1][j] + subArraySums[i][j-1] 
										- subArraySums[i-1][j-1] + arr[i][j];
	}
	public static int computeSum(int r1, int c1, int r2, int c2){
		if(r1 == 0 && c1 == 0)
			return subArraySums[r2][c2];
		else if(r1 == 0) //first row, implies r1 == 0
			return subArraySums[r2][c2] - subArraySums[r2][c1-1];
		else if(c1 == 0) // first column, implies c1 == 0
			return subArraySums[r2][c2] - subArraySums[r1-1][c2];
		return subArraySums[r2][c2] - subArraySums[r2][c1-1] - subArraySums[r1-1][c2] + subArraySums[r1-1][c1-1];
	}
	public static int maxSum1D(int[] arr){ //return maximum sum of 1D array
		int maxSum = Integer.MIN_VALUE;
		int maxSumAtEnd = 0;
		for(int i=0; i<arr.length; i++){
			maxSumAtEnd = Math.max(maxSumAtEnd+arr[i], 0);
			if(maxSumAtEnd > maxSum)
				maxSum = maxSumAtEnd;
		}
		return maxSum;
	}
}
