package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextArea taAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store);
        initUI();
    }

    private void initUI() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.setJMenuBar(MenuBarUtil.createMenuBar(frame, store));
        }
    }

    @Override
    protected void addSpecificFields(JPanel panel) {
        panel.add(new JLabel("Enter the name of Authors (Enter for seperating):"));
        taAuthors = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(taAuthors);
        panel.add(scrollPane);
    }

    @Override
    public void addItemToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String[] authors = taAuthors.getText().split("\n");

        Book book = new Book(title, category, cost);
        store.addMedia(book);

        for (int i = 0; i < authors.length; i++) {
            authors[i] = authors[i].trim();
            book.addAuthor(authors[i]);
        }

        JOptionPane.showMessageDialog(this, "Book added to store!");
    }
}
