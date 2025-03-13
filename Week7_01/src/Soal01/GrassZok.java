package Soal01;

public class GrassZok extends Zokemon{

    @Override
    public void addlevel(){
    this.level++;
    this.attack += 1;
    this.maxhealth += 3;
    this.currhealth += 3;
    }

    @Override
    public void bloomheal(int a){
        this.currhealth += a;
    }
}
