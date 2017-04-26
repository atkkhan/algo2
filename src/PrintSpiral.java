
public class PrintSpiral {

	public static void main(String[] args){
		int arr[][] = {
				  {1, 2, 3, 4}
				  ,{12,13,14,5}
				  ,{11,16,15,6}
				,{10,9,8,7}
		};
		print(arr, arr.length, arr[0].length);
	}
	
	public static void print(int[][] a, int m, int n){
		int row = m - 1;
		int col = n - 1;

		while(row >= 0 && col >= 0){
			for(int i = n - col - 1 ; i <= col; i++){
				System.out.print(a[m - row - 1][i] + " -> ");
			}
			System.out.print(",");
			for(int i = m - row; i <= row; ++i){
				System.out.print(a[i][col] + " \\");
			}				
			System.out.print(",");
			for(int i = col - 1; i >= n - col -1 && row > m - row - 1; --i){
				System.out.print(a[row][i] + " <-");
			}
			System.out.print(",");
			for(int i = row - 1; i >=  m - row && col > n - col - 1; --i){
				System.out.print(a[i][n - col - 1] + " /");
			}
			System.out.print("--");
			row--;
			col--;
		}
	}
}
