package hust.soict.globalict.aims.Aims;
import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.*;
import java.util.Scanner;
public class Aims {

    private static Cart cart = new Cart();
    private static Store store = new Store();

    //Add media to the store
    public static void storeSetup(){
        //DVD
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD("Aladin", "Animation","Guy Ritchie", 89, 18.99f);
        store.addMedia(dvd1); store.addMedia(dvd2); store.addMedia(dvd3); 

        //CD + Track
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 9.99f);
        Track track1 = new Track("Billie Jean", 236); 
        Track track2 = new Track("Beat It", 252);
        Track track3 = new Track("Man in the Mirror", 331);
        cd1.addTrack(track1); cd1.addTrack(track2); cd1.addTrack(track3);
        
        CompactDisc cd2 = new CompactDisc("Kind of Blue", "Jazz", "Miles Davis", 15.50f);
        Track track4 = new Track("So What", 431);  
        Track track5 = new Track("Freddie Freeloader", 539);
        cd2.addTrack(track4); cd2.addTrack(track5); 

        CompactDisc cd3 = new CompactDisc("Bohemian Rhapsody", "Rock", "Queen", 11.99f);
        Track track6 = new Track("Bohemian Rhapsody", 355); 
        Track track7 =  new Track("Killer Queen", 205); 
        Track track8 = new Track("Somebody to Love", 296); 
        cd3.addTrack(track6); cd3.addTrack(track7); cd3.addTrack(track8);
        
        store.addMedia(cd1); store.addMedia(cd2); store.addMedia(cd3);

        //book
        Book book1 = new Book("Hannibal", "Crime Thriller", 8.99f);
        book1.addAuthor("Thomas Harris");
        Book book2 = new Book("Red Dragon", "Crime Thriller", 9.11f);
        book2.addAuthor("Thomas Harris");
        Book book3 = new Book("The Martian", "Science Fiction", 8.97f);
        book3.addAuthor("Andy Weir");
        store.addMedia(book1); store.addMedia(book2); store.addMedia(book3);
    }

    //showMenu
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("AIMS: "); 
            System.out.println("--------------------------------"); 
            System.out.println("1. View store"); 
            System.out.println("2. Update store"); 
            System.out.println("3. See current cart"); 
            System.out.println("0. Exit"); 
            System.out.println("--------------------------------"); 
            System.out.println("Please choose a number: 0-1-2-3");
            
            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    System.out.println("End Task");
                    scanner.close();
                    return;
                case "1":
                    store.printList();
                    storeMenu();
                    break;
                case "2":
                    updateStore();
                    break;
                case "3":
                    cart.printList();
                    cartMenu();
                    break;
                default:
                    break;
            }
        }
    }

    //storeMenu
    public static void storeMenu() { 
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Options: "); 
            System.out.println("--------------------------------"); 
            System.out.println("1. See a media's details"); 
            System.out.println("2. Add a media to cart"); 
            System.out.println("3. Play a media"); 
            System.out.println("4. See current cart"); 
            System.out.println("0. Back"); 
            System.out.println("--------------------------------"); 
            System.out.println("Please choose a number: 0-1-2-3-4"); 

            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    return;
                case "1":
                    while(true) {
                        System.out.println("Pls enter the title of the media to see detail (Press 0 to return)");
                        String title = scanner.nextLine();
                        Media result = store.search(title);
                        if (title.equals("0")) break; //return
                        if (result == null) {
                            System.out.println("Can not find the keywords " + title + " in the store, pls try again!");
                        }
                        else {
                            System.out.println(result.toString());
                            mediaDetailsMenu(result);
                        }
                    }
                    break;
                case "2":
                    while(true) {
                        System.out.println("Pls enter the media's title to add to your cart! (press 0 to return)");
                        String title = scanner.nextLine();
                        Media result = store.search(title);
                        if (title.equals("0")) break; //return
                        if (result == null) {
                            System.out.println("Can not find the keywords " + title + " in the store, pls try again!");
                        }
                        else {
                            cart.addMedia(result);
                            System.out.println("Current number of items in your cart: " + cart.getQuantity());
                        }
                    }
                break;
                case "3":
                    while(true) {
                        System.out.println("Pls enter the media's title to play (press 0 to return)");
                        String title = scanner.nextLine();
                        Media result = store.search(title);
                        if (title.equals("0")) break; //return
                        if (result == null) {
                            System.out.println("Can not find the keywords " + title + " in the store, pls try again!");
                        }
                        else {
                            if (result instanceof DVD || result instanceof CompactDisc) {
                                result.play();
                            }
                            else System.out.println("Cannot be played");
                        }
                    }
                break;
                case "4":
                    cart.printList();
                    cartMenu();
                    break;
                default:
                    break;
            }
        }
    }

    //mediaDetailsMenu
    public static void mediaDetailsMenu(Media media) { 
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Options: "); 
            System.out.println("--------------------------------"); 
            System.out.println("1. Add to cart"); 
            System.out.println("2. Play"); 
            System.out.println("0. Back"); 
            System.out.println("--------------------------------"); 
            System.out.println("Please choose a number: 0-1-2");
            
            String option = scanner.nextLine();
            switch(option) {
                case "0":
                    return;
                case "1":
                    cart.addMedia(media);
                    break;
                case "2":
                    if(media instanceof CompactDisc || media instanceof DVD) {
                        media.play();
                    }
                    else System.out.println("Cannot be played");
                    break;
                default:
                    break;
            }
        }
    }

    //UpdateStore
    public static void updateStore() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    return;
                case "1":
                    boolean back_1 = false;
                    while(!back_1) {
                        System.out.println("Enter the category of the media:");
                        System.out.println("1. DVD");
                        System.out.println("2. CD");
                        System.out.println("3. Book");
                        System.out.println("0. Back");
                        System.out.println("--------------------------------");
                        System.out.println("Please choose a number: 0-1-2-3");

                        String choice = scanner.nextLine();
                        switch (choice) {
                            case "0":
                                back_1 = true;
                                break;
                            case "1":
                                System.out.println("Enter by following order: title - category - director - length - cost");
                                String dvdTitle = scanner.nextLine();
                                String dvdCategory = scanner.nextLine();
                                String dvdDirector = scanner.nextLine();
                                String dvdLength_input = scanner.nextLine();
                                int dvdLength = Integer.parseInt(dvdLength_input);
                                String dvdCost_input = scanner.nextLine();
                                Float dvdCost = Float.parseFloat(dvdCost_input);
                                
                                DVD dvd = new DVD(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);
                                store.addMedia(dvd);
                                break;
                            case "2":
                                System.out.println("Enter by following order: title - category - artist - cost");
                                String cdTitle = scanner.nextLine();
                                String cdCategory = scanner.nextLine();
                                String cdArtist = scanner.nextLine();
                                String cdCost_input = scanner.nextLine();
                                float cdCost = Float.parseFloat(cdCost_input);

                                CompactDisc cd = new CompactDisc(cdTitle, cdCategory, cdArtist, cdCost);
                                store.addMedia(cd);
                                
                                System.out.println("Wanna add tracks?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                String addTrack = scanner.nextLine();
                                if (addTrack == "1") {
                                    System.out.println("How many tracks in your CD?");
                                    String numTrack_input = scanner.nextLine();
                                    int numTrack = Integer.parseInt(numTrack_input);
                                    for (int i = 0; i < numTrack; i++) {
                                        System.out.println("Track number " + (i+1) + ":");
                                        System.out.println("Enter track title: ");
                                        String trackTitle = scanner.nextLine();
                                        System.out.println("Enter track length: ");
                                        String trackLength_input = scanner.nextLine();
                                        int trackLength = Integer.parseInt(trackLength_input);
                                        
                                        Track track = new Track(trackTitle, trackLength);
                                        cd.addTrack(track);
                                    }
                                }
                            break;
                            case "3":
                                System.out.println("Enter by following order: title - category - cost");
                                String bookTitle = scanner.nextLine();
                                String bookCategory = scanner.nextLine();
                                String bookCost_input = scanner.nextLine();
                                float bookCost = Float.parseFloat(bookCost_input);

                                Book book = new Book(bookTitle, bookCategory, bookCost);
                                store.addMedia(book);

                                System.out.println("How many authors of this book: ");
                                String numAuthor_input = scanner.nextLine();
                                int numAuthor = Integer.parseInt(numAuthor_input);
                                for (int i = 0; i < numAuthor; i++) {
                                    System.out.println("Enter the name of " + i + "'s Authors");
                                    String authorName = scanner.nextLine();
                                    book.addAuthor(authorName);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case "2":
                    while(true) {
                        System.out.println("Enter the title of the media: ");
                        String title = scanner.nextLine();
                        Media media = store.search(title);
                        if (media == null) {
                            System.out.println("Error 404 not found");
                            break;
                        }
                        else store.removeMedia(media);
                        break;
                    }
                break;
                default:
                    break;
            }
        }
    }

    //cartMenu
    public static void cartMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");

            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    return;
                case "1":
                    System.out.println("Filter by:\n1. Title\n2. Cost\n");
                    String filterOption = scanner.nextLine();
                    if (filterOption.equals("1")) cart.SearchByTitle();
                    else cart.SearchByID();
                    break;
                case "2":
                    System.out.println("Sort by:\n1. Title\n2. Cost");
                    String sortOption = scanner.nextLine();
                    if (sortOption.equals("1")) cart.sortMediaByTitle();
                    else cart.sortMediaByCost();
                    break;
                case "3":
                    System.out.println("Enter the title of the media to remove: ");
                    String title = scanner.nextLine();
                    Media media = cart.search(title);
                    if (media == null) {
                        System.out.println("Error 404 not found");
                        break;
                    }
                    else cart.removeMedia(media);
                    break;
                case "4":
                    System.out.println("Enter the title of the media to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = cart.search(titlePlay);
                    if (mediaPlay == null) {
                        System.out.println("Error 404 not found");
                        break;
                    }
                    if (mediaPlay instanceof CompactDisc || mediaPlay instanceof DVD) {
                        mediaPlay.play();
                    }
                    else System.out.println("Cannot be played");
                    break;
                case "5":
                    System.out.println("An ordered is created automatically!");
                    cart.empty();
                    return;
                default:
                    break;
            }
        }
    }
    

    public static void main(String[] args) {

        storeSetup();
        showMenu();

    }
}