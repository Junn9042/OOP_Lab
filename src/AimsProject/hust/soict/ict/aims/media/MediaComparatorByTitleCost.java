package AimsProject.hust.soict.ict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        if(o1.getTitle().equals(o2.getTitle())){
            return (int)(o1.getCost() - o2.getCost());
        }
        else return o1.getTitle().compareTo(o2.getTitle());

    }
}
