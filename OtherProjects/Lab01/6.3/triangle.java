import java.util.Scanner;

public class triangle {
    public static void main(String[] args) {

        //Read the number of stars
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print the number of stars: ");
        int n = scanner.nextInt();
        
        //Algorithm to build the triangular shape
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (2*n-1); j++) {
                if (j >= (n-1-i) && j <= (n-1+i)) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.print("\n");
        }
        scanner.close();
        System.exit(0);
    }
}
