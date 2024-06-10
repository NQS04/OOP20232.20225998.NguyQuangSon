package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

import java.util.*;
import java.util.List;
import javax.swing.*;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist, tfTrackTitle, tfTrackLength;
    private List<Track> tracks;
    private JButton btnAddTrack;
    private JTextArea trackTextArea;
    
    public AddCDToStoreScreen(Store store) {
        super(store);
        tracks = new ArrayList<>();
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
        panel.add(new JLabel("Enter the name of Artist:"));
        tfArtist = new JTextField();
        panel.add(tfArtist);

        panel.add(new JLabel("Track Title:"));
        tfTrackTitle = new JTextField();
        panel.add(tfTrackTitle);

        panel.add(new JLabel("Track Length:"));
        tfTrackLength = new JTextField();
        panel.add(tfTrackLength);

        btnAddTrack = new JButton("Add Track");
        btnAddTrack.addActionListener(e -> addTrack());
        panel.add(btnAddTrack);

        trackTextArea = new JTextArea(10, 20);
        trackTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(trackTextArea);
        panel.add(scrollPane);
    }

    private void addTrack() {
        String trackTitle = tfTrackTitle.getText();
        int trackLength = Integer.parseInt(tfTrackLength.getText());

        Track track = new Track(trackTitle, trackLength);
        tracks.add(track);

        trackTextArea.append("> " + trackTitle + " (" + trackLength + " s)\n");

        tfTrackTitle.setText("");
        tfTrackLength.setText("");
    }

    @Override
    public void addItemToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String artist = tfArtist.getText();

        CompactDisc cd = new CompactDisc(title, category, artist, cost);
        store.addMedia(cd);

        for (Track track : tracks) {
            cd.addTrack(track);
        }

        JOptionPane.showMessageDialog(this, "CD added to store!");
    }
}
