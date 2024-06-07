package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName) {
        if(!authors.contains(authorName)) authors.add(authorName);
        else System.out.println("Author: " + authorName + " is already in the author_list of " + super.getTitle());
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) authors.remove(authorName);
        else System.out.println("Author: " + authorName + " is not in the author_list of " + super.getTitle());
    }

    public String toString() {
        return super.getID() + "- " + "Book - " + super.getTitle() + " - " + super.getCategory() + " : " + super.getCost() + " $";
    }
    //Reference
}
