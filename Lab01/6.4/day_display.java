import java.util.Scanner;
import java.util.Arrays;

public class day_display {
    public static void main(String[] args) {

        //String initializes
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December",
                            "Jan.","Feb.","Mar.","Apr.","May","June","July","Aug.","Sept.","Oct.","Nov.","Dec.",
                            "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec",
                            "1","2","3","4","5","6","7","8","9","10","11","12"};
        Scanner read = new Scanner(System.in);
        String read_month; 
        int year = 0, LeapYear = 0;

        //Read in the value of month, year
        System.out.println("Enter the month: ");
        while (true) {
            read_month = read.next();
            if (!Arrays.asList(months).contains(read_month)) {
                System.out.println("Fail to enter the month, pls enter again!");
                continue;
            }
            else break;
        }
        System.out.println("Enter the year: ");
        while (true) {
        if (read.hasNextInt()) {
            year = read.nextInt();  
                if (year < 0) {
                    System.out.println("Fail to enter the year, pls enter again!");
                    continue;
                }
                else break;
        }
        else {
            System.out.println("Fail to enter the year, pls enter again!");
        }
        }

        //Check LeapYear or not
        if (year%4 == 0) {
            if (year%100 == 0 && year%400 != 0) LeapYear = 0;
            else LeapYear = 1;
        }
        //Display the number of days in month
        switch (read_month) {
            case "January","Jan.","Jan","1","March","Mar.","Mar","3","May","5","July","Jul","7","August","Aug.","Aug","8",
                 "October","Oct.","Oct","10","December","Dec.","Dec","12":
                System.out.println("Number of days of month " + read_month + " is: 31");
                break;
            case "February","Feb.","Feb","2":
            if (LeapYear == 1) System.out.println("Number of days of month " + read_month + " is: 29");
            else System.out.println("Number of days of month " + read_month + " is: 28");
            case "April","Apr.","Apr","4","June","Jun","6","September","Sept.","Sep","9","November","Nov.","Nov","11":
            System.out.println("Number of days of month " + read_month + " is: 30");
                break;
            default:
                break;
        }
        read.close();
        System.exit(0);
    }
}
