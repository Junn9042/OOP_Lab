package AimsProject.hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
        }
        else{
            System.out.println("The author is already in the author list");
        }
    }

    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
        }
        else{
            System.out.println("The author is not in the author list");
        }
    }
}
