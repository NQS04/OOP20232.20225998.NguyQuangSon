package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.DVD;
import hust.soict.globalict.aims.store.Store;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector, tfLength;

    public AddDVDToStoreScreen(Store store) {
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
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Enter the director:"));
        tfDirector = new JTextField();
        panel.add(tfDirector);

        panel.add(new JLabel("Enter the length:"));
        tfLength = new JTextField();
        panel.add(tfLength);
    }

    @Override
    public void addItemToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());

        DVD dvd = new DVD(title, category, director, length, cost);
        store.addMedia(dvd);

        JOptionPane.showMessageDialog(this, "DVD added to store!");
    }
}
