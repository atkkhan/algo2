
public class ClimbStair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climb(5));
	}
	
	public static int climb(int n){
		if(n == 0) return 1;
		if(n < 0) return 0;
		
		return climb(n - 1) + climb(n - 2);
	}

}
