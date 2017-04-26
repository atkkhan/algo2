
public class MoveZerosToEnd {

	public static void main(String[] args){
		int[] ar = {0, 1, 0, 3, 12};
		MoveZerosToEnd(ar);
	}
	
	public static void MoveZerosToEnd(int[] nums){
		   if (nums == null || nums.length == 0) return;        

		    int insertPos = 0;
		    for (int num: nums) {
		        if (num != 0) nums[insertPos++] = num;
		    }        

		    while (insertPos < nums.length) {
		        nums[insertPos++] = 0;
		    }	
//		int i = 0;
//		while(i < ar.length){
//			if(ar[i] == 0){
//				int j = i + 1;
//				while(j < ar.length){
//					if(ar[j] != 0){
//						ar[i] = ar[j];
//						break;
//					}
//					++j;
//				}
//				i = j;
//			}
//			++i;
//		}
	}
}
