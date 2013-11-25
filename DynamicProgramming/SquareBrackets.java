package DynamicProgramming;
import java.util.HashMap;
import java.util.Arrays;
//http://www.spoj.com/problems/SQRBR/
public class SquareBrackets {
	public static void main(String[] args){
		int[] a = {4,6};
		System.out.println(squareBrackets(4, a));
	}
	public static int squareBrackets(int n, int[] indices){
		return sbAux(2*n, 0, indices, 0, new HashMap<Pair, Integer>());
	}
	private static int sbAux(int n, int index, int[] indices, int numOpen, HashMap<Pair, Integer> table){
		Pair p = new Pair(index, numOpen);
		if(index == n) //end case
			return (numOpen == 0) ? 1 : 0;
		if(table.containsKey(p)) //memoization case
			return table.get(p);
		int sum = 0;
		if(Arrays.binarySearch(indices, index) >= 0 && numOpen < n/2)
			sum= sbAux(n, index+1, indices, numOpen+1, table);
		else{
			if(numOpen > 0) //close parenthesis
				sum += sbAux(n, index+1, indices, numOpen-1, table);
			if (numOpen < n/2) //open parenthesis
				sum += sbAux(n, index+1, indices, numOpen+1, table);
		}
		table.put(p, sum);
		return sum;
	}
	public static class Pair{
		int position;
		int numOpen;
		public Pair(int pos, int numOpen){
			this.position = pos;
			this.numOpen = numOpen;
		}
		public String toString(){
			return position+" "+numOpen;
		}
		public int hashCode(){
			return toString().hashCode();
		}
	}
}
