package SoalSamir;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    User u = new User();
    Games g1 = new Games("Tom Clancy's Rainbow Six Siege", "Ubisoft", "FPS", 200000, 2015, 0, false);
    Games g2 = new Games("Warframe", "Digital Extremes", "MMORPG", 300000, 2013, 0, false);
    Games g3 = new Games("Resident Evil 4", "CAPCOM", "Survival Horror", 500000, 2023, 0, false);

    System.out.println("Hello there, future gamer!");
    System.out.print("Input your Username : ");
    String inputun = s.next()+s.nextLine();
    u.setusername(inputun);
    System.out.print("What would be your profile description? Type it : ");
    String inputdesc = s.next()+s.nextLine();
    u.setdescription(inputdesc);
    System.out.print("Input UAP Balance to start with : ");
    double inputbalance = s.nextDouble();
    while (inputbalance <= 0){
        System.out.print("Input invalid! Input UAP Balance to start with : ");
        inputbalance = s.nextDouble();
    }
    u.setbalance(inputbalance);

    while (true){
 //   try { // try catch
    System.out.println("\nWelcome to UAP");
    System.out.println("^^ Select a service! ^^");
    System.out.println("UAP Balance : "+u.getbalance());
    System.out.println("UAP Level : "+u.getlevel());
    System.out.println("Hours streamed : "+u.gethours());
    System.out.println("1. Buy a game\n2. Show bought game\n3. Sell game\n4. Stream\n5. UAP profile\n6. Exit");
    System.out.print("Choose : ");
    String inputmenu = s.next()+s.nextLine();
    switch (inputmenu){
        case "1": 
        System.out.println("\nWhat're ya buyin?");
        System.out.println("Your UAP Balance : "+u.getbalance());
        System.out.println("1. ["+g1.getprice()+"] "+g1.getname()+" - "+g1.getdeveloper()+" - "+g1.getgenre()+" - "+g1.getyear());
        System.out.println("2. ["+g2.getprice()+"] "+g2.getname()+" - "+g2.getdeveloper()+" - "+g2.getgenre()+" - "+g2.getyear());
        System.out.println("3. ["+g3.getprice()+"] "+g3.getname()+" - "+g3.getdeveloper()+" - "+g3.getgenre()+" - "+g3.getyear());        
        System.out.print("Choose (type 0 to menu) : ");
        int menu1 = s.nextInt();
        while (menu1 < 0 || menu1 > 3){
        System.out.print("Input invalid! Choose (type 0 to menu) : ");
        menu1 = s.nextInt();
        }
        if (menu1 == 0){
        System.out.println("Exiting to menu...\n");
        break;
        }
        else {
            if (menu1 == 1){
                if (u.getbalance() < g1.getprice()){
                System.out.println("Need more funds!\n");
                break;
                }
                else if (g1.getstatus() == true){
                System.out.println("Game already bought!\n");
                break;
                }
                else if (menu1 == 1 || menu1 == 2 || menu1 == 3){
                System.out.println("Successfully bought a game! +2 Level\n");
                g1.setbstrue();
                u.buygame(g1.getprice());
                u.addlevel();
                break;
                }
            }
            else if (menu1 == 2){
                if (u.getbalance() < g2.getprice()){
                System.out.println("Need more funds!\n");
                break;
                }
                else if (g2.getstatus() == true){
                System.out.println("Game already bought!\n");
                break;
                }
                else if (menu1 == 1 || menu1 == 2 || menu1 == 3){
                System.out.println("Successfully bought a game! +2 Level\n");
                g2.setbstrue();
                u.buygame(g2.getprice());
                u.addlevel();
                break;
                }
            }
            else if (menu1 == 3){
                if (u.getbalance() < g3.getprice()){
                System.out.println("Need more funds!\n");
                break;
                }
                else if (g3.getstatus() == true){
                System.out.println("Game already bought!\n");
                break;
                }
                else if (menu1 == 1 || menu1 == 2 || menu1 == 3){
                System.out.println("Successfully bought a game! +2 Level\n");
                g3.setbstrue();
                u.buygame(g3.getprice());
                u.addlevel();
                break;
                }
            }
        }
        break;
        
        case "2": 
            if (g1.getstatus() == false && g2.getstatus() == false && g3.getstatus() == false){
            System.out.println("\nNothing here but us chickens. . .\n");
            break;
            }
        else{
        System.out.println("You've bought some excellent choices : ");
        if (g1.getstatus() == true){
            System.out.println("1. "+g1.getname()+" - "+g1.getdeveloper()+" - "+g1.getgenre()+" - "+g1.getyear());
            }
        if (g2.getstatus() == true){
            System.out.println("2. "+g2.getname()+" - "+g2.getdeveloper()+" - "+g2.getgenre()+" - "+g2.getyear());
            }
        if (g3.getstatus() == true){
            System.out.println("3. "+g3.getname()+" - "+g3.getdeveloper()+" - "+g3.getgenre()+" - "+g3.getyear());
            }             
        System.out.println("\n");
        }
        break;

        case "3":
        if (g1.getstatus() == false && g2.getstatus() == false && g3.getstatus() == false){
            System.out.println("\nNothing here but us chickens. . .\n");
            break;
            }
        System.out.println("What're ya sellin? (50% of original buy price)");
        if (g1.getstatus() == true){
            System.out.println("1. "+g1.getname()+" - "+g1.getdeveloper()+" - "+g1.getgenre()+" - "+g1.getyear());
            }
        if (g2.getstatus() == true){
            System.out.println("2. "+g2.getname()+" - "+g2.getdeveloper()+" - "+g2.getgenre()+" - "+g2.getyear());
            }
        if (g3.getstatus() == true){
            System.out.println("3. "+g3.getname()+" - "+g3.getdeveloper()+" - "+g3.getgenre()+" - "+g3.getyear());
            }             
        System.out.print("Choose (type 0 to menu) : ");
        int menu3 = s.nextInt();
        while (menu3 < 0 || menu3 > 3){
        System.out.print("Input invalid! Choose (type 0 to menu) : ");
        menu3 = s.nextInt();        
        }
            if (menu3 == 0){
            System.out.println("Exiting to menu....\n");
            break;
            }
            else {
            if (menu3 == 1){
                if (g1.getstatus() == false){
                    System.out.println("Game is not yet bought!\n");
                    break;
                    }
                    else if (g1.getstatus() == true){
                    System.out.println("Successfully sold a game!\n");
                    g1.setbsfalse();
                    u.sellgame(g1.getprice());
                    break;
                    }   
                }
            else if (menu3 == 2){
                if (g2.getstatus() == false){
                    System.out.println("Game is not yet bought!\n");
                    break;
                    }
                    else if (g2.getstatus() == true){
                    System.out.println("Successfully sold a game!\n");
                    g2.setbsfalse();
                    u.sellgame(g2.getprice());
                    break;
                    }   
                }
            else if (menu3 == 3){
                if (g3.getstatus() == false){
                System.out.println("Game is not yet bought!\n");
                break;
                }
                else if (g3.getstatus() == true){
                System.out.println("Successfully sold a game!\n");
                g3.setbsfalse();
                u.sellgame(g3.getprice());
                break;
                }   
            }
            }     
        break;

        case "4": 
        if (g1.getstatus() == false && g2.getstatus() == false && g3.getstatus() == false){
            System.out.println("\nNo games found to stream!\n");
            break;
            }
        System.out.println("Streaming on Twitch");
        System.out.println("Hours streamed : "+u.gethours());
        System.out.print("Streaming for how many hours on Twitch? : ");
        int inputhours = s.nextInt();
            while (inputhours <= 0){
            System.out.print("Input invalid! Streaming for how many hours on Twitch? : ");
            inputhours = s.nextInt();
            }
        u.streamincome(inputhours);
        u.addhours(inputhours);
        System.out.println("Streaming done! You get "+(inputhours*100000)+" balance! Great work!");
        break;
        
        case "5": 
        System.out.println("Here's your profile!");
        System.out.println("Username : "+u.getusername());
        System.out.println("Description : "+u.getdescription());
        System.out.println("Balance : "+u.getbalance());
        System.out.println("Level : "+u.getlevel());
        System.out.println("Hours streamed : "+u.gethours());
        System.out.print("Do you wish to edit (Y/N) : ");
        String yesno = s.next()+s.nextLine();
        while (!yesno.equalsIgnoreCase("Y") && !yesno.equalsIgnoreCase("n")){
        System.out.print("Input invalid! Do you wish to edit (Y/N) : ");
        yesno = s.next()+s.nextLine();
        }
        if (yesno.equalsIgnoreCase("y")){
            System.out.print("New username : ");
            String newus = s.next()+s.nextLine();
            u.setusername(newus);
            System.out.print("New Description : ");
            String newdesc = s.next()+s.nextLine();
            u.setdescription(newdesc);
        System.out.println("Successfully updated the UAP profile\n");
        break;
        }else if (yesno.equalsIgnoreCase("n")){
        System.out.println("You chose not to, back to menu!\n");
        break;
        }
        break;

        case "6":
        System.out.print("Are you sure you want to log out? (Y/N) : ");
        String yesno2 = s.next()+s.nextLine();
        while (!yesno2.equalsIgnoreCase("Y") && !yesno2.equalsIgnoreCase("n")){
        System.out.print("Input invalid! Are you sure you want to log out? (Y/N) : ");
        yesno2 = s.next()+s.nextLine();
        }
        if (yesno2.equalsIgnoreCase("y")){
        System.out.println("See you next time!");
        System.exit(0);
        }else if (yesno2.equalsIgnoreCase("n")){
        System.out.println("You chose not to, back to menu!\n");
        break;
        }        
        break;

        default :
        System.out.println("\nInput not available!\n");
        break;
    }
  //  } catch (Exception e) { // try catch
  //      System.out.println("Error, error, repeating..."); // try catch
   // } // try catch
    }
    }
}
