package hust.soict.globalict.aims.screen.manager;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.screen.*;
import hust.soict.globalict.aims.cart.*;

public class StoreManagerScreen extends JFrame {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    /* 
    // Add media to the store
    public static void storeSetup() {
        // DVD
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD("Aladin", "Animation", "Guy Ritchie", 89, 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // CD + Track
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 9.99f);
        Track track1 = new Track("Billie Jean", 236);
        Track track2 = new Track("Beat It", 252);
        Track track3 = new Track("Man in the Mirror", 331);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd1.addTrack(track3);

        CompactDisc cd2 = new CompactDisc("Kind of Blue", "Jazz", "Miles Davis", 15.50f);
        Track track4 = new Track("So What", 431);
        Track track5 = new Track("Freddie Freeloader", 539);
        cd2.addTrack(track4);
        cd2.addTrack(track5);

        CompactDisc cd3 = new CompactDisc("Bohemian Rhapsody", "Rock", "Queen", 11.99f);
        Track track6 = new Track("Bohemian Rhapsody", 355);
        Track track7 = new Track("Killer Queen", 205);
        Track track8 = new Track("Somebody to Love", 296);
        cd3.addTrack(track6);
        cd3.addTrack(track7);
        cd3.addTrack(track8);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);

        // Book
        Book book1 = new Book("Hannibal", "Crime Thriller", 8.99f);
        book1.addAuthor("Thomas Harris");
        Book book2 = new Book("Red Dragon", "Crime Thriller", 9.11f);
        book2.addAuthor("Thomas Harris");
        Book book3 = new Book("The Martian", "Science Fiction", 8.97f);
        book3.addAuthor("Andy Weir");
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
    }
    */

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            this.dispose();
            new StoreManagerScreen(store).setVisible(true);
        });
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store).setVisible(true);
        });
        smUpdateStore.add(addBook);

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store).setVisible(true);
        });
        smUpdateStore.add(addCD);

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store).setVisible(true);
        });
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemInStore();
        for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        //storeSetup();
        new StoreManagerScreen(store);
    }
}
