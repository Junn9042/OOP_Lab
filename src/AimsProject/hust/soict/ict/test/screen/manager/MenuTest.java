package AimsProject.hust.soict.ict.test.screen.manager;

import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.screen.manager.StoreManagerScreen;
import AimsProject.hust.soict.ict.aims.store.Store;

public class MenuTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star War", "Science Fiction", 24.95f, 87, "Geoger Lucas");
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);
        new StoreManagerScreen(store);
    }
}
