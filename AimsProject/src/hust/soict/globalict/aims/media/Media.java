package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;
    private int id;
    // Getters method
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }
    public int getID() {
        return id;
    }

    //Constructor method

    public Media(String title) {
        this.title = title;
        Media.nbMedia++;
        this.id = nbMedia;
    }    
    public Media(String title, String category, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        Media.nbMedia++;
        id = nbMedia;
    }

    //Setter
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    
    //
    public String toString() {
        return id + " - " + "Media - " + title + " - " + category + " : " + cost + " $";
    }
    
    public boolean isMatch(String title) {
        String[] Media_words = this.title.split("\\s+");
        String[] title_words = title.split("\\s+");
        for (String title_word : title_words) {
            for (String Media_word : Media_words) {
                if (Media_word.equalsIgnoreCase(title_word)) return true;
            }
        }
        return false;
    } 

    public void play() throws PlayerException {
        System.out.println("Playing media");
    }

    public String playMedia() {
        String playMedia = "Playing media";
        return playMedia;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Media)) return false;
        return ((Media)o).getTitle() == this.title;
    }

    //Comparator attributes
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    @Override
    public int compareTo(Media m) {
        if (m == null) {
            throw new NullPointerException("The provided media is null");
        }
        int titleCompare = this.getTitle().compareTo(m.getTitle());
        if (titleCompare != 0) return titleCompare;
        return Double.compare(this.getCost(), m.getCost());
    }
}
