import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class TreeNodex{
	public int val;
	public TreeNodex left;
	public TreeNodex right;
	public TreeNodex(int v, TreeNodex l, TreeNodex r){
		this.val = v;
		this.left = l;
		this.right = r;
	}
	
	public TreeNodex(int v){
		this.val = v;
	}
}


class Codec {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNodex root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNodex node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNodex deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private TreeNodex buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNodex node = new TreeNodex(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
public class SerializeBT {
	public static void main(String[] args){
		
		TreeNodex t1 = new TreeNodex(1);
		TreeNodex t2 = new TreeNodex(2);
		TreeNodex t3 = new TreeNodex(3);
		TreeNodex t4 = new TreeNodex(4);
		TreeNodex t5 = new TreeNodex(5);
		
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		Codec cd = new Codec();
		System.out.println(cd.serialize(t1));
		TreeNodex s = cd.deserialize(cd.serialize(t1));
	}
	

}