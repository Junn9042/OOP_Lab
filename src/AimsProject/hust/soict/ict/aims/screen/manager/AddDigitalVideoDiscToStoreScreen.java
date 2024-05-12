package AimsProject.hust.soict.ict.aims.screen.manager;

import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField lengthField;
    private JTextField directorField;
    private JButton addButton;
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);

        JLabel lengthLabel = new JLabel("Length:");
        lengthField = new JTextField(20);

        JLabel directorLabel = new JLabel("Director:");
        directorField = new JTextField(20);

        addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToStore();
            }
        });

        center.add(lengthLabel);
        center.add(lengthField);
        center.add(directorLabel);
        center.add(directorField);
        center.add(addButton);

    }

    @Override
    protected void addItemToStore() {
        int id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        int length = Integer.parseInt(lengthField.getText());
        String director = directorField.getText();

        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, length, director);
        store.addMedia(dvd);


    }
    public static void main(String[] args) {
        Store store = new Store();
        AddDigitalVideoDiscToStoreScreen addDVDScreen = new AddDigitalVideoDiscToStoreScreen(store);
        addDVDScreen.setVisible(true);
    }
}