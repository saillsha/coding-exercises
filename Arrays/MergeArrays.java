package Arrays;
//merge two arrays in place in a single pass
public class MergeArrays {
	public static void main(String[] args){
		int[] a = {1,3,7,8,0,0,0,0};
		int[] b = {2,4,5,9};
		merge(a,b, 4);
		ArrayFactory.printArray(a);
	}
	public static void merge(int[] a, int[] b, int aSize){
		if(aSize+b.length > a.length)
			return;
		int aLast = aSize-1;
		int bLast = b.length -1;
		int lastOpen = a.length-1;
		while(aLast >= 0 && bLast >= 0){
			if(a[aLast] > b[bLast])
				a[lastOpen--] = a[aLast--];
			else
				a[lastOpen--] = b[bLast--];
		}
		for(; bLast >= 0; bLast--)
			a[bLast] = b[bLast];
	}
}
