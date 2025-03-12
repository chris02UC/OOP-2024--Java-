package SoalKaryna;

public class Song {
    private String title, artist, duration;
    private int release_year;

    public Song(String title, String artist, String duration, int releaseyear){
    this.title = title;
    this.artist = artist;
    this.release_year = releaseyear;
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

    public int getreleaseyear(){
        return this.release_year;
    }
    public void setreleaseyear(int a){
        this.release_year = a;
    }

    public String getduration(){
        return this.duration;
    }
    public void setduration(String a){
        this.duration = a;
    }
    
}
