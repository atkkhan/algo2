import java.util.HashMap;

public class LngstSubStr {
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
	    HashMap<Character, Integer> count = new HashMap<>();     // there are 256 ASCII characters in the world
	    
	    int i = 0;  // i will be behind j
	    int num = 0;
	    int res = 0;
	    
	    for (int j = 0; j < s.length(); j++) {
	        if (count.get(s.charAt(j)) == null) {    // if count[s.charAt(j)] == 0, we know that it is a distinct character
	            num++;
	            count.put(s.charAt(j), 0);
	        }
	        count.put(s.charAt(j), count.get(s.charAt(j)) + 1);
	        
	        while (num > k && i < s.length()) {     // sliding window
	            //count[s.charAt(i)]--;
	        	count.put(s.charAt(i), count.get(s.charAt(i)) - 1);
	            if (count.get(s.charAt(i)) == 0){ 
	                num--;
	            }
	            i++;
	        }
	        res = Math.max(res, j - i + 1);
	    }
	    return res;
	}
	
	public static void main(String[] args){
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
	}
}
