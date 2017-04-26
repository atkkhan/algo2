import java.util.PriorityQueue;

public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {2,1,3,4,5};
		System.out.println(findKthLargest(ar, 3));

	}
	
    public static int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        heap[k - 1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int n = nums[i];
            int j = k - 1;
        
            while(j >= 0){
                if(n >= heap[j]){
                    int t = heap[j];
                    heap[j] = n;
                    n = t;
                }
                j--;
            }
            
        }
        return heap[0];
    }
	
	public static int findKthLargestx(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
}
