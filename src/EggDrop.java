
public class EggDrop {
	public static int hop = 4;

	public static void main(String[] args){
		System.out.println(floor(11));
	}
	
	
	public static int floor(int numOfFloors){
		return floor(numOfFloors, true, true);
	}

	private static int floor(int nf, boolean egg1, boolean egg2){

	  if(nf <= 0)
	    return -1;
	  
	  //base case
	  if(nf <= hop){
		if(breaks(nf))
			egg1 =false;
	  }
	  else{
	    int i = floor(nf - hop, egg1, egg2);	    
	    if (i == -1 || i > 0)
	      return i;

	    if(breaks(nf))
	    	egg1 = false; 
	  }
	  
	  if(!egg1){
	    int j = 1;
	    while(j <= hop){
	      if(breaks(nf - hop + j))
	        return nf - hop + j;
	      j++;
	    }
	  }
	    return 0;
	}
	
	public static boolean breaks(int fl){
		if(fl < 1) return false;
		if(fl >= 2){
			return true;
		}
		return false;
	}
}
