package Soal1;

public class hotel {
    private String nama;
    private int jumlah, biaya, harga, uang, day;

    public void namahotel(String name){
    nama = name;
    } // tes
    //haha

    public String getnamahotel(){
    return this.nama;
    }
    
    public void jumlah(int jumlah){
    this.jumlah = jumlah;
    }

    public int getjumlah(){
    return this.jumlah;
    }

    public void biaya(int biaya){
    this.biaya = biaya;
    }

    public int getbiaya(){
    return this.biaya;
    }

    public void harga(int harga){
    this.harga = harga;
    }

    public int getharga(){
    return this.harga;
    }

    public void initalize(){
    uang = 0;
    day = 0;
    }

    public void tambahkamar(int add){
        if ((add * biaya) > uang){
        System.out.println("Uang tidak mencukupi!");
        }
        else {
        System.out.println("Berhasil menambahkan kamar sebanyak "+add);
        jumlah = jumlah + add;
        uang = uang - (add * biaya);
        }
    }

    public void nextday(int customer){
        if (customer > jumlah){
        System.out.println("Kamar tidak cukup!");
        }
        else {
        System.out.println("Anda mendapat penghasilan sebesar "+(customer*harga));
        uang += (customer * harga);
        day += 1;
        }
    }

    public void statushotel(){
    System.out.println("=======================================\nWelcome to "+nama+" Hotel");
    System.out.println("Day-"+day);
    System.out.println("Uang: "+uang);
    System.out.println("Jumlah kamar: "+jumlah);
    System.out.println("Harga per-malam: "+harga);
    System.out.println("Biaya menambah kamar: "+biaya);
    }

    public void menu(){
    System.out.println("Menu: ");
    System.out.println("1. Ganti nama\n2. Tambah kamar\n3. Ganti harga\n4. Ganti harga menambah kamar\n5. Next day\n0. Keluar");
    }


}
