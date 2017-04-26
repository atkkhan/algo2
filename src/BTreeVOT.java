import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BTreeVOT {
	public static void main(String[] agrs){
		TreeNode r4 = new TreeNode(7, null, null);
		TreeNode r5 = new TreeNode(15, null, null);
		
		TreeNode r3 = new TreeNode(20, r5, r4);
		TreeNode r2 = new TreeNode(9, null, null);		
		TreeNode r1 = new TreeNode(3, r2, r3);
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		VOT(r1, 0, map);
		for(Integer i : map.keySet()){
			System.out.println(map.get(i).toString());
		}
	}
	
	public static void VOT(TreeNode root, int col, Map<Integer, ArrayList<Integer>> map){
		if(root == null) return;
		VOT(root.leftChild, col - 1, map);
		if(map.containsKey(col)){
			map.get(col).add(root.data);
		}
		else{
			ArrayList<Integer> l = new ArrayList<>();
			l.add(root.data);
			map.put(col, l);
		}
		VOT(root.rightChild, col + 1, map);
	}
}
