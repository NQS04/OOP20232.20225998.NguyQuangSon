package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.media.*;

import javax.naming.LimitExceededException;

public class CartTest {
    public static void main(String[] args) {
        //Create a new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD("Aladin","Animation", 18.99f);

        try {
            cart.addMedia(dvd1);
        } catch (LimitExceededException e) {
        }
        try {
            cart.addMedia(dvd2);
        } catch (LimitExceededException e) {
        }
        try {
            cart.addMedia(dvd3);
        } catch (LimitExceededException e) {
        }


        cart.printList();
        
    }
}
