
public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {1,5,3,1,5,1,5,4,4,4};
		System.out.println(singleNumber(ar));
		printBits(2);
	}
	
	public static String printBits(int a) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 4; i++){
			sb.append((a >> i & 1) == 1 ? "1": "0");
			
		}
		//System.out.println(sb.reverse().toString());
		return sb.reverse().toString();
	}
	
	public static int singleNumber(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        System.out.print(printBits(A[i]) + " : ones: " + printBits(ones));
	        twos = (twos ^ A[i]) & ~ones;
	        System.out.println(": twos: " + printBits(twos));
	        
	    }
	    return ones;
	}
}
