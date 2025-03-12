package Soal01;

public class FireZok extends Zokemon{
    
    @Override
    public void addlevel(){
    this.level++;
    this.attack += 3;
    this.maxhealth += 1;
    this.currhealth += 1;
    }
}
