
public class MajorityNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 4, 5, 3, 2, 5, 4, 4};
		System.out.println(majorityElement(a));
	}

	public static int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
          
        }
        return major;
    }
}
