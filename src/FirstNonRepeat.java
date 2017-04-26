	import java.util.HashMap;

class Node{
	Node next = null;
	int data;
	
	public Node(int d, Node n){
		this.next = n;
		this.data = d;
	}
}

public class FirstNonRepeat {
	public static void  main(String[] args){
		//System.out.println(firstNonRepeatChar("leetcode"));
		
		Node n1 = new Node(5,null);
		Node n2 = new Node(3,n1);
		Node n3 = new Node(1,n2);
		Node n= new Node(0, null);
		
		Node n4 = reverse(n3, n);
		while(n != null){
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public static Node reverse(Node n, Node h){
		if(n == null)
			return null;
		Node r = reverse(n.next, h);
		if(r == null){
			r = h;
			r.data = n.data;
			r.next = null;
			return r;
		}
		Node nn = new Node(n.data, r.next);
		r.next = nn;
		return nn;
	}
	
	public static int firstNonRepeatChar(String str){
		if (str == null || str.length() == 0) return -1;
		int i = 0, j = 0;
		while(i < str.length()){
			if(str.charAt(i) != str.charAt(j) && i == str.length() - 1)
				return j;
			else if(str.charAt(i) == str.charAt(j) && j < i)
				j++;
			else
				i++;	
		}
		return -1;
	}
}
