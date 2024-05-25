package hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import hust.soict.globalict.aims.media.DVD;
import hust.soict.globalict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
    private JTextField tfTitle, tfCategory, tfDirector, tfLength, tfCost;
    private Store store;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add DVD to Store");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Title:"));
        tfTitle = new JTextField();
        add(tfTitle);

        add(new JLabel("Category:"));
        tfCategory = new JTextField();
        add(tfCategory);

        add(new JLabel("Director:"));
        tfDirector = new JTextField();
        add(tfDirector);

        add(new JLabel("Length:"));
        tfLength = new JTextField();
        add(tfLength);

        add(new JLabel("Cost:"));
        tfCost = new JTextField();
        add(tfCost);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());

            DVD dvd = new DVD(title, category, director, length, cost);
            store.addMedia(dvd);

            JOptionPane.showMessageDialog(this, "DVD added to store!");
        });
        add(btnAdd);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            this.dispose();
            new StoreManagerScreen(store).setVisible(true);
        });
        add(btnBack);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
