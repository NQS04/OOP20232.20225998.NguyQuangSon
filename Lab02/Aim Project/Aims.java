public class Aims {
    public static void main(String[] args) {
        Cart stuff = new Cart();
        
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD("Aladin","Animation", 18.99f);

        stuff.addDVD(dvd1);
        stuff.addDVD(dvd2);
        stuff.addDVD(dvd3);

        stuff.totalCost();
    }
}