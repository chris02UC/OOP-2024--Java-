package SoalYobel;

public class Lele {
    protected int harga = 0; 
    protected int umur, bibit;
    protected String nama;

    public Lele(String nama){
        this.nama = nama;
        this.umur = 0;
        this.bibit = 100;
    }

    public void addumur(){
    this.umur++;
    }

    public int getbibit(){
        return this.bibit;
    }

    public int getumur(){
        return this.umur;
    }

    public void calcharga(){
        this.harga = umur * 20000;
    }

    public int getharga(){
        return this.harga;
    }
    public String getnama(){
        return this.nama;
    }

}
