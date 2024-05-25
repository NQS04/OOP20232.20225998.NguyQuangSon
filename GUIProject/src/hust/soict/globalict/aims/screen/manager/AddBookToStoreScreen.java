package hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends JFrame {
    private JTextField tfTitle, tfCategory, tfCost, tfAuthor;
    private Store store;

    public AddBookToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add Book to Store");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Title:"));
        tfTitle = new JTextField();
        add(tfTitle);

        add(new JLabel("Category:"));
        tfCategory = new JTextField();
        add(tfCategory);

        add(new JLabel("Cost:"));
        tfCost = new JTextField();
        add(tfCost);

        add(new JLabel("Author:"));
        tfAuthor = new JTextField();
        add(tfAuthor);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String author = tfAuthor.getText();

            Book book = new Book(title, category, cost);
            book.addAuthor(author);
            store.addMedia(book);

            JOptionPane.showMessageDialog(this, "Book added to store!");
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
