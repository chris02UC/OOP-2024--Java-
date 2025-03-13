package Soal01;
import java.util.Random;

public class Zokemon {
    Random r = new Random();
    protected String name;
    protected int attack, maxhealth, currhealth, rarity;
    protected int level = 1;
    protected boolean faintstatus = false;
    protected boolean frozenstatus = false;

    public String getname(){
        return this.name;
    }
    public void setname(String a){
        this.name = a;
    }
    public int getlevel(){
        return this.level;
    }
    public void addlevel(){
    }
    public void bloomheal(int a){
    this.currhealth += a;
    }

    public void setstats(){
    this.maxhealth = r.nextInt(25, 51);
    this.currhealth = maxhealth;
    this.attack = r.nextInt(3, 8);
    this.rarity = r.nextInt(1, 11);
    }
    public void revive(){
    this.currhealth = 1;
    }
    public int getmaxhealth(){
        return this.maxhealth;
    }
    public int getcurrhealth(){
        return this.currhealth;
    }
    public void isattacked(int a){
        this.currhealth -= a;
    }
    public void heal(){
        this.currhealth += 20;
    }
    public void healthmaxed(){
        this.currhealth = maxhealth;
    }
    public int getattack(){
        return this.attack;
    }
    public int getrarity(){
        return this.rarity;
    }
    public boolean getfaintstat(){
        return this.faintstatus;
    }
    public void fainted(){
        this.faintstatus = true;
    }
    public void wakeup(){
        this.faintstatus = false;
    }
    public boolean getfrozenstat(){
        return this.frozenstatus;
    }
    public void frozen(){
        this.frozenstatus = true;
    }
    public void thawout(){
        this.frozenstatus = false;
    }

}
