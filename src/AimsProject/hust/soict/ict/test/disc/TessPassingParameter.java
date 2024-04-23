package AimsProject.hust.soict.ict.test.disc;

import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TessPassingParameter {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        Book book1 = new Book(1, "Title 1", "Category 1", 70, Collections.singletonList("Author 1"));

        mediae.add((Media) book1);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");

        mediae.add((Media) dvd1);

        CompactDisc cd1 = new CompactDisc(3, "Title 1", "Category 1", 19.88f, 70, "Director 1", "Artist 1");

        mediae.add((Media) cd1);

        for(Media m : mediae){
            System.out.println(m.toString());
        }
    }
}
