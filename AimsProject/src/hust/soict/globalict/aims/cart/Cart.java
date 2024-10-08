package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.*;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;


public class Cart {
    public static final int MAX = 20;
    private ObservableList<Media> itemOrdered = FXCollections.observableArrayList();

    //addMedia
    public void addMedia(Media media) throws LimitExceededException {
        if (itemOrdered.size() >= MAX) {
            throw new LimitExceededException("Your cart is full");
        }
        if(!itemOrdered.contains(media)) {
            itemOrdered.add(media);
            System.out.println("Added successfully");
        }
        else System.out.println(media.getTitle() + " is already in your cart");
    }

    //removeMedia
    public void removeMedia(Media media) {
        if(itemOrdered.contains(media)) {
            itemOrdered.remove(media);
            System.out.println("Removed successfully");
        }
        else System.out.println(media.getTitle() + " is not in your cart");
    }
 

    //Cost
    public void totalCost() {
        float totalCost = 0;
        for (Media media : itemOrdered) {
            totalCost += media.getCost();
        }
        System.out.println("Total cost is: " + totalCost + " $");
    }

    //Print list of oredered items
    public void printList() {
        System.out.println("**************************CART**************************\nOrdered Items:");
        for (Media media : itemOrdered) {
            System.out.println(media.getID() + ". " + media.getTitle() + " - " + media.getCategory() + " : " + media.getCost() + " $");
        }
        this.totalCost();
        System.out.println("********************************************************");
    }

    //SearchByID
    public void SearchByID() {
        System.out.println("Please enter the ID of the media");
        Scanner scanner = new Scanner(System.in);
        int ID = scanner.nextInt();
        int flag = 0;
        for (Media media : itemOrdered) {
            if (ID == media.getID()) {
                System.out.println(media.toString());
                flag = 1;
                break;
            }
        }
        if (flag == 0) System.out.println("No ID is found!");
    }

    //SearchByTitle
    public void SearchByTitle() {
        System.out.println("Please enter the title of the media");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        int count = 0;
        for (Media media : itemOrdered) {
            if (media.isMatch(title)) {
                count++;
                System.out.println(media.toString());
            }
        }
        if (count == 0) System.out.println("No title is found");
    }

    //PrintQuantity
    public int getQuantity() {
        return itemOrdered.size();
    }

    //sort the media in the cart
    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemOrdered, Media.COMPARE_BY_COST_TITLE);
        for(Media m:itemOrdered){
            System.out.println(m.toString());
        }
    }

    //Search
    public Media search(String title) {
        for (Media media : itemOrdered) {
            if(media.getTitle().equalsIgnoreCase(title)) return media;
        }
        return null;
    }

    //empty the cart
    public void empty() {
        itemOrdered.clear();
    }

    public ObservableList<Media> getItemOrdered() {
        return itemOrdered;
    }

    public float getTotalCost() {
        float total = 0f;
        for (Media media : itemOrdered) {
            total += media.getCost();
        }
        return total;
    }
}