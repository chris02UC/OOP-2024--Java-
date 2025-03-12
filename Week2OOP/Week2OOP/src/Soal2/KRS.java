package Soal2;

public class KRS {
    private String nama;
    private String []namakelas = new String[3];
    private int nim, uang, semester, sks;
    private double biaya;

    public void initialize(){
    semester = 1;
    sks = 0;
    namakelas[0] = " ";
    namakelas[1] = " ";
    namakelas[2] = " ";
    }

    public void nama(String name){
    nama = name;
    }
    public String getnama(){
    return this.nama;
    }
    
    public void nim(int nim){
    this.nim = nim;
    }
    public int getnim(){
    return this.nim;
    }

    public void uang(int uang){
    this.uang = uang;
    }   
    public int getuang(){
    return this.uang;
    }
    public void adduang(int tambahan){
    uang += tambahan;
    }

    public void semester(int semester){
    this.semester = semester;
    }
    public void gantisemester(){
    semester++;
    }
    public int getsemester(){
    return this.semester;
    }

    public void sks(int sks){
    this.sks = sks;
    }
    public void addsks(){
    sks++;
    }
    public int getsks(){
    return this.sks;
    }

    public double getbiaya(){
    return biaya;
    }

    public String getnamakelas(int input){
        return namakelas[input];
    }

    public void bayarspp(){
    uang -= biaya;
    }

    public void bayarsks(String input){
        switch (input){
        case "1":
        uang -= 100; //50% diamond
        break;
        case "2":
        uang -= 160; //20% platinum
        break;
        default:
        uang -= 200;
        break;
        }
    }

    public String setnamakelas(String namasks, int urutan){
        return namakelas[urutan] = namasks;
    }
    
    public void menu1(){
    System.out.println("Biaya -> 1xxx:1000, 2xxx:1500");
    System.out.println("Diamond 100% off\nPlatinum 80% off\nGold 50% off\nSilver 20% off");
        if (nim < 2000 && nim >= 1000){
        biaya = 1000;
        }
        else{
        biaya = 1500;
        }
    }

    public void menu(){
    System.out.println("Menu: ");
    System.out.println("1. Bayar SPP\n2. Bayar SKS\n3. Next Semester\n4. Tambah Uang");
    }

    public void displaybea(String input){
        switch (input){
        case "1":
            System.out.println("Diamond");
            break;
        case "2":
            System.out.println("Platinum");
            break;   
        case "3":
            System.out.println("Gold");
            break;
        case "4":
            System.out.println("Silver");
            break;
        case "5":
            System.out.println("Normal");
            break;
        default :
        System.out.println("Invalid, shutting down!");
        System.exit(0);
        }
    }

    public void hitungbea(String input){
        switch (input){
        case "1":
            biaya = 0;
            break;
        case "2":
            biaya = biaya * 0.2;
            break;   
        case "3":
            biaya = biaya * 0.5;
            break;
        case "4":
            biaya = biaya * 0.8;
            break;
        case "5":
            biaya = biaya;
            break;
        default :
        System.out.println("Invalid, shutting down!");
        System.exit(0);
        }
    }

}
