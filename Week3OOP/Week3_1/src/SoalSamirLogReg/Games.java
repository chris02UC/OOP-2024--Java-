package SoalSamirLogReg;

public class Games {
    private String name;
    private String developer;
    private String genre ;  
    private double price;
    private int releaseyear;
    private int hoursplayed;
    private boolean boughtstatus;

    public Games(String name, String developer, String genre, double price, int releaseyear, int hoursplayed, boolean boughtstatus){
    this.name = name;
    this.developer = developer;
    this.genre = genre;
    this.price = price;
    this.releaseyear = releaseyear;
    this.hoursplayed = hoursplayed;
    this.boughtstatus = boughtstatus;
       // name[0] = "Tom Clancy's Rainbow Six Siege";
        // name[1] = "Warframe";
        // name[2] = "Resident Evil 4";
        // developer[0] = "Ubisoft";
        // developer[1] = "Digital Extremes";
        // developer[2] = "CAPCOM";
        // genre[0] = "FPS";
        // genre[1] = "MMORPG";
        // genre [2] = "Survival Horror";
        // price[0] = 200000;
        // price[1] = 300000;
        // price[2] = 500000;
        // releaseyear[0] = 2015;
        // releaseyear[1] = 2013;
        // releaseyear[2] = 2023;
        // hoursplayed[0] = 0;
        // hoursplayed[1] = 0;
        // hoursplayed[2] = 0;
        // boughtstatus[0] = false;
        // boughtstatus[1] = false;
        // boughtstatus[2] = false;

    }

    public String getname(){
    return name;
    }
    public String getdeveloper(){
    return developer;
    }
    public String getgenre(){
    return genre;
    }
    public double getprice (){
    return price;
    }
    public int getyear (){
    return releaseyear;
    }

    public void setbstrue (){
    boughtstatus = true;
    }
    public void setbsfalse (){
    boughtstatus = false;
    }
    public boolean getstatus(){
    return boughtstatus;
    }

}
