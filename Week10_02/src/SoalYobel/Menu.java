package SoalYobel;
import java.util.Scanner;
import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;

public class Menu {

    public void RunApp(){
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    Queue<JasaTitip> allJastip = new LinkedList();

    while (true){
    try{
        System.out.println("\nHello! :D Apa yang Anda ingin lakukan?");
        System.out.println("1. Tambah Jasa Titip\n2. Tambah Customer\n3. Show Jasa Titip\n4. Show Jasa Titip dan Customer\n5. Layani Semua Antrian\n6. Exit");
        System.out.print("Pilih: ");
        String pilihmenu = s.next()+s.nextLine();
        while (!pilihmenu.equals("1") && !pilihmenu.equals("2") && !pilihmenu.equals("3") && !pilihmenu.equals("4") && !pilihmenu.equals("5")&& !pilihmenu.equals("6")){
            System.out.print("Input invalid! Pilih: ");
            pilihmenu = s.next()+s.nextLine();
        }

    switch(pilihmenu){
        case "1":
        System.out.println("\n=== Tambah Jasa Titip ===");
        System.out.print("Input nama Jastip: ");
        String namajt = s.next()+s.nextLine();
        long hargajt = r.nextLong(500000, 1000001);
        System.out.println("Harga Jastip: Rp. "+hargajt);

        JasaTitip newjt = new JasaTitip();
        newjt.setNamajt(namajt);
        newjt.setHargajt(hargajt);
        allJastip.add(newjt);
        break;

        case "2":
        System.out.println("\n=== Tambah Customer ===");
            if (allJastip.size() == 0){
                System.out.println("Anda tidak punya jasa titip, tambahkan dahulu!");
                break;
            }
        int jastipsize1 = allJastip.size();
        int numbering2 = 0;
            while (numbering2 < jastipsize1){ // revolving printing
            //add to last
            JasaTitip jt = new JasaTitip();
            jt = allJastip.peek();
            allJastip.add(jt);
            // System.out.println("test");
            //get and remove first
            System.out.println((numbering2+1)+". "+allJastip.poll().getNamajt());
            numbering2++;
            }
        System.out.print("Tambah customer ke jastip mana? : ");
        int pilihjastip = s.nextInt();
            while (pilihjastip < 1 || pilihjastip > allJastip.size()){
                System.out.println("Input invalid!");
                System.out.print("Tambah customer ke jastip mana? : ");
                pilihjastip = s.nextInt();
            }
            System.out.println("test");
        LinkedList<JasaTitip> lltemp = (LinkedList<JasaTitip>) allJastip;
        System.out.println("\nJastip: "+lltemp.get(pilihjastip-1).getNamajt());
        String yesno1 = "y";
        while(yesno1.equalsIgnoreCase("y")){
            System.out.println("Tulis nama customer: ");
            String namacust = s.next()+s.nextLine();
            lltemp.get(pilihjastip-1).addCust(namacust);
            System.out.println("Tambah customer lagi? (Y/N) : ");
            yesno1 = s.next()+s.nextLine();
            while (!yesno1.equalsIgnoreCase("y") && !yesno1.equalsIgnoreCase("n")){
            System.out.println("Input invalid! Tambah customer lagi? (Y/N) : ");
            yesno1 = s.next()+s.nextLine();
            }            
        }
        break;

        case "3":
        System.out.println("\n=== Show All Jastip ===");
            if (allJastip.size() == 0){
                System.out.println("Anda tidak punya jasa titip, tambahkan dahulu!");
                break;
            }
        int jastipsize3 = allJastip.size();
        int numbering3 = 0;
            while (numbering3 < jastipsize3){ // revolving printing
            //add to last
            JasaTitip jt3 = new JasaTitip();
            jt3 = allJastip.peek();
            allJastip.add(jt3);
            // System.out.println("test");
            //get and remove first
            System.out.println((numbering3+1)+". "+jt3.getNamajt()+" | Rp. "+jt3.getHargajt());
            allJastip.poll();
            numbering3++;
            }
        break;

        case "4":
        System.out.println("\n=== Show All Jastip & Customers ===");
        if (allJastip.size() == 0){
            System.out.println("Anda tidak punya jasa titip, tambahkan dahulu!");
            break;
        }
        int jastipsize4 = allJastip.size();
        int numbering4 = 0;
            while (numbering4 < jastipsize4){ // revolving printing
            //add to last
            JasaTitip jt4 = new JasaTitip();
            jt4 = allJastip.peek();
            allJastip.add(jt4);
            // System.out.println("test");
            //get and remove first
            System.out.println((numbering4+1)+". "+jt4.getNamajt()+" | Rp. "+jt4.getHargajt());
                if (jt4.getANsize() == 0){
                    System.out.println("No customers!");
                    
                } else{
            System.out.print("Customers : ");    
            int custnumbering = 0;
                while (custnumbering < jt4.getANsize()){
                    if (custnumbering == jt4.getANsize()-1){
                    System.out.print(jt4.peekAntrianCust()+"\n");
                    jt4.revolveAntrianCust();
                    break;
                    }
                    System.out.print(jt4.peekAntrianCust()+" | ");
                    jt4.revolveAntrianCust();
                    custnumbering++;
                }
            }
            allJastip.poll();
            numbering4++;
            }  
        break;

        case "5":
        if (allJastip.size() == 0){
            System.out.println("Anda tidak punya jasa titip, tambahkan dahulu!");
            break;
        }
        int chancebroken = r.nextInt(1, 6);
        if (chancebroken > 3){
            System.out.println("Sorry, mesin rusak!");
            break;
        }
        else if (chancebroken <= 3){
        LinkedList<JasaTitip> lltemp2 = (LinkedList<JasaTitip>) allJastip;
        int jastipsize5 = allJastip.size();
        int numbering5 = 0;
            while (numbering5 < jastipsize5){ // revolving printing
                Long rpercust = r.nextLong(100000, 200001);//random 100k - 200k

                System.out.println("\nJasa Titip: "+lltemp2.getFirst().getNamajt()+" | Rp. "+lltemp2.getFirst().getHargajt());
                while(lltemp2.getFirst().getHargajt() >= rpercust || lltemp2.getFirst().getANsize() > 0){
                    if (lltemp2.getFirst().getHargajt() < rpercust){
                    System.out.println("Uang tidak cukup untuk order lagi!");
                    lltemp2.add(lltemp2.poll());
                    break;
                    } else if (lltemp2.getFirst().getANsize() == 0){
                    System.out.println("No more customers");
                    lltemp2.removeFirst();
                    break;
                    }
                    lltemp2.getFirst().minusHargajt(rpercust);
                    System.out.println(lltemp2.getFirst().dequeueAntrian()+" order selesai!");
                }

                // if (lltemp2.getFirst().getANsize() == 0){
                //     lltemp2.removeFirst();
                // } else {
                //     lltemp2.add(lltemp2.poll());
                // }
                numbering5++;
                }  
        }
        break;

        case "6":
        System.out.println("Bye-bye!");
        System.exit(0);
        break;

        default:
        System.out.println("Input unavailable!");
        break;
    }

    // break;
    } catch (Exception e){
        System.out.println("Error, error!");
    }
    } // try catch ends here
    }
}
