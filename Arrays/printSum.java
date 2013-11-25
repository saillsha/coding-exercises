package Arrays;
/*
   Given an array of sorted numbers and a fixed sum, find all pairs of numbers that add up to the given sum.
*/
public class printSum {
	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 12, 13};
		printSumToM(arr, 7);
		
	}
	static void printSumToM(int[] arr, int m){
		if(arr == null)
			return;
		int end = arr.length - 1;
		for(int i=0; i< end; i++){
			for(int j=end; j>i; j--){
				int sum = arr[i]+arr[j];
				if(sum>m){
					end--;
				}
				else if(sum < m){
					break;
				}
				else{
					System.out.println(arr[i] +" " +arr[j]);
					end--;
					break;
				}
			}
		}
	}
}
