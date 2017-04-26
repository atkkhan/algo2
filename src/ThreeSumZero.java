import java.util.ArrayList;
import java.util.List;

public class ThreeSumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> l = threeSum(a);
		for(List ll : l)
			System.out.println(ll.toString());
		//System.out.println(l.size());
	}

	
    public static List<List<Integer>> threeSum(int[] nums) {
       
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            int sum = 0;
            int l = 0, r = 0;
            while(r < nums.length){
            	
                sum = ((l == 0)? sum: sum - nums[l-1] ) + nums[r];
                
                if((r - l + 1) == 3){
                    if(sum == 0){
                        List lst = new ArrayList<Integer>();
                        lst.add(nums[l]);
                        lst.add(nums[l+1]);
                        lst.add(nums[r]);
                        list.add(lst);
                    }
                    else{
                        //sum = sum - nums[r];
                        int i = r + 1;
                        while(i < nums.length){
                            if(sum - nums[r]+ nums[i] == 0) {
                                List lst = new ArrayList<Integer>();
                                lst.add(nums[l]);
                                lst.add(nums[l+1]);
                                lst.add(nums[i]);
                                list.add(lst);
                            }
                            i++;
                        }
                    }
                    l++;
                }           
                r++;
            }
            return list;
        }
    
}
