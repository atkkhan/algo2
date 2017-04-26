import javax.swing.plaf.synth.SynthSeparatorUI;

public class RegExMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch1("aa", "a*"));
	}

    public static boolean isMatch1(String s, String p) {
        boolean memo[][] = new boolean[s.length() + 1] [p.length() + 1];
        memo[0][0] = true;
        for(int i = 1; i < memo[0].length; i++){
            if(p.charAt(i -1) == '*')
                memo[0][i] = memo[0][i - 2];
        }
        
        for(int i = 1; i < memo.length; i++){
            for(int j = 1; j < memo[0].length; j++){
                if(p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)){
                    memo[i][j] = memo[i -1][j - 1];
                }
                else if(p.charAt(j - 1) == '*'){
                    memo[i][j] = memo[i][j - 2];
                    if(p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)){
                        memo[i][j] = memo[i][j] || memo[i - 1][j];
                    }
                }
                else{
                    memo[i][j] = false;
                }
            }
        }
        return memo[s.length()][p.length()];
     }
	
	public static boolean isMatch(String s, String p) {
	    /*
	        'match' below including .
	    f(i,j) means s where s.len=i matches p where p.len=j
	    f(i,j) =
	        if (p_j-1 != * ) f(i-1, j-1) and s_i-1 matches p_j-1
	        if (p_j-1 == * )
	            * matches zero times: f(i,j-2)
	            or * matches at least one time: f(i-1,j) and s_i-1 matches p_j-2
	     */

	    if (!p.isEmpty() && p.charAt(0) == '*') {
	        return false;   // invalid p
	    }

	    boolean[][] f = new boolean[s.length() + 1][p.length() + 1];

	    // initialize f(0,0)
	    f[0][0] = true;

	    // f(k,0) and f(0,2k-1) where k>=1 are false by default

	    // initialize f(0,2k) where p_2k-1 = * for any k>=1
	    for (int j = 1; j < p.length(); j+=2) {
	        if (p.charAt(j) == '*') {
	            f[0][j+1] = f[0][j-1];
	        }
	    }

	    for (int i = 1; i <= s.length(); i++) {
	        for (int j = 1; j <= p.length(); j++) {
	        	
	            if (p.charAt(j - 1) != '*') {
	                f[i][j] = f[i - 1][j - 1] && isCharMatch(s.charAt(i - 1), p.charAt(j - 1));
	            } else {
	                f[i][j] = f[i][j - 2] || f[i - 1][j] && isCharMatch(s.charAt(i - 1), p.charAt(j - 2));
	            } 	
	            print(f);
	        }
	    }

	    return f[s.length()][p.length()];
	}

	// no * in p
	private static boolean isCharMatch(char s, char p) {
		System.out.println(s + " : " + p);
	    return p == '.' || s == p;
	}
	
	private static void print(boolean[][] ar){
		
		for(int i = 0; i < ar.length; i++){
			for(int j = 0; j < ar.length; j++){
				System.out.print(ar[i][j] + ", ");
			}
			System.out.println("");
		}
		System.out.println("----------------------");
	}
	
}
