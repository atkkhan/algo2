
public class longestPal {
	public static void main(String[] arg){		
		System.out.println(longestPalindrome("babad"));
	}
	
    public static String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i), s2 = extend1(s, i, i + 1);
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }
    
    private static String extend(String s, int i, int j) {
    	
        for (; 0 <= i && j < s.length(); i--, j++) {
        	
        	System.out.println("i: " + i + ", j:" + j + ", " + s.charAt(i) + ", " + s.charAt(j));
            if (s.charAt(i) != s.charAt(j)) break;
        }
        System.out.print("i: " + i + ", j:" + j );
        System.out.println(", ss:" + s.substring(i + 1, j));
        return s.substring(i + 1, j);
    }
    private static String extend1(String s, int i, int j) {
    
    	
        for (; 0 <= i && j < s.length(); i--, j++) {
        	
        	System.out.println("--i: " + i + ", j:" + j + ", " + s.charAt(i) + ", " + s.charAt(j));
            if (s.charAt(i) != s.charAt(j)) break;
        }
        System.out.print("--i: " + i + ", j:" + j );
        System.out.println(", ss:" + s.substring(i + 1, j));
        return s.substring(i + 1, j);
    }
}
