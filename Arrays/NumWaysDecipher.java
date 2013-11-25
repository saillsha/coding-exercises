package Arrays;

public class NumWaysDecipher {
	public static int numWaysDecipher(int[] arr){
		return nwdAux(arr, 0);
	}
	private static int nwdAux(int[] arr, int pos){
		if(pos == arr.length)
			return 1;
		while(pos < arr.length - 2 && arr[pos]*10+arr[pos+1] > 26)
			pos++;
		if(pos == arr.length - 1)
			return 1;
		return nwdAux(arr, pos+1) + nwdAux(arr, pos+2);
	}
}
