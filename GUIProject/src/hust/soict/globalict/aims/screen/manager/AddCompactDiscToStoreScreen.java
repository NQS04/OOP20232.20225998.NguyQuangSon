package hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame {
    private JTextField tfTitle, tfCategory, tfCost, tfArtist, tfTracks;
    private Store store;

    public AddCompactDiscToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add CD to Store");
        setSize(400, 400);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Title:"));
        tfTitle = new JTextField();
        add(tfTitle);

        add(new JLabel("Category:"));
        tfCategory = new JTextField();
        add(tfCategory);

        add(new JLabel("Cost:"));
        tfCost = new JTextField();
        add(tfCost);

        add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        add(tfArtist);

        add(new JLabel("Tracks (comma separated):"));
        tfTracks = new JTextField();
        add(tfTracks);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String artist = tfArtist.getText();
            String[] tracks = tfTracks.getText().split(",");

            CompactDisc cd = new CompactDisc(title, category, artist, cost);
            for (String trackName : tracks) {
                cd.addTrack(new Track(trackName.trim(), 0));  // Duration is not provided here, you may need to extend this part
            }
            store.addMedia(cd);

            JOptionPane.showMessageDialog(this, "CD added to store!");
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
