import java.util.Arrays;
import java.util.Scanner;

public class sort_array {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        //Read in the range of array
        System.out.println("Enter the number of elements of array: ");
        int n = read.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        
        //Read in the value of elements
        System.out.println("Enter the value of elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = read.nextInt();
        }

        //Operation of Array to sort values
        Arrays.sort(arr);

        //Print ouf the sorted Array, sum and avarage values
        System.out.print("Array sorted: ");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
            sum += arr[i];
        }
        System.out.println("\nSum: " + sum +"\nAverage: " + sum/n);
        read.close();
        System.exit(0);
    }
}
