package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.*;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD("Aladin","Animation", 18.99f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
    }
}
