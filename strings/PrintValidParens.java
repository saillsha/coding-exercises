package strings;
//print all valid parenthesis of length 2*n
public class PrintValidParens {
	public static void main(String[] args){
		printParens(5);
	}
	public static void printParens(int n){
		ppAux(n, 0, "");
	}
	static int counter=0;
	private static void ppAux(int n, int s, String buffer){
		if(buffer.length() == 2*n){
			if(s == 0)
				System.out.println(Integer.toString((++counter))+": "+buffer);
		}
		else if(s > 0 && s < n){
			ppAux(n, s+1, buffer+"(");
			ppAux(n, s-1, buffer+")");
		}
		else if(s <= 0)
			ppAux(n, s+1, buffer+"(");
		else
			ppAux(n, s-1, buffer+")");
	}
}
