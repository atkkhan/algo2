
public class MaxSubArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, -1, 5, -2, 3};
		System.out.println(maxSubArrayLen(arr, 3));
	}
	public static int maxSubArrayLen(int[] nums, int k) {
        //[1, -1, 5, -2, 3], k = 3,
        
        int l = 0, r = 0;
        int sum = 0;
        int max = 0;
        while(r < nums.length){
            
            sum += nums[r];
            if(sum > k){
                l++;
            }
            else if(sum < k){
                r++;
            }
            else{
                max = Math.max(max, r - l);
                r++;
            }
        }
        return max;
    }
}
