
public class RotateImage {
	public static void main(String[] main){
		int[][] ar = {
				{1, 2, 3}
				,{4, 5, 6}
				,{7, 8, 9}				
		};
		 rotate(ar);
		 for(int i = 0; i < ar.length; i++){
			 for(int j = 0; j < ar.length; j++)
				 System.out.print(ar[i][j] + ",");
			 System.out.println("");
		 }
	}
	
	public static void rotate(int[][] ar){
		
		int layers = ar.length / 2;
		
		for(int layer = 0; layer < layers; layer++){
			int end = ar[0].length - 1 - layer;
			int first = layer;
			for(int i = first; i < end; i++){
				int offset = i - first;
				int tmp = ar[first][i];
				ar[first][i] = ar[end - offset][first];
				ar[end - offset][first] = ar[end][end - offset];
				ar[end][end - offset] = ar[i][end];
				ar[i][end] = tmp;
			}
		}
	}
}
