package AimsProject.hust.soict.ict.aims.store;

import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;

public class Store {
    int qtyDVDs = 0;
    int MAX_NUMBER_DVDS = 1000;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBER_DVDS];

    public void addDVD(DigitalVideoDisc disc){
        itemsInStore[qtyDVDs] = disc;
        qtyDVDs++;
        System.out.println("The disc has been added");
    }

    public void removeDVD(DigitalVideoDisc disc){
        for(int i = 0; i < qtyDVDs; i++){
            if(itemsInStore[i].equals(disc)){
                System.arraycopy(itemsInStore, i + 1, itemsInStore, i,  qtyDVDs - i - 1);
                System.out.println("The disc has been removed");
                qtyDVDs--;
                return;
            }
        }
        System.out.println("No disc found");
    }

}
