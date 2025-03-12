package SoalJason;
import java.util.Scanner;


public class RunApp {
private User u = new User();
private Bangunan b = new Bangunan();
private Gudang g = new Gudang();
private Lumbung l = new Lumbung();
Scanner s = new Scanner(System.in);

    public void runapp(){
        int daycounter = 1;
    System.out.println("Hello, Stranger!");
    System.out.print("Tell me your name: ");
    String inputnama = s.next()+s.nextLine();
    u.setName(inputnama);
    System.out.println("Nice to meet you, "+u.getName());
    System.out.println("Let's Start this Game!");
    System.out.println("=====================================");
    for (int a = 0; a < 3; a++){
        l.addJagung();
        l.addPadi();
        l.addTelur();
        l.addSusu();
    }
    while (true){
    System.out.println("\nDay "+daycounter);
    System.out.println("What would you like to do, "+u.getName()+" ?");
    System.out.println("1. Plant Crops\n2. Make Produce\n3. Buy Raw Materials\n4. Sell Produce\n5. Buy Buildings\n6. Next Day\n7. Exit");
    System.out.print("Choose Action: ");
    String inputmm = s.next()+s.nextLine();
    while (!inputmm.equals("1") && !inputmm.equals("2") && !inputmm.equals("3") && !inputmm.equals("4") && !inputmm.equals("5") && !inputmm.equals("6") && !inputmm.equals("7")){
        System.out.print("Input not valid! Choose valid Action: ");
    }
    switch (inputmm){
        case "1":

        break;

        case "2":
        break;
                
        case "3":
        break;
                
        case "4":

        break;
                
        case "5":
            System.out.println("\nBuy Buildings");
            if (u.getOwnBF() == false && u.getOwnMM() == false){
                System.out.println("Buy which Building?");
                System.out.println("1. Bread Factory\nCost: 200");
                System.out.println("---------------");
                System.out.println("2. Maize Mill\nCost: 300");
                System.out.print("Input (1/2): ");
                String yesno = s.next()+s.nextLine();
                while (!yesno.equalsIgnoreCase("1") || !yesno.equalsIgnoreCase("2")){
                    System.out.print("Input not valid! Input (1/2): ");
                    yesno = s.next()+s.nextLine();
                }
                if (yesno.equalsIgnoreCase("1")){
                    System.out.println("Bought Bread Factory!");
                    u.useMoney(200);
                    u.setOwnBF(true);
                    break;
                } else if (yesno.equalsIgnoreCase("2")){
                    System.out.println("Bought Maize Mill!");
                    u.useMoney(300);
                    u.setOwnMM(true);
                    break;
                }
            } 
            else if (u.getOwnBF() == false && u.getOwnMM() == true){
                System.out.println("Buy Bread Factory? (Cost: 200)");
                System.out.print("Input (Y/N): ");
                String yesno = s.next()+s.nextLine();
                while (!yesno.equalsIgnoreCase("y") || !yesno.equalsIgnoreCase("n")){
                    System.out.print("Input not valid! Input (Y/N): ");
                    yesno = s.next()+s.nextLine();
                }
                if (yesno.equalsIgnoreCase("y")){
                    System.out.println("Bought Bread Factory!");
                    u.useMoney(200);
                    u.setOwnBF(true);
                    break;
                } else if (yesno.equalsIgnoreCase("n")){
                    System.out.println("Cancelling purchase....");
                    break;
                }
            } else if (u.getOwnBF() == true && u.getOwnMM() == false){
                System.out.println("Buy Maize Mill? (Cost: 300)");
                System.out.print("Input (Y/N): ");
                String yesno = s.next()+s.nextLine();
                while (!yesno.equalsIgnoreCase("y") || !yesno.equalsIgnoreCase("n")){
                    System.out.print("Input not valid! Input (Y/N): ");
                    yesno = s.next()+s.nextLine();
                }
                if (yesno.equalsIgnoreCase("y")){
                    System.out.println("Bought Maize Mill!");
                    u.useMoney(300);
                    u.setOwnMM(true);
                    break;
                } else if (yesno.equalsIgnoreCase("n")){
                    System.out.println("Cancelling purchase....");
                    break;
                }
            } else if (u.getOwnBF() == true && u.getOwnMM() == true){
                System.out.println("You have owned all buildings!");
                break;
            }
        break;
                
        case "6":
        daycounter++;
        break;
                
        case "7":
        System.exit(0);
        break;

        default:
        System.out.println("Input invalid!");
        break;
    }

    } //while true ends here

    } //public void ends here
}
