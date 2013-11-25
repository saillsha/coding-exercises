package Arrays;

public class ArraysDriver {
	public static void main(String[] args){
		//probability of alive
//		System.out.println("probability of being alive is:" + ProbabilityOfAlive.probabilityOfAlive(1, 1, 3));
		
		//largest subsequent product
//		double[] array = {1.63,0.68, -3,-2.21, -.72};
//		System.out.println("largest subsequent product is: " + LargestSubsequentProduct.largestSubsequentProduct(array));
//		
		//KthLargest
//		int[] array = {3,7,1,6,2,5};
//		int kthLargest = KthLargest.KthLargest(array, 5);
//		System.out.println("Kth largest element is: " + kthLargest);
//		
		
//		//num ways to decipher
//		int[] array = {1,1,1,1,1,1};
//		System.out.println(NumWaysDecipher.numWaysDecipher(array));
		
		//K subsets
		int[] array = {1,2,3,4,5};
		PrintKSubsets.printKSubsets(array, 3);
		
		//rotate 
//		int[] array = {3,7,1,6,2,5};
//		Rotate.rotate(array, 0);
//		ArrayFactory.printArray(array);
////		int[][] array = {{4, -3, -1, 0}, {-1, -2, 5, 6}, {3, 1, 2, 0}, {-1, -4, 5, -4}};
////		ArrayFactory.print2DArray(array);
////		System.out.println("The maximum sum is "+FindMaxSubArray.maxSubArray(array));
//		int[] balanceArray = {1,2,3,-1,6};
////		int[] balanceArray = {1,2,3,7,6,5,9,5,6,7,5,2,-1};//expected 6th position
//
//		int balance = FindBalancePoint.findBalancePoint(balanceArray);
//		if(balance == -1)
//			System.out.println("no balance point found");
//		else
//			System.out.println("Balance at index" + balance + " with value "+balanceArray[balance]);
	}
}
