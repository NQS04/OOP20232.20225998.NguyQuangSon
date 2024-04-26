package hust.soict.globalict.aims;
import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.disc.*;

import java.util.ArrayList;

public class Aims {
    public static void main(String[] args) {
        Cart stuff = new Cart();
        
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD("Aladin","Animation", 18.99f);

        stuff.addDVD(dvd1);
        stuff.addDVD(dvd2);
        stuff.addDVD(dvd3);

        for (int i = 0; i < stuff.getQuantity(); i++) {
            System.out.println(stuff.getList()[i].getID() +"\t"+ stuff.getList()[i].getTitle() + "\t" + stuff.getList()[i].getCost());
        }
        stuff.totalCost();
        
        /*
        Section 13 (LAB02)
        stuff.removeDVD(dvd1);
        stuff.addDVD(dvd1);
        for (int i = 0; i < stuff.getQuantity(); i++) {
            System.out.println(stuff.getList()[i].getID() +"\t"+ stuff.getList()[i].getTitle() + "\t" + stuff.getList()[i].getCost());
        }
        System.out.println("\n");
        */

        /*
        Section 14 (LAB02)
        ArrayList<DVD> dvdList = new ArrayList<>();
        dvdList.add(dvd1);
        dvdList.add(dvd2);

        stuff.addDVD(dvd1, dvd2);
        for (int i = 0; i < stuff.getQuantity(); i++) {
            System.out.println(stuff.getList()[i].getID() +"\t"+ stuff.getList()[i].getTitle() + "\t" + stuff.getList()[i].getCost());
        }
        */
        
        stuff.printList();
        stuff.SearchByTitle();
    }
}