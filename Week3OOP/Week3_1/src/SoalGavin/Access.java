package SoalGavin;

import java.util.Random;

public class Access {
        Random r = new Random();
    private String nama;
    private int level, health, cost;
    public Object out;

    public Access(String nama){
    this.nama = nama;
    }

    public void setlevel(){
    this.level = r.nextInt(1, 31);
    }
    public void sethealth(int minhealth, int maxhealth, int multiplier){
    this.health = r.nextInt(minhealth, (maxhealth+1)) * (this.level/2) + (this.level*3);
    }
    public void setcost(int mincost, int maxcost){
        this.cost = r.nextInt(mincost, (maxcost+1))+this.level*2;
    }


}
