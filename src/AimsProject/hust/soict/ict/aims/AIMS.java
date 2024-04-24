package AimsProject.hust.soict.ict.aims;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Media;
import AimsProject.hust.soict.ict.aims.store.Store;

import java.util.List;
import java.util.Scanner;

public class AIMS {
    public static Cart order = new Cart();
    public static List<Media> itemsinOrdered = order.getItemsOrdered();
    public static Store store = new Store();
    public static List<Media> itemsInstore = store.getItemsInStore();

    public static Scanner input = new Scanner(System.in);

    public static void showMenu(){
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void cartOption(){
        int choice;
        do {
            cartMenu();
            System.out.println("Your choice is: ");
            choice = input.nextInt();
        }
        while(choice > 5 || choice < 0);
        switch (choice){
            case 1: {
                System.out.println("Choosing option: ");
                System.out.println("1: Filter by id");
                System.out.println("2: Filter by title");
                int number = input.nextInt();
                if(number == 1){
                    System.out.println();
                }
                choosingOption();
                break;
            }
            case 2: {
                System.out.println("Choosing option: ");
                System.out.println("1: Sort by title");
                System.out.println("2: Sort by cost");
                int number = input.nextInt();
                if(number == 1){
                    itemsinOrdered.sort(Media.COMPARE_BY_TITLE_COST);
                    order.print();
                }
                else if(number == 2){
                    itemsinOrdered.sort(Media.COMPARE_BY_COST_TITLE);
                    order.print();
                }
                else {
                    System.out.println("Valid selection");
                }
                choosingOption();
                break;
            }
            case 3: {
                order.print();
                System.out.println("Enter the media title you want to remove: ");
                input.nextLine();
                String title = input.nextLine();
                for(int i = 0; i < itemsinOrdered.size(); i++){
                    if(itemsinOrdered.get(i).isMatch(title)){
                        Media chosenMedia = itemsinOrdered.get(i);
                        order.removeMedia(chosenMedia);
                        System.out.println("Your chosen item has been remove");
                        break;
                    }
                }
                order.print();
                choosingOption();
            }

            case 4: {
                boolean checkedError = true;
                boolean found = false;
                order.print();
                System.out.print("Enter the media title: ");
                input.nextLine();
                String title = input.nextLine();
                for(int i = 0; i < itemsinOrdered.size(); i++){
                    if(itemsinOrdered.get(i).isMatch(title)){
                        found = true;
                        try {
                            CompactDisc chosenDVD = (CompactDisc) itemsinOrdered.get(i);
                            chosenDVD.play();
                            checkedError = false;
                        }
                        catch (Exception e){
                            checkedError = true;
                        }
                        try {
                            DigitalVideoDisc chosenDVD = (DigitalVideoDisc) itemsinOrdered.get(i);
                            chosenDVD.play();
                            checkedError = false;
                        }
                        catch (Exception e){
                            checkedError = true;
                        }
                    }
                }
                if(found){
                    if(checkedError){
                        System.out.println("The media title is not CD or DVD");
                    }
                }
                else System.out.println("No valid title");
                choosingOption();
                break;
            }
            case 5: {
                System.out.println("An order is created. Please check your email to confirm the order");
                order.print();
                itemsinOrdered.clear();
            }
            case 0: {
                break;
            }
        }
    }
    public static void detailOption(Media chosenMedia){
        int choice;
        do {
            mediaDetailsMenu();
            System.out.print("Your choice is: ");
            choice = input.nextInt();
        }
        while(choice > 2 || choice < 0);
        switch (choice){
            case 1: {
                order.addMedia(chosenMedia);
                choosingOption();
                break;
            }
            case 2: {
                boolean checkedError = true;
                try {
                    CompactDisc chosenDVD = (CompactDisc) chosenMedia;
                    chosenDVD.play();
                    checkedError = false;
                }
                catch (Exception e){
                    checkedError = true;
                }
                try {
                    DigitalVideoDisc chosenDVD = (DigitalVideoDisc) chosenMedia;
                    chosenDVD.play();
                    checkedError = false;
                }
                catch (Exception e){
                    checkedError = true;
                }
                if (checkedError){
                    System.out.println("The chosen media is not a CD or DVD");
                    choosingOption();
                    break;
                }
                else{
                    choosingOption();
                }
                break;
            }
            case 0: {
                choosingOption();
            }
        }
    }
    public static void choosingOption(){
        int choice;
        do {
            storeMenu();
            System.out.print("Your choice is: ");
            choice = input.nextInt();
        }
        while(choice > 4 || choice < 0);
        switch (choice){
            case 1: {
                store.print();
                System.out.print("Enter the media title: ");
                input.nextLine();
                String title = input.nextLine();
                System.out.println(title);
                for(int i = 0; i < itemsInstore.size(); i++) {
                    if (itemsInstore.get(i).isMatch(title)) {
                        Media chosenMedia = itemsInstore.get(i);
                        detailOption(chosenMedia);
                    }
                }
                break;
            }
            case 2: {
                store.print();
                System.out.print("Enter the media title: ");
                input.nextLine();
                String title = input.nextLine();
                for(int i = 0; i < itemsInstore.size(); i++){
                    if(itemsInstore.get(i).isMatch(title)){
                        Media chosenMedia = itemsInstore.get(i);
                        order.addMedia(chosenMedia);
                        break;
                    }
                }
                order.print();
                choosingOption();
                break;
            }
            case 3: {
                boolean checkedError = true;
                boolean found = false;
                store.print();
                System.out.print("Enter the media title: ");
                input.nextLine();
                String title = input.nextLine();
                for(int i = 0; i < itemsInstore.size(); i++){
                    if(itemsInstore.get(i).isMatch(title)){
                        found = true;
                        try {
                            CompactDisc chosenDVD = (CompactDisc) itemsInstore.get(i);
                            chosenDVD.play();
                            checkedError = false;
                        }
                        catch (Exception e){
                            checkedError = true;
                        }
                        try {
                            DigitalVideoDisc chosenDVD = (DigitalVideoDisc) itemsInstore.get(i);
                            chosenDVD.play();
                            checkedError = false;
                        }
                        catch (Exception e){
                            checkedError = true;
                        }
                    }
                }
                if(found){
                    if(checkedError){
                        System.out.println("The media title is not CD or DVD");
                    }
                }
                else System.out.println("No valid title");
                break;
            }
            case 4:
                order.print();
                cartOption();
                
        }
    }
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        store.addMedia((Media) dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star War", "Science Fiction", 24.95f, 87, "Geoger Lucas");
        store.addMedia((Media) dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
        store.addMedia((Media) dvd3);
        Book book1 = new Book(1, "Book 1", "Category 1", 40.26f);
        store.addMedia((Media) book1);
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            System.out.print("Your choice is: ");
            choice = input.nextInt();
        }
        while(choice > 3 || choice < 0);

        switch (choice){
            case 1: {
                choosingOption();
                break;
            }
            case 2: ;
            case 3: {
                order.print();
                cartOption();
                break;
            }
            case 0: break;
        }
    }
}

