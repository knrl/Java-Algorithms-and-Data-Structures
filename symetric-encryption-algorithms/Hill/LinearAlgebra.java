// This code taken from geeks for geeks 
// https://www.geeksforgeeks.org/adjoint-inverse-matrix/

class LinearAlgebra{
	LinearAlgebra (){
		this.N = 2;
	}
	
	LinearAlgebra (int N){
		this.N = N;
	}

	private static int N;
	static void getCofactor(int A[][], int temp[][], int p, int q, int n){
		int i=0, j=0;
		for (int row=0;row<n;row++)
			for (int col=0;col<n;col++)
				if (row!=p && col!=q){
					temp[i][j++] = A[row][col];
					if (j == n - 1) { j=0; i++; }
				}
	}

	static int determinant(int A[][], int n){
		int D = 0;
		if (n == 1) return A[0][0];
		int [][] temp = new int [N][N];
		int sign = 1;
		for (int f=0;f<n;f++){
			getCofactor(A, temp, 0, f, n);
			D += sign * A[0][f] * determinant(temp, n - 1);
			sign *= -1;
		}
		return D;
	}

	public void adjoint(int A[][], int [][]adj){
		if (N == 1){
			adj[0][0] = 1;
			return;
		}
		int sign = 1;
		int [][] temp = new int[N][N];
		for (int i=0;i<N;i++)
			for (int j=0;j<N;j++){
				getCofactor(A, temp, i, j, N);
				sign = ((i+j) % 2 == 0) ? 1 : -1;
				adj[j][i] = (sign)*(determinant(temp, N-1));
			}
	}
	
	public int [][] inverse(int A[][]){
		int det = determinant(A, N);
		if (det == 0)
			System.out.println("Singular matrix, can't find it's inverse");
		
		int [][] adj = new int [N][N];
		adjoint(A, adj);
		int [][] inverseMatrix = new int [N][N];
		for (int i=0;i<N;i++) for (int k=0;k<N;k++) inverseMatrix[i][k] = adj[i][k] / det;
		return inverseMatrix;
	}

	public int [] myDot(int [][] matrix, int [] matrix2){
		// sum += a(i,k)*b(i, k) + ..
		int [] resultMatrix = new int [N];
		for (int i=0;i<N;i++)
			for (int k=0;k<N;k++)
				resultMatrix[i] += matrix[i][k] * matrix2[i];
		return resultMatrix;
	}
}
