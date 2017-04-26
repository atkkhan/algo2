import java.util.HashSet;
import java.util.Set;

public class MaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = {7, 1, 5, 3, 6, 7};
		System.out.println(maxProfit2(arr1));
		
		int[] arr2 = {7, 6, 4, 3, 1};
		System.out.println(maxProfit2(arr2));
		
//		Set<String> set = new HashSet<>();
//		set.add("leet");
//		set.add("code");
//		System.out.println(wordBreak("leetcode", set));
	}
	
	public static int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
	
	
	public static int maxProfit2(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
        	System.out.println("i: " + i  + ", price: " + prices[i] + ", min:" + min + ", max:" + max);
            if (prices[i] < min) min = prices[i];
            else if (prices[i] > min) max = Math.max(prices[i] - min, max);
        }
        return max;
    }
	
    public static boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i && !f[i]; j++){
            	f[i] = wordDict.contains(s.substring(j - 1, i)) && f[j - 1];
            	System.out.println("i:" + i + ", j:" + j + ", " + f[i]  + ", " + s.substring(j - 1, i));
                
            }
        return f[n];
    }
}
