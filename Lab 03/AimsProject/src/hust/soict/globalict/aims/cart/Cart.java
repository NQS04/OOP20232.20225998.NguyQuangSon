package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.disc.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    public static final int MAX_ORDER = 20;
    private DVD list[] = new DVD[MAX_ORDER];
    private static int quantity = 0;
    
    public int getQuantity() {
        return quantity;
    }

    public DVD[] getList() {
        return list;
    }

    //RemoveDVD
    public void removeDVD(DVD disc) {
        for (int i = 0; i < quantity;i++) {
            if (disc.equals(list[i])) {
                for (int j = i; j < quantity - 1; j++) list[j] = list[j+1];
                quantity--;
                System.out.println("Remove "+  disc.getTitle() +" successfully");
                break;
            }
        }
    }

    //addDVD
    public void addDVD(DVD disc) {
        if (quantity == MAX_ORDER) System.out.println("The cart is almost full");
        else {
            list[quantity] = disc;
            quantity++;
            System.out.println("The disc "+ disc.getTitle() +" has been added to cart");
        }
    }

    //addDVD #2
    public void addDVD(ArrayList<DVD> discList) {
            if (quantity == MAX_ORDER) System.out.println("the cart is almost full");
            else {
                // System.out.println(quantity);
                int count = 0;
                for (int i = quantity; i < discList.size() + quantity; i++) {
                    list[i] = discList.get(count);
                    count++;
                }
                quantity += discList.size();
            }
    }

    //addDVD #3
    public void addDVD(DVD disc1, DVD disc2) {
        if (quantity == MAX_ORDER) System.out.println("the cart is almost full");
        else {
            list[quantity] = disc1;
            list[quantity+1] = disc2;
            quantity += 2;
            
        }
    }

    //Cost
    public void totalCost() {
        float totalCost = 0;
        for (int i = 0; i < quantity; i++) {
            float cost = list[i].getCost();
            totalCost += cost;
        }
        System.out.println("Total cost is: " + totalCost);
    }

    //Print list of oredered items
    public void printList() {
        System.out.println("**************************CART**************************\nOrdered Items:");
        for (int i = 0; i < quantity; i++) {
            System.out.println((i + 1) + ". " + list[i].toString());
        }
        totalCost();
        System.out.println("********************************************************");
    }

    //SearchByID
    public void SearchByID() {
        System.out.println("Please enter the ID of the DVD");
        Scanner scanner = new Scanner(System.in);
        int ID = scanner.nextInt();
        int flag = 0;
        for (int i = 0; i < quantity; i++) {
            if (ID == list[i].getID()) {
                System.out.println(list[i].toString());
                flag = 1;
                break;
            }
        }
        if (flag == 0) System.out.println("No ID is found!");
        scanner.close(); 
    }

    //SearchByTitle
    public void SearchByTitle() {
        System.out.println("Please enter the title of the DVD");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < quantity; i++) {
            if (list[i].isMatch(title)) {
                count++;
                System.out.println(list[i].toString());
            }
        }
        if (count == 0) System.out.println("No title is found");
        scanner.close();
    }


}