
public class SparseMatrix {
	public static void main(String[] args) {
		int[][] A = {
		     { 1, 0, 0},
		     {-1, 0, 3}
		};

		int[][] B = {
			{ 7, 0, 0 },
			{ 0, 0, 0 },
			{ 0, 0, 1 }
		 };
		
		int[][] r = multiply(A, B);
	}
	
	public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;   
    }
}
