package strings;

public class FindLongestPalindrome {
	//linear time solution
	public static String findLongestPalindromeLinear(String str){
		char[] chars = str.toCharArray();
		int maxEnding=1;
		int max=1;
		int start = 0;
		for(int i=1; i<chars.length; i++){
			if(maxEnding == i){
				if(chars[i] == chars[0])
					maxEnding++;
				else{
					maxEnding=1;
				}
			}
			else{
				if(chars[i] == chars[i-maxEnding-1]){
					maxEnding++;
					start--;
				}
				else if(maxEnding == 1){
					if(chars[i] == chars[i-1])
						maxEnding++;
				}
				else{
					maxEnding = 1;
				}
			}
			if(maxEnding > max){
				max = maxEnding;
				start = i-maxEnding+1;
				//i - start + 1 = maxEnding
			}
		}
		return str.substring(start, start+max+1);
	}
	public static String findLongestPalindrome(String str){
		char[] cArr = str.toCharArray();
		int start = 0;
		int end = 0;
		for(int i=0; i<cArr.length-1; i++){
			//odd case
			int tempStart = i-1;
			int tempEnd = i+1;
			while(tempStart >= 0 && tempEnd < cArr.length && cArr[tempStart] == cArr[tempEnd]){
				tempStart--;
				tempEnd++;
			}
			tempStart++;
			tempEnd--;
			if((tempEnd-tempStart+1) > (end-start+1)){
				start = tempStart;
				end = tempEnd;
			}
			
			//even case
			tempStart = i;
			tempEnd = i+1;
			while(tempStart >= 0 && tempEnd < cArr.length && cArr[tempStart] == cArr[tempEnd]){
				tempStart--;
				tempEnd++;
			}
			tempStart++;
			tempEnd--;
			if((tempEnd-tempStart+1) > (end-start+1)){
				start = tempStart;
				end = tempEnd;
			}
		}
		return str.substring(start, end+1);
	}
}
