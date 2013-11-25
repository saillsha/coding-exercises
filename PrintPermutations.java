
public class PrintPermutations {
	public static void main(String[] args){
		char[] str = {'s', 'a', 'w'};
		printPermutation(str, 0);
	}
	public static void printPermutation(char[] str, int focus){
		if(focus == str.length){
			System.out.println(new String(str));
			return;
		}
		printPermutation(str, focus+1);
		for(int counter=focus+1; counter<str.length; counter++){
			char temp = str[focus];
			str[focus] = str[counter];
			str[counter] = temp;
			printPermutation(str, focus+1);
		}
	}
}
