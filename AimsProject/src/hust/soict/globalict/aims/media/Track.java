package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    //Getter methods
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
        else {
            throw new PlayerException("Track is empty");
        }
    }

    @Override
    public String playMedia() {
        String playTrack = "Playing track: " + this.getTitle() + "\nTrack length: " + this.getLength();
        return playTrack;
    }

}
