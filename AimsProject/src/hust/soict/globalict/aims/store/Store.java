package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.*;

public class Store {
    public static final int MAX = 20;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public int getQuantity() {
        return itemsInStore.size();
    }

    //addMedia
    public void addMedia(Media media) {
        if (itemsInStore.size() == MAX) System.out.println("Cannot add more media to the store");
        else {
            if(!itemsInStore.contains(media)) {
                itemsInStore.add(media);
                System.out.println("Added successfully");
            }
            else System.out.println(media.getTitle() + " is already in your store");
            }
    }

    //RemoveMedia
    public void removeMedia(Media media) {
        if(itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Remove successfully");
        }
        else System.out.println(media.getTitle() + " is not in your store");

    }   

    //Print list of oredered items
    public void printList() {
        System.out.println("**************************STORE**************************\nOrdered Items:");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("********************************************************");
    }

    public Media searchByTitle(String title) {  //separate words
        for (Media media : itemsInStore) {
            if (media.isMatch(title)) {
                System.out.println(media.toString());
                return media;
            }
        }
        return null;
    }

    public Media search(String title) { //the total title
        for (Media media : itemsInStore) {
            if(media.getTitle().equalsIgnoreCase(title)) return media;
        }
        return null;
    }

    public int isMatchTitle(String title) {
        for (Media media : itemsInStore) {
            if(media.getTitle().equalsIgnoreCase(title)) return 1;
        }
        return 0;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

}
