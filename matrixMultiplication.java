package MatrixMultiplication;

// public class matrixMultiplication {
//     public static int[][] multiply(int[][] A, int[][] B) {
//         int m = A.length;
//         int n = B[0].length;
//         int p = B.length;

//         // Initialize the result matrix C with zeros
//         int[][] C = new int[m][n];

//         // Perform matrix multiplication using nested loops
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 for (int k = 0; k < p; k++) {
//                     C[i][j] += A[i][k] * B[k][j];
//                 }
//             }
//         }

//         return C;
//     }

//     public static void printMatrix(int[][] matrix) {
//         for (int[] row : matrix) {
//             for (int value : row) {
//                 System.out.print(value + " ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         int[][] matrixA = {
//             {1, 2, 3},
//             {4, 5, 6}
//         };

//         int[][] matrixB = {
//             {7, 8},
//             {9, 10},
//             {11, 12}
//         };

//         System.out.println("Matrix A:");
//         printMatrix(matrixA);

//         System.out.println("Matrix B:");
//         printMatrix(matrixB);

//         int[][] result = multiply(matrixA, matrixB);

//         System.out.println("Result Matrix C:");
//         printMatrix(result);
//     }
// }


public class matrixMultiplication {
    public static int [][] multiply(int[][] A, int[][] B){

        int m = A.length;
        int n = B[0].length;
        int p = B.length;

        int [][] C = new int[m][n];

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                for(int k =0; k<p; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void printMatrix(int [][] matrix){
      for(int [] row: matrix){
            for(int value: row){
                System.out.print(value+ " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int [][] matrixA = {
            {2,4,6},
            {4,8,3}
        };

        int [][] matrixB = {
            {3,7},
            {6,3},
            {9,4}
        };

        System.out.println("Matrix A:");
        printMatrix(matrixA);
        System.out.println("Matrix B:");
        printMatrix(matrixB);

        
        int [][] result =  multiply(matrixA, matrixB);
        System.out.println("Result matrixC:");
        printMatrix(result);
}
}