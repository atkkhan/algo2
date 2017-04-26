import java.util.Stack;

public class BTree {

	public static void main(String[] args){

		TreeNode r3 = new TreeNode(250, null, null);
		TreeNode r4 = new TreeNode(76, null, null);
		TreeNode r5 = new TreeNode(150, null, null);
		TreeNode r2 = new TreeNode(50, r3, r4);		
		TreeNode r1 = new TreeNode(100, r2, r5);
		System.out.println(isBST(r1, null));
	}
	
	public static boolean isBST(TreeNode root, TreeNode prev){
		
		if(root == null) return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(node != null){
			stack.add(node);
			node = node.leftChild;
		}
			
		while(!stack.isEmpty()){
			node = stack.pop();
			System.out.println((prev == null)? "" : prev.data + " : " + node.data);
			if(prev != null && prev.data >= node.data)
				return false;
			prev = node;
			if(node.rightChild != null){
				node = node.rightChild;
				while(node != null){
					stack.add(node);
					node = node.leftChild;
				}
			}
		}
		return true;
	}
	
//    Node INVALID_NODE = new Node();
//    boolean checkBST(Node root) {
//        INVALID_NODE.data = Integer.MAX_VALUE;
//        return (checkBST( root, null) == INVALID_NODE)? false: true;
//    }
//
//    private Node checkBST(Node root, Node pre){
//        if(root == null) return pre;
//        pre = checkBST(root.left, pre);
//        if(pre != null && pre.data >= root.data) return INVALID_NODE;
//        return checkBST(root.right, root);
//    }

}
class TreeNode{
	public TreeNode leftChild = null;
	public TreeNode rightChild = null;
	public int data = -1;
	
	public TreeNode(int data, TreeNode left, TreeNode right){
		this.data = data;
		this.leftChild = left;
		this.rightChild = right;
	}
}