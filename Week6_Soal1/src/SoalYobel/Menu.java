package SoalYobel;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    ArrayList<LeleSangkuriang> LeleS = new ArrayList<LeleSangkuriang>();
    ArrayList<LeleDumbo> LeleD = new ArrayList<LeleDumbo>();
    int uang;

    public void RunLele(){
    Scanner s = new Scanner(System.in);

    System.out.println("Uang?");
    int inputuang = s.nextInt();
    while (inputuang <= 0){
        System.out.print("Uang tidak bisa 0 atau kurang dari 0! Input uang: ");
        inputuang = s.nextInt();
    }
    uang = inputuang;
    int hari = 1;
    while(true){
    System.out.println("\n=== SISTEM TERNAK MILIK VALEN ===");
    System.out.println("Jumlah lele yang dimiliki : "+(LeleS.size()+LeleD.size()));
    System.out.println("Hari : "+hari);
    System.out.println("Uang : "+uang);
    System.out.println("=================================");
    System.out.println("[1] Beli bibit lele\n[2] Jual lele\n[3] Ganti hari\n[4] Lihat semua lele\n[0] Exit");
    System.out.println("=================================");
    System.out.println("Pilih : ");
    String choicemenu = s.next()+s.nextLine();

    switch (choicemenu){
    case "1":
    System.out.println("\n=== BELI BIBIT LELE ===");
    System.out.println("[1] Lele Sangkuriang\n[2] Lele Dumbo");
    System.out.println("=================================");
    System.out.println("Pilih : ");
    int pilihlele = s.nextInt();
        while (pilihlele < 1 || pilihlele > 2){
        System.out.println("Input not valid! Pilih : ");
        pilihlele = s.nextInt();
        }
        if (uang < 100 && pilihlele == 1){
        System.out.println("Uang Valen tidak cukup!");
        break;
        }
        else if (uang < 200 && pilihlele == 2){
        System.out.println("Uang Valen tidak cukup!");
        break;
        }
    System.out.println("Nama Lele : ");
    String namalele = s.next()+s.nextLine();

    if (pilihlele == 1){
        LeleSangkuriang ls = new LeleSangkuriang(namalele);
        uang -= ls.getbibit();
        LeleS.add(ls);
        System.out.println("Valen membeli lele sangkuriang!");
    }
    else if (pilihlele == 2){
        LeleDumbo ld = new LeleDumbo(namalele);
        uang -= ld.getbibit();
        LeleD.add(ld);
        System.out.println("Valen membeli lele Dumbo!");
    }
    break;

    case "2":
    System.out.println("\nLele yang tersedia : ");
    for (int a = 0; a < LeleS.size(); a++){
        System.out.println("("+(a+1)+") | Sangkuriang | "+LeleS.get(a).getnama()+" | Umur : "+LeleS.get(a).getumur()+" | Rp. "+LeleS.get(a).getharga());
    }
    for (int a = 0; a < LeleD.size(); a++){
        System.out.println("("+(a+1+LeleS.size())+") | Dumbo | "+LeleD.get(a).getnama()+" | Umur : "+LeleD.get(a).getumur()+" | Rp. "+LeleD.get(a).getharga());
    }
    System.out.println("\nIngin menjual lele yang mana?");
    int pilihjual = s.nextInt();
    while (pilihjual < 1 || pilihjual > (LeleS.size()+LeleD.size())){
        System.out.println("Input tidak tersedia ! Ingin menjual lele yang mana?");
        pilihjual = s.nextInt();
    }
    if (pilihjual <= LeleS.size()){
    uang += LeleS.get(pilihjual-1).getharga();
    System.out.println("Berhasil mendapatkan uang sebesar "+LeleS.get(pilihjual-1).getharga()+" dari penjualan Sangkuriang");
    LeleS.remove(pilihjual-1);
    } else {
    uang += LeleD.get(pilihjual-(1+LeleS.size())).getharga();
    System.out.println("Berhasil mendapatkan uang sebesar "+LeleD.get(pilihjual-(1+LeleS.size())).getharga()+" dari penjualan Dumbo");
    LeleD.remove(pilihjual-(1+LeleS.size()));
    }
    break;

    case "3":
    System.out.println("\nHari berubah...");
    hari++;
    for (int a = 0; a < LeleS.size(); a++){
        LeleS.get(a).addumur();
        LeleS.get(a).calcharga();
    }
    for (int a = 0; a < LeleD.size(); a++){
        LeleD.get(a).addumur();
        LeleD.get(a).calcharga();
    }
    break;

    case "4":
    System.out.println("\nLele yang tersedia : ");
    for (int a = 0; a < LeleS.size(); a++){
        System.out.println("("+(a+1)+") | Sangkuriang | "+LeleS.get(a).getnama()+" | Umur : "+LeleS.get(a).getumur()+" | Rp. "+LeleS.get(a).getharga());
    }
    for (int a = 0; a < LeleD.size(); a++){
        System.out.println("("+(a+1+LeleS.size())+") | Dumbo | "+LeleD.get(a).getnama()+" | Umur : "+LeleD.get(a).getumur()+" | Rp. "+LeleD.get(a).getharga());
    }
    break;

    case "0":
    System.out.println("\nSampai jumpa!");
    System.exit(0);
    break;

    default:
    System.out.println("Input not available!");
    break;
    }
    
    }//end of while true loop
    }

}
