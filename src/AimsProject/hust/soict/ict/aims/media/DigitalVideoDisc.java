package AimsProject.hust.soict.ict.aims.media;

import java.util.Objects;

public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Week2.DigitalVideoDisc that)) return false;
        return getLength() == that.getLength() && Float.compare(getCost(), that.getCost()) == 0 && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getDirector(), that.getDirector());
    }

    @Override
    public String toString() {
        return "DVD: " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost();
    }



    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}