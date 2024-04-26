package hust.soict.globalict.aims.disc;

public class DVD {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDVD = 0;
    private int id;
    // Getters method
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
    public int getID() {
        return id;
    }

    //Constructor method

    public DVD(String title) {
        this.title = title;
        DVD.nbDVD++;
        this.id = nbDVD;
    }    
    public DVD(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        DVD.nbDVD++;
        this.id = nbDVD;
    }
    public DVD(String director,String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        DVD.nbDVD++;
        this.id = nbDVD;
    }
    public DVD(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        DVD.nbDVD++;
        this.id = nbDVD;
    }
    //Setter
    public void setTitle(String title) {
        this.title = title;
    }
    

    
}
