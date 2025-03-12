package spotmufy;
import java.util.ArrayList;

public class User {
    private String username, password;
    private int listdur = 0;
    private ArrayList<Playlist>playlist = new ArrayList<Playlist>();
    private ArrayList<Integer>playspersong = new ArrayList<Integer>();
    private int firstpps = 0;

    public void setusername(String a){
        this.username = a;
    }
    public String getusername(){
        return this.username;
    }
    public void setpassword(String a){
        this.password = a;
    }
    public String getpassword(){
        return this.password;
    }
    public void setlistdur(int a){
    listdur += a;
    }
    public int getlistdur(){
        return listdur;
    }

    public ArrayList<Integer> getpps(){
        return this.playspersong;
    }
    public void setppsdetail(int a, int plays){
        playspersong.set(a, plays);
    }
    public void setpps(int plays){
        playspersong.add(plays);
    }

    public int getfirstpps(){
        return this.firstpps;
    }
    public void setfirstpps(){
    this.firstpps = 1;
    }

    public ArrayList<Playlist> getplaylist(){
        return this.playlist;
    }
    public void setplaylist(Playlist p){
        this.playlist.add(p);
    }
}
