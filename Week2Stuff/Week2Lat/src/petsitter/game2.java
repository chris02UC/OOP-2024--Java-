package petsitter;
import java.util.ArrayList;
import java.util.Scanner;

public class game2 {

    public void Start() {
        player p = new player();
        dog d = new dog();
        Scanner s = new Scanner(System.in);
        int action = 0;
        boolean valid = true;
        dog chosendog = null;
        System.out.println("~~WELCOME TO PETSITTER~~");

        do {
            System.out.println("\n\n--MENU--");
            System.out.println("1. Buy Pet");
            System.out.println("2. Sell Pet");
            System.out.println("3. Select pet to interact");
            System.out.println("4. play with Pet");
            System.out.println("5. Train Pet");
            System.out.println("6. Bath Pet");
            System.out.println("7. Feed Pet");
            System.out.println("8. Let Pet Sleep");
            System.out.println("9. Sell Pet");
            System.out.println("10. Show Pet Status");
            System.out.println("11. Exit");
            System.out.print("Choose you action: ");
            action = s.nextInt();
            System.out.println("");

            if (action > 1 && action < 11){
                if(p.getpetnumber() == 0){
                System.out.println("Buy a dog first!");
                valid = false;
                }
            }
            if (action == 1){
            valid = true; //valid is trolling me tbh
            }
            if (valid){
                switch (action) {
                    case 1:
                        System.out.print("Enter your pet's name: ");
                        String username = s.next() + s.nextLine();
                        dog newdog = new dog(username);
                        p.buydog(newdog);
                        chosendog = newdog;
                        System.out.println("Hai, " + newdog.getName());
                        break;
                    case 2:
                        if (chosendog != null){
                            p.selldog(chosendog);
                            chosendog=null;
                            if(p.getpetnumber() == 0){
                            System.out.println("test");
                            valid = false;
                            }
                        }
                        else {
                        System.out.println("Choose dog first!");
                        }
                        break;
                    case 3:
                        p.showpetname();
                        System.out.println("Choose number: ");
                        int choose = s.nextInt();
                        chosendog = p.getdogarraylist(choose-1);
                        break;
                    case 4:
                        
                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:
                    
                    break;
                    case 10:

                        break;
                    case 11:

                        break;
                    default:
                        System.out.println("Action not available");
                        break;
                }
            }

        } while (action != 11);
    }
}