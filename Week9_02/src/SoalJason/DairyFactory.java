package SoalJason;

public class DairyFactory extends Bangunan{

    @Override
    public void produksi1() { // mentega
        this.susu.removeFirst();
        this.susu.removeFirst();
    }

    @Override
    public void produksi2() { // keju
        this.susu.removeFirst();
        this.susu.removeFirst();
        this.susu.removeFirst();
    }
    
}
