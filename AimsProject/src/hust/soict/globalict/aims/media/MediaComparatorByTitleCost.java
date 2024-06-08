package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        //Compare by title
        int titleCompare = m1.getTitle().compareTo(m2.getTitle());
        if (titleCompare != 0) return titleCompare;
        //Compare by cost
        return Double.compare(m1.getCost(), m2.getCost());
    }
}
