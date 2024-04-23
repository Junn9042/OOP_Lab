package AimsProject.hust.soict.ict.aims.cart;

import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBER_ORDERS = 20;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media){
        if(!itemsOrdered.contains(media)){
            itemsOrdered.add(media);
        }
        else {
            System.out.println("The item is already in the ordered list");
        }
    }

    public void removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
        }
        else {
            System.out.println("The item is not in the ordered list");
        }
    }
    public float totalCost(){
        float totalPrice = 0;
        for(int i = 0; i < itemsOrdered.size(); i++){
            totalPrice += this.itemsOrdered.get(i).getCost();
        }
        return totalPrice;
    }

    public void print(){
        System.out.println("*****************Cart**************");
        System.out.println("Ordered Items");
        for(int i = 0; i < itemsOrdered.size(); i++){
            System.out.println((i + 1) + "." + this.itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f ", totalCost());
        System.out.println();
        System.out.println("************************************");
    }

    public void SearchbyTitle(String title){
        int count = 0;
        for(int i = 0; i < itemsOrdered.size(); i++){
            if(this.itemsOrdered.get(i).isMatch(title)){
                count++;
                System.out.println(this.itemsOrdered.get(i).toString());
            }
        }
        if(count == 0) System.out.println("No DVDs found");
    }
}