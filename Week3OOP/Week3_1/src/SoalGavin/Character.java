package SoalGavin;
import java.util.ArrayList;

public class Character {
    private String name;
    private int attack, health;
    private Weapon equipweapon;
    private Access equipacc;

    public Character (String name, int attack, int health, Weapon w, Access a){
    this.name = name;
    this.attack = attack;
    this.health = health;
    this.equipweapon = w;
    this.equipacc = a;
    }

    public String getname (){
        return this.name;
    }
    public void setname (String input){
    this.name = input;
    }
    
    public int getattack(){
    return this.attack;
    }
    public void setattack(int input){
        attack += input;
    }
    public void resetattack(int input){
        attack -= input;
    }
    public void sethealth(int input){
        health += input;
    }
    public void resethealth (int input){
        health -= input;
    }
    public int gethealth(){
    return this.health;
    }

    public Weapon getweapon (){
        return this.equipweapon;
    }
    public void setweapon(Weapon input){
        this.equipweapon = input;
    }
    public Access getaccess(){
        return this.equipacc;
    }
    public void setaccess(Access input){
        this.equipacc = input;
    }
}
