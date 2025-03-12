package SoalGavin;
import java.util.ArrayList;
import java.util.Random;

public class Weapon {
    Random r = new Random();
    private String nama;
    private int level, attack, cost;

    //public Weapon(String nama, int minattack, int maxattack, int multiplier, int mincost, int maxcost){
    public Weapon(String nama){
    this.nama = nama;
    }

    public void setlevel(){
    this.level = r.nextInt(1, 31);
    }
    public void setattack(int minattack, int maxattack, int multiplier){
    this.attack = r.nextInt(minattack, (maxattack+1))*multiplier+this.level;
    }
    public void setcost(int mincost, int maxcost){
    this.cost = r.nextInt(mincost, (maxcost+1))+this.level*2;
    }

    public void showwepstatus(){

    }

    public void add(ArrayList<String> invenweaponname) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
