import java.util.ArrayList;

public class GETest {
    public static void StairCase(int n) {

        for(int i = 0; i < n; i++){
            int j = i;
            while(j < n -1){
                System.out.print(" ");
                j++;
            }
            int k = n - 1 - i;
            while(k < n){
                System.out.print("#");
                k++;
            }
            System.out.println("");
        }
    }

    static int[] counts(int[] nums, int[] maxes) {
        int[] res = new int[maxes.length];
        ArrayList<Integer> ar = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
        	ar.add(nums[i]);
        }
        
        for(int i = 0; i < maxes.length; i++){
            for(int j  = 0; j < ar.size(); j++){
                if(ar.get(j) <= maxes[i]){
                    res[i]++;              
                }
            }
        }
        return res;
    }
    
    
    public static void main(String[] ar){
    	int[] a = {2,10,5,4,8};
    	int[] b = {1,3,7,8};
    	int[] c = counts(a,b);
    	
    	for(int i = 0; i < c.length; i++)
    		System.out.println(c[i]);
    	
    }
}
