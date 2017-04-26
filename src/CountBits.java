
public class CountBits {
	public static void main(String[] args){
		
		int i = 11;
		
		System.out.println(count(i));
		
	}
	public static int count(int i){
		int count = 0;
		while(i > 0){
			if((i & 1) == 1) count++;
			i = i >> 1;
		}
		return count;
	}
}
