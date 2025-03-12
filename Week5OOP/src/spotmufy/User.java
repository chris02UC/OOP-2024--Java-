package spotmufy;
import java.util.ArrayList;

public class User {
    private String name, password;
    private Long total_listen = 0L;
    private Music chosenmusic;
    private ArrayList<Playlist>myplaylists = new ArrayList<Playlist>();
    
    public String getUsername(){
        return this.name;
    }
    public void setUsername(String n){
        this.name = n;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword (String pwd){
        this.password = pwd;
    }
    public Long gettotal_listen(){
        return this.total_listen;
    }
    public void settotal_listen(long a){
        this.total_listen += a;
    }
    public void intialtl(){
        this.total_listen = 0L;
    }
    public void addPlaylist (Playlist p){
        myplaylists.add(p);
    }
    public void removePlaylist (Playlist p){
        myplaylists.remove(p);
    }
    public Playlist getPlaylist (int index){
        return this.myplaylists.get(index);
    }
    public ArrayList<Playlist> getAllPlaylists(){
        return this.myplaylists;
    }
    public void setchosenmusic(Music m){
        this.chosenmusic = m;
    }
    public Music getchosenmusic(){
        return chosenmusic;
    }
}
