package hust.soict.globalict.aims.media;


import hust.soict.globalict.aims.exception.PlayerException;

public class DVD extends Disc implements Playable {

    //Constructor method

    public DVD(String title) {
        super(title);
    }    

    public DVD(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DVD(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public String toString() {
        return super.getID() + "- " + "DVD - " + super.getTitle() + " - " + super.getCategory() + " - " + super.getDirector() + " - " + super.getLength() + " : " + super.getCost() + " $";
    }
    
    
    public boolean isMatch(String title) {
        String[] DVD_words = super.getTitle().split("\\s+");
        String[] title_words = title.split("\\s+");
        for (String title_word : title_words) {
            for (String DVD_word : DVD_words) {
                if (DVD_word.equalsIgnoreCase(title_word)) return true;
            }
        }
        return false;
    } 

    @Override
    public void play() throws PlayerException {
        if (super.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
        else {
            throw new PlayerException("DVD playing failed");
        }
    }

    @Override
    public String playMedia() {
        String playDVD = "Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength();
        return playDVD;
    }
}