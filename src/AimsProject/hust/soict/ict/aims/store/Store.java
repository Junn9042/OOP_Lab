package AimsProject.hust.soict.ict.aims.store;

import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media){
        if(!itemsInStore.contains(media)){
            itemsInStore.add(media);
            System.out.println("The media has been added");
        }
        else System.out.println("The media is already in the store");
    }

    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            itemsInStore.remove(media);
            System.out.println("The media has been removed");
        }
        else System.out.println("No disc found");
    }

}
