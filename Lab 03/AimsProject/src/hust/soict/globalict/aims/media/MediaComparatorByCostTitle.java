package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        //Compare by cost
        int costCompare = Double.compare(m1.getCost(), m2.getCost());
        if (costCompare != 0) return costCompare;
        //Compare by title
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
