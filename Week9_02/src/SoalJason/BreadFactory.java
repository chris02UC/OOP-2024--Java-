package SoalJason;

public class BreadFactory extends Bangunan{

    @Override
    public void produksi1() { // roti
        this.padi.removeFirst();
        this.padi.removeFirst();
        this.padi.removeFirst();
        this.telur.removeFirst();
        this.telur.removeFirst();
    }

    @Override
    public void produksi2() { // milk cheese bun
        this.roti.removeFirst();
        this.susu.removeFirst();
        this.susu.removeFirst();
        this.keju.removeFirst();        
    }
    
}
