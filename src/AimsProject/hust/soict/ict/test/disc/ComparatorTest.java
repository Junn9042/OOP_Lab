package AimsProject.hust.soict.ict.test.disc;

import AimsProject.hust.soict.ict.aims.media.Media;
import AimsProject.hust.soict.ict.aims.media.MediaComparatorByCostTitle;
import AimsProject.hust.soict.ict.aims.media.MediaComparatorByTitleCost;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        Media media1 = new Media(1, "Title 1", "Category 1", 20.00f);
        Media media2 = new Media(2, "Title 1", "Category 2", 30.00f);
        Media media3 = new Media(3, "Title 2", "Category 3", 30.00f);

        List<Media> media = new ArrayList<Media>();
        media.add(media3);
        media.add(media1);
        media.add(media2);
        Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

        Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
        for(Media m: media){
            System.out.println(m.toString());
        }

        media.sort(COMPARE_BY_COST_TITLE);
        for(Media m: media){
            System.out.println(m.toString());
        }



    }
}
