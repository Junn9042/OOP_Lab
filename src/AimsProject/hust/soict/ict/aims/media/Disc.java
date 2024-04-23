package AimsProject.hust.soict.ict.aims.media;

public class Disc extends Media{
    private int length;
    private String director;

    public Disc() {

    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.length = length;
        this.setCost(cost);
    }
    public Disc(String title) {
        this.setTitle(title);
    }

    public Disc(String title, String category, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public Disc(String title, String category, String director, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.setCost(cost);
    }
}
