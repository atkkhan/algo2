import java.util.HashMap;

public class MaxSubArrayLen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3, 1, -1, 5, -2, 3};
		System.out.println(maxSubArrayLen(a,3));
	}

	public static int maxSubArrayLen(int[] nums, int k) {
	    int sum = 0, max = 0;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        sum = sum + nums[i];
	        if (sum == k) max = i + 1;
	        else if (map.containsKey(sum - k)) {
	        	max = Math.max(max, i - map.get(sum - k));
	        }
	        if (!map.containsKey(sum)) map.put(sum, i);
	    }
	    return max;
	}
}
