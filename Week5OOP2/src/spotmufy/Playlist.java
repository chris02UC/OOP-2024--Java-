package spotmufy;
import java.util.ArrayList;

public class Playlist {
    private ArrayList<Music>mplaylist = new ArrayList<Music>();
    private String plname;

    public ArrayList<Music> getmusicinplaylist(){
        return mplaylist;
    }
    public void addmusicinplaylist(Music m){
        mplaylist.add(m);
    }
    public void setplname(String a){
     this.plname = a;
    }
    public String getplname(){
        return plname;
    }

}
