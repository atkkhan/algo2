import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestDistance {

		private Map<String, List<Integer>> map;

		public void WordDistance(String[] words) {
		    map = new HashMap<String, List<Integer>>();
		    for(int i = 0; i < words.length; i++) {
		        String w = words[i];
		        if(map.containsKey(w)) {
		            map.get(w).add(i);
		        } else {
		            List<Integer> list = new ArrayList<Integer>();
		            list.add(i);
		            map.put(w, list);
		        }
		    }
		}

		public int shortest(String word1, String word2) {
		    int min = Integer.MAX_VALUE;
		    for(Integer num1: map.get(word1)) {
		        for(Integer num2: map.get(word2)) {
		            min = Math.min(min, Math.abs(num1 - num2));
		        }
		    }
		    return min;
		}
		
		public static void main(String[] args){
			String[] strs = {"practice", "makes", "perfect", "coding", "makes"};
			ShortestDistance sd = new ShortestDistance();
			sd.WordDistance(strs);
			System.out.println(">" + sd.shortest("practice", "perfect"));
		}
	}