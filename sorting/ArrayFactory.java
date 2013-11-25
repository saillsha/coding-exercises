package sorting;

public class ArrayFactory {
	public static void printArray(int[] a){
		if(a == null)
			return;
		System.out.print("{");
		for(int i : a){
			System.out.print(i+"," );
		}
		System.out.println("}");
	}
	public static void print2DArray(int[][] a){
		for(int i=0; i<a.length; i++){
			for(int j=0; j < a[i].length; j++)
				System.out.print(a[i][j]+", ");
			System.out.println();
		}
	}
}
