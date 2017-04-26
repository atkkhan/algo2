
public class WordDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		
		shortestWordDistance(words, "makes", "makes");
	}
	public static int shortestWordDistance(String[] words, String word1, String word2) {
	    long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
	    boolean same = word1.equals(word2);
	    for (int i=0; i<words.length; i++) {
	        if (words[i].equals(word1)) {
	            if (same) {
	                i1 = i2;
	                i2 = i;
	            } else {
	                i1 = i;
	            }
	        } else if (words[i].equals(word2)) {
	            i2 = i;
	        }
	        dist = Math.min(dist, Math.abs(i1 - i2));
	    }
	    return (int) dist;
	}
}
