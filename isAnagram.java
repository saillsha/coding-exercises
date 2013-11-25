import java.util.HashMap;


public class isAnagram {
	public static void main(String[] args){
		String s1="sahil";
		String s2="hials";
		System.out.println(isAnagram(s1, s2));		
	}
	public static boolean isAnagram(String s1, String s2){
		HashMap<Character, Pair> letters = new HashMap<Character, Pair>();
		if(s1.length() != s2.length())
			return false;
		for(int i=0; i < s1.length(); i++){
			Character c1 = new Character(s1.charAt(i));
			Character c2 = new Character(s2.charAt(i));
			if(letters.get(c1) == null){
				letters.put(c1, new Pair(1, 0));
			}
			else{
				letters.get(c1).x++;
			}
			if(letters.get(c2) == null)
				letters.put(c2, new Pair(0,1));
			else
				letters.get(c2).y++;
		}
		for(Character c : letters.keySet()){
			if(letters.get(c).x != letters.get(c).y)
				return false;
		}
		return true;
	}
}
