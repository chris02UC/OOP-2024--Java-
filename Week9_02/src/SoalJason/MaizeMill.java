package SoalJason;

public class MaizeMill extends Bangunan{

    @Override
    public void produksi1() { // nasi jagung
        this.padi.removeFirst();
        this.jagung.removeFirst();
        this.jagung.removeFirst();
    }

    @Override
    public void produksi2() { // popcorn mentega
        this.jagung.removeFirst();
        this.jagung.removeFirst();
        this.mentega.removeFirst();
    }
    
}
