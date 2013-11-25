package Arrays;

public class PrintKSubsets {
	
	public static void printKSubsets(int[] array, int k){
		int[] buffer = new int[k];
		printKSubsetsAux(array, k, 0, 0, buffer);
	}
	private static void printKSubsetsAux(int[] array, int k, int level, int pos, int[] buffer){
		if(level == k){
			ArrayFactory.printArray(buffer);
			return;
		}
		for(int counter=pos; counter < array.length - (k-level)+1; counter++){
			buffer[level] = array[counter];
			printKSubsetsAux(array, k, level+1, counter+1, buffer);
		}
	}
}
