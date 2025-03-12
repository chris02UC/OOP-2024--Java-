package spotmufy;
import java.util.ArrayList;

public class Playlist {
    private String name;
    private long total_Duration;
    private ArrayList<Music> musicList = new ArrayList<Music>();

    public String getPName(){
        return this.name;
    }
    public void setPName(String a){
        this.name = a;
    }
    public long gettotalduration(){
        return this.total_Duration;
    }
    public void initialtd(){
        this.total_Duration = 0;
    }
    public void settotalduration(long a){
        this.total_Duration += a;
    }
    public void addMusic (Music m){
        musicList.add(m);
    }
    public void removeMusic (Music m){
        musicList.remove(m);
    }
    public Music getMusic(int a){
        return musicList.get(a);
    }
    public ArrayList<Music> getAllMusic(){
        return musicList;
    }
}
