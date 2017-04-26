import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class RussianDoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{5,4}, {6,5}, {6,7}, {2,3}, {8,9}};
		System.out.println(maxEnvelopes(arr));

//		
//		System.out.println(lengthOfLongestSubstring("abcabcbb"));
//		System.out.println(lengthOfLongestSubstring("bbbbb"));
//		System.out.println(lengthOfLongestSubstring("pwwkew"));
//		int[] ar = {3,2,2,3};
//		System.out.println(removeElement(ar, 3));
	}

	public static int maxEnvelopes(int[][] envelopes){
		
		if(envelopes == null || envelopes.length == 0
			|| envelopes[0] == null || envelopes[0].length != 2)
		return 0;
		
		Arrays.sort(envelopes, new Comparator<int[]>(){
			@Override
			public int compare(int[] arr1, int[] arr2) {
				
				if(arr1[0] == arr2[0]) // width is same
					return arr2[1] - arr1[1];
				else
					return arr1[0] - arr2[0];
			}
		});

		int dp[] = new int[envelopes.length];
		int len = 0;
		
		// {{2,3}, {5,4}, {6,7}, {6,4} };
		for(int[] envelope: envelopes){
			int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
			if(index < 0)
				index = -(index + 1);
			dp[index] = envelope[1];
			if(index == len)
				len++;
		}
		return len;
	}
	   public static int lengthOfLongestSubstring(String s) {
	        if (s.length()==0) return 0;
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int max=0;
	        for (int i=0, j=0; i<s.length(); ++i){
	            if (map.containsKey(s.charAt(i))){
	                j = Math.max(j,map.get(s.charAt(i))+1);
	            }
	            map.put(s.charAt(i),i);
	            max = Math.max(max,i-j+1);
	        }
	        return max;
	    }
	   public static int removeElement(int[] A, int elem) {
		   int m = 0;    
		   for(int i = 0; i < A.length; i++){
		       if(A[i] != elem){
		           A[m] = A[i];
		           m++;
		       }
		   }
		   return m;
		}
}
