import java.util.Arrays;

public class LicensKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Input: S = "2-4A0r7-4k", K = 4
//		Output: "24A0-R74K"
		System.out.println(licenseKeyFormatting1("2-4A0r7-4k", 4));
		
//		Input: S = "2-4A0r7-4k", K = 3
//		Output: "24-A0R-74K"
		System.out.println(licenseKeyFormatting1("2-4A0r7-4k", 3));
	}
	
	public static String licenseKeyFormatting(String S, int K) {
	    S = S.replaceAll("-", "").toUpperCase();
	    StringBuilder sb = new StringBuilder(S);
	    // Starting from the end of sb, and going backwards. 
	    int i = sb.length() - K;
	    while(i > 0) {
	        sb.insert(i, '-');
	        i = i - K;
	    }
	    return sb.toString();
    } 
	
	public static String licenseKeyFormatting1(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    } 
}
