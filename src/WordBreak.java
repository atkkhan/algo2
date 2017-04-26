import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<>();
		set.add("leet");
		set.add("code");
		wordBreak("leetcode", set);
	}
    public static boolean wordBreak(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];        
        f[0] = true;
    
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
            	System.out.println(s.substring(j, i));
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}
