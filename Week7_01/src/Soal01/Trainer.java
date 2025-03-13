package Soal01;
import java.util.ArrayList;

public class Trainer {
    protected String name;
    protected int money = 300;
    protected int wokeball = 3;
    protected int specialball = 0;
    protected int potion = 1;
    protected int choosefirstzokemon = 0;
    protected ArrayList<Zokemon> zokecollection = new ArrayList<Zokemon>();
    protected Zokemon chosenzokemon;


    public void setTrainername(String a) {
        this.name = a;
    }
    public String getTrainername(){
        return this.name;
    }

    public void addmoney(int a){
        this.money += a;
    }
    public int getmoney(){
        return this.money;
    }
    public void buywb(){
        this.wokeball++;
    }
    public void buysb(){
        this.specialball++;
    }
    public void buypotion(){
        this.potion++;
    }
    public int getwb(){
        return this.wokeball;
    }
    public int getsb(){
        return this.specialball;
    }
    public int getpotion(){
        return this.potion;
    }
    public void usewb(){
        this.wokeball--;
    }
    public void usesb(){
        this.specialball--;
    }
    public void usepotion(){
        this.potion--;
    }

    public void chosenfirst(){
        this.choosefirstzokemon = 1;
    }
    public int getchosenfirst(){
        return this.choosefirstzokemon;
    }
    public void addZokemon(Zokemon z){
        zokecollection.add(z);
    }
    public ArrayList<Zokemon> getZokemons(){
        return zokecollection;
    }
    public void chooseactivezokemon(int a){
        this.chosenzokemon = zokecollection.get(a);
    }
    public void releasezokemon(int a){
        zokecollection.remove(a);
    }

}
