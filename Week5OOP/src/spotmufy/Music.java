package spotmufy;

public class Music {
    private String title, artist, album;
    private int release_year;
    private int number_played = 0;
    public long duration;

    public Music(String title, String artist, String album, int releaseyear, int numplayed, long duration){
    this.title = title;
    this.artist = artist;
    this.album = album;
    this.release_year = releaseyear;
    this.number_played = numplayed;
    this.duration = duration;
    }

    public String gettitle(){
        return this.title;
    }
    public void settitle(String a){
        this.title = a;
    }
    public String getartist(){
        return this.artist;
    }
    public void setartist(String a){
        this.artist = a;
    }
    public String getalbum(){
        return this.album;
    }
    public void setalbum(String a){
        this.album = a;
    }
    public int getreleaseyear(){
        return this.release_year;
    }
    public void setreleaseyear(int a){
        this.release_year = a;
    }
    public int getnumplayed(){
        return this.number_played;
    }
    public void setnumberplayed(){
        this.number_played += 1;
    }
    public long getduration(){
        return this.duration;
    }
    public void setduration(long a){
        this.duration = a;
    }
    
}
