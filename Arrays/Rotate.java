package Arrays;

//rotate array by k positions in place

public class Rotate {
	public static void rotate(int[] array, int k){
		if(array == null)
			return;
		int next = array[0];
		int index=k%array.length;
		int startPos = 0;
		for(int counter=1; counter<array.length; counter++){
			int temp = array[index];
			array[index] = next;
			next = temp;
			if(index == startPos){
				index++;
				next = array[index];
				startPos = index;
			}
			index = (index+k)%array.length;
		}
		array[startPos] = next;
	}
}
