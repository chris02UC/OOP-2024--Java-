package spotmufy;

public class Music {
    private int duration, releaseyear;
    private String artist, title, albumname;

    public Music(String artist, String title, String albumname, int duration, int releaseyear){
    this.artist = artist;
    this.title = title;
    this.albumname = albumname;
    this.duration = duration;
    this.releaseyear = releaseyear;
    }

    public int getduration(){
        return duration;
    }
    public void setduration(int dur){
        this.duration = dur;
    }

    public int getreleaseyear(){
        return releaseyear;
    }
    public void setreleaseyear(int ry){
        this.releaseyear = ry;
    }

    public String getartist(){
        return artist;
    }
    public void setartist(String ar){
        this.artist = ar;
    }

    public String gettitle(){
        return title;
    }
    public void settitle(String ar){
        this.title = ar;
    }

    public String getalbumname(){
        return albumname;
    }
    public void setalbumname(String ar){
        this.albumname = ar;
    }
}
