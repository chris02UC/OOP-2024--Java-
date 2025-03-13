package SoalKaryna;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private String name, description;
    private LinkedList<Song> musicList = new LinkedList<Song>();

    public String getPName(){
        return this.name;
    }
    public void setPName(String a){
        this.name = a;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void addMusic (Song m){
        musicList.add(m);
    }
    public void removeMusic (Song m){
        musicList.remove(m);
    }
    public Song getMusic(int a){
        return musicList.get(a);
    }
    public LinkedList<Song> getAllMusic(){
        return musicList;
    }
}
