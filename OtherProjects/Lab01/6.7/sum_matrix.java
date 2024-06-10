import java.util.Scanner;

public class sum_matrix {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        //Read matrix size
        System.out.println("Enter the size of row : ");
        int r = read.nextInt();
        System.out.println("Enter the size of column : ");
        int c = read.nextInt();
        int[][] matrix_1 = new int[r][c];
        int[][] matrix_2 = new int[r][c];
        int[][] matrix_sum = new int[r][c];
        
        //Read in matrix A
        System.out.println("Enter the values of matrix 1: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix_1[i][j] = read.nextInt();
            }
        }
        //Read in matrix B
        System.out.println("Enter the values of matrix 2: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix_2[i][j] = read.nextInt();
            }
        }

        //Cal sum of two matrices
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix_sum[i][j] = matrix_1[i][j] + matrix_2[i][j];
            }
        }
        //Print out results
        System.out.println("Sum of 2 matrices: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix_sum[i][j] +" ");
            }
            System.out.print("\n");
        }
        read.close();
        System.exit(0);
    }
}
