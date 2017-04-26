import java.util.HashMap;

public class MinWindowString {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBBANC","ABC"));
		
	}
	
	
    public static String minWindow(String s, String t) {
    
    	int[] map = new int[256];
        
    	int i = 0;
        while(i < t.length()){
            map[t.charAt(i++)]++;
        }
        
        int end = 0, start = 0, count = t.length();
        String minStr = "";
        int minLength = Integer.MAX_VALUE;
        
        while(end < s.length()){
            if(map[s.charAt(end)] > 0){
            	count--;
            }
            map[s.charAt(end++)]--;
            
            while(count == 0){
            	 System.out.println(s.substring(start, end));
                if(minLength > end - start){
                    minLength = end - start;
                    minStr = s.substring(start, end);
                   
                }
                
                 map[s.charAt(start)]++;
                 if(map[s.charAt(start)] > 0){
                    count++;
                }
               
                start++;
            } 
        }

        return minStr;
    }
}
