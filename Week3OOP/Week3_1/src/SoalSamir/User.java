package SoalSamir;

public class User {
    private String username, description;
    private double balance;
    private int level, streaminghours;

    public User(){
    level = 0;
    streaminghours = 0;
    }
    
    public void username(String a){
    this.username = a;
    }
    public String getusername(){
    return username;
    }
    public void setusername(String input){
    username = input;
    }

    public void description(String b){
    this.description = b;
    }
    public String getdescription(){
    return description;
    }
    public void setdescription(String input){
    description = input;
    }

    public void balance (double duek){
    this.balance = duek;
    }
    public double getbalance(){
    return balance;
    }
    public void setbalance(double input){
    balance = input;
    }

    public void level(int c){
    this.level = c;
    }
    public int getlevel(){
    return level;
    }
    public void addlevel(){
    level += 2;
    }

    public void streaminghours(int d){
    this.streaminghours = d;
    }
    public int gethours(){
    return streaminghours;
    }

    public void buygame(double input){
    balance -= input;
    }
    public void sellgame(double input){
    balance += (input/2);
    }
    public void streamincome (int hours){
    balance += (hours*100000);
    }
    public void addhours (int hours){
    streaminghours += hours;
    }


}
