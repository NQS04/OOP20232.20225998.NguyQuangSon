package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.*;

public class CompactDisc extends Disc implements Playable {

    //FieldS
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    public List<Track> getTracks() {
        return tracks;
    }

    //Getter
    public String getArtist() {
        return artist;
    }
    public int getLength() {
        int sum = 0;
        for (Track track : tracks) {
            sum += track.getLength();
        }
        return sum;
    }

    //Constructor
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if(!tracks.contains(track)) tracks.add(track);
        else System.out.println("The track " + track.getTitle() + " is already in the list of tracks");
    }

    public void removeTrack(Track track) {
        if(tracks.contains(track)) tracks.remove(track);
        else System.out.println("The track " + track.getTitle() + " is not in the list of tracks");
    }

    public String toString() {
        return super.getID() + "- " + "CD - " + super.getTitle() + " - " + super.getCategory() + " - " + this.getArtist() + " : " + super.getCost() + " $";
    }

    @Override
    public void play() throws PlayerException{
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());
            for (Track track : tracks) {
                track.play();
            }
        }
        else {
            throw new PlayerException("No tracks played");
        }
    }

    @Override
    public String playMedia() {
        String playCD = "Playing CD: " + this.getTitle() + "\nCD length: " + this.getLength();
        playCD = playCD + "\nTracks: ";
        for (Track track : tracks) {
            playCD = playCD + "\n+ " + track.playMedia();
        }
        return playCD;
    }
} 
