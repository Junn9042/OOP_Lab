package AimsProject.hust.soict.ict.aims.cart;

import AimsProject.hust.soict.ict.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBER_ORDERS = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBER_ORDERS];
    public int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered == MAX_NUMBER_ORDERS){
            System.out.println("The cart is almost full");
        }
        else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i = 0; i < qtyOrdered; i++){
            if(itemsOrdered[i].equals(disc)){
                System.arraycopy(itemsOrdered, i + 1, itemsOrdered, i,  qtyOrdered - i - 1);
                System.out.println("The disc has been removed");
                qtyOrdered --;
                return;
            }
        }
        System.out.println("No disc found");
    }
    public float totalCost(){
        float totalPrice = 0;
        for(int i = 0; i < qtyOrdered; i++){
            totalPrice += this.itemsOrdered[i].getCost();
        }
        return totalPrice;
    }

    public void print(){
        System.out.println("*****************Cart**************");
        System.out.println("Ordered Items");
        for(int i = 0; i < qtyOrdered; i++){
            System.out.println((i + 1) + "." + this.itemsOrdered[i].toString());
        }
        System.out.printf("Total cost: %.2f ", totalCost());
        System.out.println();
        System.out.println("************************************");
    }

    public void SearchbyTitle(String title){
        int count = 0;
        for(int i = 0; i < qtyOrdered; i++){
            if(this.itemsOrdered[i].isMatch(title)){
                count++;
                System.out.println(this.itemsOrdered[i].toString());
            }
        }
        if(count == 0) System.out.println("No DVDs found");
    }
}