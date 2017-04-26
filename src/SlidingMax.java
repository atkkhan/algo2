import java.util.LinkedList;

public class SlidingMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = {1, 3, -1, -3, 5, 3, 6, 7};
		
		int[] r = maxSlidingWindow(v, 3);
		for(int i = 0; i < r.length; i++)
			System.out.print(r[i] + ", ");
	}
	
	    public static int[] maxSlidingWindow(int[] nums, int k) {
	        int n = nums.length;
	        if (n == 0) {
	            return nums;
	        }
	        
	        int[] result = new int[n - k + 1];
	        LinkedList<Integer> dq = new LinkedList<>();
	        for (int i = 0; i < n; i++) {
	            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
	                dq.poll();
	            }
	            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
	                dq.pollLast();
	            }
	            dq.offer(i);
	            if (i - k + 1 >= 0) {
	                result[i - k + 1] = nums[dq.peek()];
	            }
	        }
	        return result;
	    }
	
}
