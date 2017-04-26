
public class PoorPigs {
	public static void main(String[] args){
		int buckets = 25, minutesToDie = 15, minutesToTest = 60;
		int pigs = 0;
		    while (Math.pow((minutesToTest / minutesToDie + 1), pigs) < buckets){
		    	int v = (minutesToTest / minutesToDie) + 1;
		    	double p = Math.pow(v, pigs);
		    	System.out.println(v + " " + p);
		    		pigs += 1;
		    		
		    }
		        
		System.out.println(pigs); 
	}
}
