import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TwoSum {
        Set<Integer> sum;
        Set<Integer> num;
        
        TwoSum(){
            sum = new HashSet<Integer>();
            num = new HashSet<Integer>();
        }
        // Add the number to an internal data structure.
    	public void add(int number) {
    	    if(num.contains(number)){
    	        sum.add(number * 2);
    	    }else{
    	        Iterator<Integer> iter = num.iterator();
    	        while(iter.hasNext()){
    	            sum.add(iter.next() + number);
    	        }
    	        num.add(number);
    	    }
    	}
    
        // Find if there exists any pair of numbers which sum is equal to the value.
    	public boolean find(int value) {
    	    return sum.contains(value);
    	}
    	
    	
    	public static void main(String[] args){
    		TwoSum ts = new TwoSum();
    		ts.add(1); ts.add(3); ts.add(5);
    		System.out.println(ts.find(4));
    		System.out.println(ts.find(7));
 
    	}
    }

//alt - write is quick n(1), read takes time
//public class TwoSum {
//    Map<Integer,Integer> hm;
//    
//    TwoSum(){
//        hm = new HashMap<Integer,Integer>();
//    }
//    // Add the number to an internal data structure.
//	public void add(int number) {
//	    if(hm.containsKey(number)){
//	        hm.put(number,2);
//	    }else{
//	        hm.put(number,1);
//	    }
//	}
//
//    // Find if there exists any pair of numbers which sum is equal to the value.
//	public boolean find(int value) {
//	    Iterator<Integer> iter = hm.keySet().iterator();
//	    while(iter.hasNext()){
//	        int num1 = iter.next();
//	        int num2 = value - num1;
//	        if(hm.containsKey(num2)){
//	            if(num1 != num2 || hm.get(num2) == 2){
//	                return true;
//	            }
//	        }
//	    }
//	    return false;
//	}
//}