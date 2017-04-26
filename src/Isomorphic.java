import java.util.HashMap;

public class Isomorphic {

	public static boolean isIsomorphic(String s, String t){
		
		if(s.length() != t.length()) return false;
		
        int m1[] = new int[256], m2[] = new int[256];
        int count = 1;
        for(int i=0; i<s.length(); i++) {
            if(m1[s.charAt(i)]!=m2[t.charAt(i)]) return false;
            if(m1[s.charAt(i)]==0) {
                m1[s.charAt(i)]=count;
                m2[t.charAt(i)]=count;
                count++;
            }
        }
        return true;
	}
	
	
	
	public static boolean isIsomorphic2(String s, String t){
		
		if(s.length() != t.length()) return false;
		
        HashMap<Character, Character> m1 = new HashMap<>();
        HashMap<Character, Character> m2 = new HashMap<>();
        
        int count = 1;
        for(int i=0; i<s.length(); i++) {
            if(m1.get(s.charAt(i)) == null && m2.get(t.charAt(i)) == null) {
                m1.put(s.charAt(i), t.charAt(i));
                m2.put(t.charAt(i), s.charAt(i));
            }
            else if(m2.get(t.charAt(i)) == null && m1.get(s.charAt(i)) != null) return false;
            else if(m1.get(s.charAt(i)) == null && m2.get(t.charAt(i)) != null) return false;

//            else if(m1.get(s.charAt(i)) != t.charAt(i)) return false;
//            else if(m2.get(t.charAt(i)) != s.charAt(i)) return false;

        }
        return true;
	}
	public static void main(String[] args){
		System.out.println(isIsomorphic2("egg", "add"));
		System.out.println(isIsomorphic2("egs", "add"));
	}
}
