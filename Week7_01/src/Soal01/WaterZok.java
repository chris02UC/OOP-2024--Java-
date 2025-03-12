package Soal01;

public class WaterZok extends Zokemon{

    @Override
    public void addlevel(){
    this.level++;
    this.attack += 2;
    this.maxhealth += 2;
    this.currhealth += 2;
    }
}
