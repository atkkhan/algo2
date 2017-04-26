import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Test11 {
	public static void main(String[] args){
//		List<String> l = letterCombinations("23");
//		for(String s : l){
//			System.out.print(s + ", ");
//		}
		//System.out.println(2%10);
//		int[] nums = {2, 3, 4, 6, 9};
//		
//		int[] r = twoSum(nums, 9);
		
		//System.out.println(convert("PAYPALISHIRING", 4));
		System.out.println(isValid("{}[]"));
		
//		
//		//public int[] countBits(int num) {
//		int num = 5;
//		    int[] f = new int[num + 1];
//		    for (int i=1; i<=num; i++) {
//		    	System.out.print(i);
//		    	System.out.print(i >> 1 ); 
//		    	System.out.print(" ");
//		    	System.out.print(f[i >> 1]);
//		    	System.out.print(" ");
//		    	System.out.println(i & 1);
//		    	f[i] = f[i >> 1] + (i & 1);
//		    }
//		    System.out.println("");
//		    
//		 for(int i = 0; i < f.length; i++)
//			 System.out.print(f[i] + ", ");
//		    //return f;
//		//}
		int[] A = {0, 2, 1, 4, 3, 4};
//		
//        int n = A.length;
//        //if(n < 2) return n;
//		int id = 1;
//		for(int i = 1; i < n; ++i) 
//		    if(A[i] != A[i-1]) A[id++] = A[i];
	//	System.out.println(containsNearbyDuplicate(A, 3));
	}
	
	
//	public static boolean isHappy(int n) {
//        int sl = n, fs = n;
//        do{
//            sl = happy(sl);
//            fs = happy(happy(fs));
//        }while(sl != fs || fs != 1);
//        return 1;
//    }
//    
//    private static int happy(int n){
//        int ps = 0;
//        while(n > 0){
//            ps += Math.power(n % 10);
//            n /= 10;
//        }
//        return ps;
//    }
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }
	
    public static String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
	
	public static int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}
	
	 public static boolean isValid(String s) {
	        Stack<Character> stack = new Stack<>();
	        
	        int i = 0;
	        while(i < s.length()){
	            char c = s.charAt(i);
	            
	            
	            if(c == '{'){
	                stack.push('}');
	            }
	            if(c == '['){
	                stack.push(']');
	            }
	            if(c == '('){
	                stack.push(')');
	            }
	            else{
	                if(stack.isEmpty() || stack.peek() != c) return false;
	                
	                stack.pop();
	            }
	            ++i;
	        }
	        return true;
	    }
    public static List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def"};
        
        List<String> rtn = new ArrayList<>();
        rtn.add("");
        for(int i = 0; i < digits.length(); i++){
            String str = mapping[Character.getNumericValue(digits.charAt(i))];
            
            while(i == rtn.get(0).length()){
                String last = rtn.remove(0);
                for(int j = 0; j < str.length(); j++){
                    rtn.add(last + str.charAt(j));
                }
            }
        }
        return rtn;
    }
    
}


