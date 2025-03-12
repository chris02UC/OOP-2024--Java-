package SoalYobelToTes;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    ArrayList<Lele> AllLele = new ArrayList<Lele>();
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
    System.out.println("Jumlah lele yang dimiliki : "+(AllLele.size()));
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
        Lele newlele = new LeleSangkuriang(namalele); // new stuff
        uang -= newlele.getbibit();
        AllLele.add(newlele);
        System.out.println("Valen membeli lele sangkuriang!");
    }
    else if (pilihlele == 2){
        Lele newlele = new LeleDumbo(namalele); // new stuff
        uang -= newlele.getbibit();
        AllLele.add(newlele);
        System.out.println("Valen membeli lele Dumbo!");
    }
    break;

    case "2":
    System.out.println("\nLele yang tersedia : ");
    for (int a = 0; a < AllLele.size(); a++){
        if (AllLele.get(a) instanceof LeleSangkuriang){
            System.out.println("("+(a+1)+") | Sangkuriang | "+AllLele.get(a).getnama()+" | Umur : "+AllLele.get(a).getumur()+" | Rp. "+AllLele.get(a).getharga());
        }
        else if (AllLele.get(a) instanceof LeleDumbo){
        System.out.println("("+(a+1)+") | Dumbo | "+AllLele.get(a).getnama()+" | Umur : "+AllLele.get(a).getumur()+" | Rp. "+AllLele.get(a).getharga());
        }
    }
    System.out.println("\nIngin menjual lele yang mana?");
    int pilihjual = s.nextInt();
    while (pilihjual < 1 || pilihjual > (AllLele.size())){
        System.out.println("Input tidak tersedia ! Ingin menjual lele yang mana?");
        pilihjual = s.nextInt();
    }
    uang += AllLele.get(pilihjual-1).getharga();
    if (AllLele.get(pilihjual-1) instanceof LeleSangkuriang){
    System.out.println("Berhasil mendapatkan uang sebesar "+AllLele.get(pilihjual-1).getharga()+" dari penjualan Sangkuriang");
    }
    else if (AllLele.get(pilihjual-1) instanceof LeleDumbo){
    System.out.println("Berhasil mendapatkan uang sebesar "+AllLele.get(pilihjual-1).getharga()+" dari penjualan Dumbo");
    }
    AllLele.remove(pilihjual-1);
    // if (pilihjual <= LeleS.size()){
    // uang += LeleS.get(pilihjual-1).getharga();
    // System.out.println("Berhasil mendapatkan uang sebesar "+LeleS.get(pilihjual-1).getharga()+" dari penjualan Sangkuriang");
    // LeleS.remove(pilihjual-1);
    // } else {
    // uang += LeleD.get(pilihjual-(1+LeleS.size())).getharga();
    // System.out.println("Berhasil mendapatkan uang sebesar "+LeleD.get(pilihjual-(1+LeleS.size())).getharga()+" dari penjualan Dumbo");
    // LeleD.remove(pilihjual-(1+LeleS.size()));
    // }
    break;

    case "3":
    System.out.println("\nHari berubah...");
    hari++;
    for (int a = 0; a < AllLele.size(); a++){
        AllLele.get(a).addumur();
        AllLele.get(a).calcharga();
    }
    break;

    case "4":
    System.out.println("\nLele yang tersedia : ");
    for (int a = 0; a < AllLele.size(); a++){
        // System.out.println("("+(a+1)+") | Sangkuriang | "+AllLele.get(a).getnama()+" | Umur : "+AllLele.get(a).getumur()+" | Rp. "+AllLele.get(a).getharga()); this also works to print all
        if (AllLele.get(a) instanceof LeleSangkuriang){
            System.out.println("("+(a+1)+") | Sangkuriang | "+AllLele.get(a).getnama()+" | Umur : "+AllLele.get(a).getumur()+" | Rp. "+AllLele.get(a).getharga());
        }
        else if (AllLele.get(a) instanceof LeleDumbo){
        System.out.println("("+(a+1)+") | Dumbo | "+AllLele.get(a).getnama()+" | Umur : "+AllLele.get(a).getumur()+" | Rp. "+AllLele.get(a).getharga());
        }
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
