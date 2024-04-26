package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.*;

public class Store {
    public static final int MAX = 20;
    DVD[] itemsInStore = new DVD[20];
    private static int quantity = 0;

    public int getQuantity() {
        return quantity;
    }

    //addDVD
    public void addDVD(DVD disc) {
        if (quantity == MAX) System.out.println("Cannot add more DVD to the store");
        else {
            itemsInStore[quantity] = disc;
            quantity++;
            System.out.println("The disc "+ disc.getTitle() +" has been added to store");
        }
    }

    //RemoveDVD
    public void removeDVD(DVD disc) {
        for (int i = 0; i < quantity;i++) {
            if (disc.equals(itemsInStore[i])) {
                for (int j = i; j < quantity - 1; j++) itemsInStore[j] = itemsInStore[j+1];
                quantity--;
                System.out.println("Remove "+  disc.getTitle() +" successfully");
                break;
            }
        }
    }   

}
