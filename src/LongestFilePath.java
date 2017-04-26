import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class LongestFilePath {
	public static void main(String[] args){
		String str = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		String[] ar = str.split("\n");
		for(int i = 0; i < ar.length; ++i)
			System.out.println(ar[i]);
	
		
		Stack<Integer> stack = new Stack<>();
		//System.out.println(longestPath(-1, ar, 0,  stack, 0));
		

			//System.out.println(">" + stack.pop());

		
		System.out.println(lengthLongestPath2(str));
	}

	
	
	public static int lengthLongestPath2(String input) {
	    String[] paths = input.split("\n");
	    int[] stack = new int[paths.length+1];
	    int maxLen = 0;
	    for(String s:paths){
	        int lev = s.lastIndexOf("\t")+1;
	        int curLen = stack[lev]+s.length()-lev+1;
	        stack[lev+1] = curLen;
	        if(s.contains(".")) maxLen = Math.max(maxLen, curLen-1);
	    }
	    return maxLen;
	}
	
	public static int longestPath(int t, String[] ar, int i, Stack<Integer> stack, int c){

		if(i == ar.length) return -1;
		
		String s = ar[i];
		int tb = s.lastIndexOf("\t") + 1;
		if(t >= tb) return 0;		
		
		s.replaceAll("\t", "");

		if(s.contains(".ext")){
			if(stack.isEmpty() || stack.peek() < (c + s.length()))
				stack.push(c + s.length());	
			return 0;
		}
		
		boolean isRun = true;
		while(isRun){			
			 int r = longestPath(tb, ar, ++i, stack, c + s.length() + 1);
			 if(r == -1) return r;
		}
		return -1;
	}
}
