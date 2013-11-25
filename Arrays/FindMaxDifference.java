package Arrays;
//http://www.careercup.com/question?id=12705676
public class FindMaxDifference {
	public static void main(String[] args){
		int[] array = {3,9,1,4,5};
		System.out.println(findMaxDifference(array));
	}
	//Find out index i,j such that j > i and a[j] - a[i] is maximum
	public static int findMaxDifference(int[] array){
		int maxDifference = Integer.MIN_VALUE, min = array[0];
		for(int i=1; i<array.length; i++){
			if(array[i] - min > maxDifference){
				maxDifference = array[i] - min;
			}
			min = Math.min(array[i], min);			
		}
		return maxDifference;
	}
}
