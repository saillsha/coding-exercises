package strings;

//print all subsets of a string, same as PrintKSubsets.java in the arrays package
public class PrintSubsets {
	public static void main(String[] args){
		printSubsets("lakers");
	}
	public static void printSubsets(String s){
		for(int i=0; i<s.length(); i++)
			printNCK(s, i, "", 0);
	}
	private static void printNCK(String s, int k, String buffer, int index){
		if(k<0)
			System.out.println(buffer);
		else
			for(int i = index; i < s.length()-k; i++)
				//because Java strings are immutable, we create a new String at each call,
				//which allows us to not worry about clearing the buffer after the end of recursive calls
				printNCK(s, k-1, buffer+s.charAt(i), i+1);  
	}
}
