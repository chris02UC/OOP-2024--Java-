package SoalIanToTes;

public class Block extends Aquarium {

    public Block(){
    this.amount_side = 5;
    this.type = "Block";
    }

    public void calcsurfacearea(){
        surface_area = (this.length*this.height)*2 + (this.width*this.height)*2 + (this.width*this.length);
    }
    public void calcvolume(){
        volume = this.length*this.width*this.height;
    }
}
