package Soal01;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Menu {
private Trainer t;
private ArrayList<Trainer> Trainerlist = new ArrayList<Trainer>();
private int donce;

public void startgame(){
Scanner s = new Scanner(System.in);
Random r = new Random();
    if (t.getchosenfirst() == 0){
    System.out.println("\n==========Choose your new Zokemon!==========");
    System.out.println("Choose your Zokemon Type: \n1. Water\n2. Fire\n3. Grass");
    System.out.print("Your Option : ");
    String choosefirstzok = s.next()+s.nextLine();
    while (!choosefirstzok.equals("1") && !choosefirstzok.equals("2") && !choosefirstzok.equals("3")){
    System.out.print("Input not valid! Your Option : ");
    choosefirstzok = s.next()+s.nextLine();
    }
    System.out.println("\nInput the name of your very first Zokemon : ");
    String zok1name = s.next()+s.nextLine();
    Zokemon z = null;
        if (choosefirstzok.equals("1")){
        z = new WaterZok();
        z.setstats();
        z.setname(zok1name);
        } else if (choosefirstzok.equals("2")){
        z = new FireZok();
        z.setstats();
        z.setname(zok1name);
        } else if (choosefirstzok.equals("3")){
        z = new GrassZok();
        z.setstats();
        z.setname(zok1name);
        }
    t.addZokemon(z);
    t.chooseactivezokemon(0); // 1st zokemon
    t.chosenfirst();
    }
while (true){
System.out.println("\n\n==========Welcome "+t.getTrainername()+"!==========");
System.out.println("1. Check Zokemon\n2. Wild Encounter\n3. Shop\n4. Quit");
System.out.print("Your option: ");
String menupilih = s.next()+s.nextLine();
switch (menupilih){
    case "1":
    System.out.println("\n==========Your Zokemon List==========");
    for (int a = 0; a < t.getZokemons().size(); a++){
        if (t.getZokemons().get(a) instanceof FireZok){
        System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Fire");
        } else if (t.getZokemons().get(a) instanceof WaterZok){
        System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Water");
        } else if (t.getZokemons().get(a) instanceof GrassZok){
        System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Grass");
        }
    }
    System.out.print("Check Zokemon Index (0 to go Back) : ");
    int checkzokindex = s.nextInt();
        while (checkzokindex < 0 || checkzokindex > t.getZokemons().size()){
        System.out.println("Input not valid! Check Zokemon Index (0 to go Back) : ");
        checkzokindex = s.nextInt();
        }
        if (checkzokindex == 0){
        System.out.println("Returning to main menu....");
        break;
        }
    System.out.println("==========Chosen Zokemon==========");
    System.out.println("Name : "+t.getZokemons().get(checkzokindex-1).getname());
    if (t.getZokemons().get(checkzokindex-1) instanceof FireZok){
    System.out.println("Type : Fire");
    } else if (t.getZokemons().get(checkzokindex-1) instanceof WaterZok){
    System.out.println("Type : Water");
    } else if (t.getZokemons().get(checkzokindex-1) instanceof GrassZok){
    System.out.println("Type : Grass");
    }
    System.out.println("Level : "+t.getZokemons().get(checkzokindex-1).getlevel());
    System.out.println("Health : "+t.getZokemons().get(checkzokindex-1).getcurrhealth()+"/"+t.getZokemons().get(checkzokindex-1).getmaxhealth());
    System.out.println("Attack : "+t.getZokemons().get(checkzokindex-1).getattack());
    System.out.println("Rarity : "+t.getZokemons().get(checkzokindex-1).getrarity());
    System.out.println("===================================");
    System.out.println("1. Rename Zokemon\n2. Set Active Zokemon\n3. Release Zokemon\n0. Back");
    System.out.print("Your Option : ");
    String optioncase1 = s.next()+s.nextLine();
        while (!optioncase1.equals("1") && !optioncase1.equals("2") && !optioncase1.equals("3") && !optioncase1.equals("0")){
        System.out.print("Input not valid! Your Option : ");
        optioncase1 = s.next()+s.nextLine();
        }
    if (optioncase1.equals("1")){
    System.out.println("Current name : "+t.getZokemons().get(checkzokindex-1).getname());
    System.out.print("Input new Zokemon name : ");
    String newzokname = s.next()+s.nextLine();
    t.getZokemons().get(checkzokindex-1).setname(newzokname);
    System.out.println("Name sucessfully changed!");
    break;
    } else if (optioncase1.equals("2")){
    t.chooseactivezokemon(checkzokindex-1);
    System.out.println(t.getZokemons().get(checkzokindex-1).getname()+" is now the Active Zokemon!");
    break;
    } else if (optioncase1.equals("3")){
        if (t.getZokemons().size() == 1){
        System.out.println("This is your last Zokemon, you cannot release it!");
        } else {
        System.out.println("Zokemon is released! Goodbye, "+t.getZokemons().get(checkzokindex-1).getname()+" !");
        t.releasezokemon(checkzokindex-1);
        t.chooseactivezokemon(0);
        }
    break;
    } else if (optioncase1.equals("0")){
    System.out.println("Returning to main menu....");
    break;
    }
    break;

    case "2":
    System.out.println("\n==========BATTLE!!==========");
    System.out.println("Type Chart : ->Water --> Fire --> Grass-");
    Zokemon enemy = null;
    int randomzoke = r.nextInt(1, 4);
        if (randomzoke == 1){ // water
        enemy = new WaterZok();
        enemy.setname("Watermon");
        } else if (randomzoke == 2){ // fire
        enemy = new FireZok();
        enemy.setname("Firemon");
        } else if (randomzoke == 3){ // grass
        enemy = new GrassZok();
        enemy.setname("Grassmon");
        }
    enemy.setstats();
    if (t.chosenzokemon.getlevel() <= 2){// enemy always level 1 if player level 1 or 2
    
    } else { // enemy too op if player level 1
    int randomleveling = r.nextInt(t.chosenzokemon.getlevel()-2, t.chosenzokemon.getlevel()+4); // bound so +1
    for (int a = 1; a <= randomleveling; a++){
        enemy.addlevel();
        }
    }
    
    while (true){ // while loop true here
    System.out.println("\n#### Enemy Zokemon !!! ####");
    System.out.println("Enemy name : "+enemy.getname());
    System.out.println("Enemy level : "+enemy.getlevel());
    System.out.println("Enemy Health : "+enemy.getcurrhealth()+"/"+enemy.getmaxhealth());
    System.out.println("\n@@@ Your Zokemon !! @@@");
    System.out.println("Your name : "+t.chosenzokemon.getname());
    System.out.println("Your level : "+t.chosenzokemon.getlevel());
    System.out.println("Your Health : "+t.chosenzokemon.getcurrhealth()+"/"+t.chosenzokemon.getmaxhealth());
    System.out.println("===========================");
        if (t.chosenzokemon.getfrozenstat() == true){
        System.out.println("You are frozen, turn is skipped!");
        t.chosenzokemon.thawout();
        }
    else if (t.chosenzokemon.getfrozenstat() == false){
    System.out.println("1. Attack\n2. Catch\n3. Use Potion!\n4. Change!\n5. Run!");
    System.out.print("Your turn: ");
    String chooseaction = s.next()+s.nextLine();
        while (!chooseaction.equals("1") && !chooseaction.equals("2") && !chooseaction.equals("3") && !chooseaction.equals("4") && !chooseaction.equals("5")){
        System.out.print("Action is not valid! Your turn: ");
        chooseaction = s.next()+s.nextLine();
        }

    if (chooseaction.equals("1")){
        if (enemy instanceof WaterZok){
            if (t.chosenzokemon instanceof WaterZok){
            int freezechance = r.nextInt(20, 31);
            int totalpercentage = r.nextInt(1, 101);
            int attackvalue = t.chosenzokemon.getattack();
            enemy.isattacked(attackvalue);
                if (totalpercentage <= freezechance){
                enemy.frozen();
                }
            System.out.println("Your "+t.chosenzokemon.getname()+" attacked the enemy! ("+attackvalue+" dealt!)");
            } 
            else if (t.chosenzokemon instanceof FireZok){
            int blazepercentage = r.nextInt(20, 51);
            double attackvalue = (t.chosenzokemon.getattack() * 0.75);
            double attackwblaze = attackvalue + (attackvalue * blazepercentage / 100);
            enemy.isattacked( (int)attackwblaze );
            System.out.println("Your "+t.chosenzokemon.getname()+" attacked the enemy! ("+(int)attackwblaze+" dealt!)");
            }
            else if (t.chosenzokemon instanceof GrassZok){
            int bloompercentage = r.nextInt(5, 16);
            double bloomvalue = t.chosenzokemon.getmaxhealth() * (bloompercentage/100);
            double attackvalue = (t.chosenzokemon.getattack() * 1.5);
            enemy.isattacked( (int)attackvalue);
            t.chosenzokemon.bloomheal( (int)bloomvalue );
            System.out.println("Your "+t.chosenzokemon.getname()+" attacked the enemy! ("+(int)attackvalue+" dealt!)");
            }
        } else if (enemy instanceof FireZok){
            if (t.chosenzokemon instanceof WaterZok){
            int freezechance = r.nextInt(20, 31);
            int totalpercentage = r.nextInt(1, 101);
            double attackvalue = t.chosenzokemon.getattack() * 1.5;
            enemy.isattacked( (int)attackvalue);
                if (totalpercentage <= freezechance){
                enemy.frozen();
                }
            System.out.println("Your "+t.chosenzokemon.getname()+" attacked the enemy! ("+(int)attackvalue+" dealt!)");
            } 
            else if (t.chosenzokemon instanceof FireZok){
            int blazepercentage = r.nextInt(20, 51);
            double attackvalue = (t.chosenzokemon.getattack());
            double attackwblaze = attackvalue + (attackvalue * blazepercentage / 100);
            enemy.isattacked( (int)attackwblaze );
            System.out.println("Your "+t.chosenzokemon.getname()+" attacked the enemy! ("+(int)attackwblaze+" dealt!)");
            }
            else if (t.chosenzokemon instanceof GrassZok){
            int bloompercentage = r.nextInt(5, 16);
            double bloomvalue = t.chosenzokemon.getmaxhealth() * (bloompercentage/100);
            double attackvalue = (t.chosenzokemon.getattack() * 0.75);
            enemy.isattacked( (int)attackvalue);
            t.chosenzokemon.bloomheal( (int)bloomvalue ); 
            System.out.println("Your "+t.chosenzokemon.getname()+" attacked the enemy! ("+(int)attackvalue+" dealt!)");
            }
        } else if (enemy instanceof GrassZok){
            if (t.chosenzokemon instanceof WaterZok){
            int freezechance = r.nextInt(20, 31);
            int totalpercentage = r.nextInt(1, 101);
            double attackvalue = t.chosenzokemon.getattack() * 0.75;
            enemy.isattacked( (int)attackvalue);
                if (totalpercentage <= freezechance){
                enemy.frozen();
                }
            System.out.println("Your "+t.chosenzokemon.getname()+" attacked the enemy! ("+(int)attackvalue+" dealt!)");
            } 
            else if (t.chosenzokemon instanceof FireZok){
            int blazepercentage = r.nextInt(20, 51);
            double attackvalue = (t.chosenzokemon.getattack() * 1.5);
            double attackwblaze = attackvalue + (attackvalue * blazepercentage / 100);
            enemy.isattacked( (int)attackwblaze );
            System.out.println("Your "+t.chosenzokemon.getname()+" attacked the enemy! ("+(int)attackwblaze+" dealt!)");
            }
            else if (t.chosenzokemon instanceof GrassZok){
            int bloompercentage = r.nextInt(5, 16);
            double bloomvalue = t.chosenzokemon.getmaxhealth() * (bloompercentage/100);
            double attackvalue = (t.chosenzokemon.getattack());
            enemy.isattacked( (int)attackvalue);
            t.chosenzokemon.bloomheal( (int)bloomvalue );
            System.out.println("Your "+t.chosenzokemon.getname()+" attacked the enemy! ("+(int)attackvalue+" dealt!)");
            }
        }
    } else if (chooseaction.equals("2")){
        if (t.getsb() + t.getwb() == 0){
        System.out.println("Your Balls are non-existent");
        }
        else if (t.zokecollection.size() == 6){
        System.out.println("Your Zokemon collection is full! (Max : 6 Zokemons)");
        }
        else{
        System.out.println("==========Your Balls==========");
        System.out.println("[1. ] Wokeballs x"+t.getwb());
            if (t instanceof Aquamancer){
            System.out.println("[2. ] Oceballs x"+t.getsb());
            } else if (t instanceof Pyromaniac){
            System.out.println("[2. ] Volcaballs x"+t.getsb());
            } else if (t instanceof Druid){
            System.out.println("[2. ] Gaiaballs x"+t.getsb());
            }
        System.out.print("Your option: ");
        String whichballs = s.next()+s.nextLine();
            while (!whichballs.equals("1") && !whichballs.equals("2")){
            System.out.print("Input not valid! Your option: ");
            whichballs = s.next()+s.nextLine();
            }
            if (whichballs.equals("1")){ // formula = s / rarity
                if (t.getwb() == 0){
                System.out.println("You have no Wokeballs!");
                continue;
                }
            int chancecatch = r.nextInt(1, enemy.getrarity()+1);
            t.usewb();
                if (chancecatch == 1){
                System.out.println("You caught this wild Zokemon!");
                System.out.print("Name this Zokemon: ");
                String newname = s.next()+s.nextLine();
                enemy.setname(newname);
                t.addZokemon(enemy);
                System.out.println("Sucessfully added "+enemy.getname()+" to the party!");
                break;
                } else {
                System.out.println("Failed to catch Zokemon!");
                }
            } else if (whichballs.equals("2")){
                if (t.getsb() == 0){
                    System.out.println("You have no Wokeballs!");
                    continue;
                    }
                if (t instanceof Pyromaniac && enemy instanceof FireZok){
                int chancecatch = r.nextInt(3, enemy.getrarity()+1);
                t.usesb();
                    if (chancecatch <= 3){
                    System.out.println("You caught this wild Zokemon!");
                    System.out.print("Name this Zokemon: ");
                    String newname = s.next()+s.nextLine();
                    enemy.setname(newname);
                    t.addZokemon(enemy);
                    System.out.println("Sucessfully added "+enemy.getname()+" to the party!");
                    break;
                    } else {
                    System.out.println("Failed to catch Zokemon!");
                    }
                }
                else if (t instanceof Aquamancer && enemy instanceof WaterZok){
                int chancecatch = r.nextInt(3, enemy.getrarity()+1);
                t.usesb();
                    if (chancecatch <= 3){
                    System.out.println("You caught this wild Zokemon!");
                    System.out.print("Name this Zokemon: ");
                    String newname = s.next()+s.nextLine();
                    enemy.setname(newname);
                    t.addZokemon(enemy);
                    System.out.println("Sucessfully added "+enemy.getname()+" to the party!");
                    break;
                    } else {
                    System.out.println("Failed to catch Zokemon!");
                    }
                }
                else if (t instanceof Druid && enemy instanceof GrassZok){
                int chancecatch = r.nextInt(3, enemy.getrarity()+1);
                t.usesb();
                    if (chancecatch <= 3){
                    System.out.println("You caught this wild Zokemon!");
                    System.out.print("Name this Zokemon: ");
                    String newname = s.next()+s.nextLine();
                    enemy.setname(newname);
                    t.addZokemon(enemy);
                    System.out.println("Sucessfully added "+enemy.getname()+" to the party!");
                    break;
                    } else {
                    System.out.println("Failed to catch Zokemon!");
                    }
                }
                else{
                int chancecatch = r.nextInt(1, enemy.getrarity()+1);
                t.usesb();
                    if (chancecatch == 1){
                    System.out.println("You caught this wild Zokemon!");
                    System.out.print("Name this Zokemon: ");
                    String newname = s.next()+s.nextLine();
                    enemy.setname(newname);
                    t.addZokemon(enemy);
                    System.out.println("Sucessfully added "+enemy.getname()+" to the party!");
                    break;
                    } else {
                    System.out.println("Failed to catch Zokemon!");
                    }
                }
            }
        }
    } else if (chooseaction.equals("3")){
        if (t.getpotion() == 0){
        System.out.println("You have no potions!");
        } else{
        System.out.println("Used Potion!");
        t.chosenzokemon.heal();
            if (t.chosenzokemon.getcurrhealth() > t.chosenzokemon.getmaxhealth()){
            t.chosenzokemon.healthmaxed();
            }
        t.usepotion();
        System.out.println("You have "+t.getpotion()+" potions remaining");
        }
    } else if (chooseaction.equals("4")){
    System.out.println("\n==========Choosing New Active Zokemon==========");
    for (int a = 0; a < t.getZokemons().size(); a++){
        if (t.getZokemons().get(a) instanceof FireZok){
        System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Fire");
        } else if (t.getZokemons().get(a) instanceof WaterZok){
        System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Water");
        } else if (t.getZokemons().get(a) instanceof GrassZok){
        System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Grass");
        }
    }
    System.out.print("Choose Zokemon : ");
    int choosenewzok = s.nextInt();
        while (choosenewzok < 1 || choosenewzok > t.getZokemons().size()){
        System.out.println("Input not valid! Choose Zokemon : ");
        choosenewzok = s.nextInt();
        }
    t.chooseactivezokemon(choosenewzok-1);
    System.out.println(t.getZokemons().get(choosenewzok-1).getname()+" is now the Active Zokemon!");
    } else if (chooseaction.equals("5")){
    System.out.println("Dude, seriously?");
    break; // exits loop
    }

    if (enemy.getcurrhealth() <= 0){ // defeated zokemon
    System.out.println("You have defeated the enemy Zokemon!");
    t.chosenzokemon.addlevel();
    System.out.println(t.chosenzokemon.getname()+" has leveled up! Level : "+t.chosenzokemon.getlevel());
    int randommoney = r.nextInt(30, 71);
    System.out.println("Money earned : "+randommoney);
    t.addmoney(randommoney);
    break;
    }
    }// else if your frozenstat false here

    //insert enemy attack here
    if (enemy.getfrozenstat() == true){
        System.out.println("Enemy is frozen, turn is skipped!");
        enemy.thawout();
    }
    else if (enemy.getfrozenstat() == false){
    if (enemy instanceof WaterZok){
        if (t.chosenzokemon instanceof WaterZok){
        int freezechance = r.nextInt(20, 31);
        int totalpercentage = r.nextInt(1, 101);
        double attackvalue = enemy.getattack();
        t.chosenzokemon.isattacked( (int) attackvalue);
            if (totalpercentage <= freezechance){
            t.chosenzokemon.frozen();
            }
        System.out.println("The Enemy "+enemy.getname()+" attacked you! ("+(int)attackvalue+" dealt!)");
        } 
        else if (t.chosenzokemon instanceof FireZok){
        int freezechance = r.nextInt(20, 31);
        int totalpercentage = r.nextInt(1, 101);
        double attackvalue = enemy.getattack() * 1.5;
        t.chosenzokemon.isattacked( (int) attackvalue);
            if (totalpercentage <= freezechance){
            t.chosenzokemon.frozen();
            }
        System.out.println("The Enemy "+enemy.getname()+" attacked you! ("+(int)attackvalue+" dealt!)");
        }
        else if (t.chosenzokemon instanceof GrassZok){
        int freezechance = r.nextInt(20, 31);
        int totalpercentage = r.nextInt(1, 101);
        double attackvalue = enemy.getattack() * 0.75;
        t.chosenzokemon.isattacked( (int) attackvalue);
            if (totalpercentage <= freezechance){
            t.chosenzokemon.frozen();
            }
        System.out.println("The Enemy "+enemy.getname()+" attacked you! ("+(int)attackvalue+" dealt!)");
        }
    } else if (enemy instanceof FireZok){
        if (t.chosenzokemon instanceof WaterZok){
        int blazepercentage = r.nextInt(20, 51);
        double attackvalue = (enemy.getattack() * 0.75);
        double attackwblaze = attackvalue + (attackvalue * blazepercentage / 100);
        t.chosenzokemon.isattacked( (int)attackwblaze );
        System.out.println("The Enemy "+enemy.getname()+" attacked you! ("+(int)attackwblaze+" dealt!)");
        } 
        else if (t.chosenzokemon instanceof FireZok){
        int blazepercentage = r.nextInt(20, 51);
        double attackvalue = (enemy.getattack());
        double attackwblaze = attackvalue + (attackvalue * blazepercentage / 100);
        t.chosenzokemon.isattacked( (int)attackwblaze );
        System.out.println("The Enemy "+enemy.getname()+" attacked you! ("+(int)attackwblaze+" dealt!)");
        }
        else if (t.chosenzokemon instanceof GrassZok){
        int blazepercentage = r.nextInt(20, 51);
        double attackvalue = (enemy.getattack() * 1.5);
        double attackwblaze = attackvalue + (attackvalue * blazepercentage / 100);
        t.chosenzokemon.isattacked( (int)attackwblaze );
        System.out.println("The Enemy "+enemy.getname()+" attacked you! ("+(int)attackwblaze+" dealt!)");
        }
    } else if (enemy instanceof GrassZok){
        if (t.chosenzokemon instanceof WaterZok){
        int bloompercentage = r.nextInt(5, 16);
        double bloomvalue = enemy.getmaxhealth() * (bloompercentage/100);
        double attackvalue = (enemy.getattack() * 1.5);
        t.chosenzokemon.isattacked( (int)attackvalue);
        enemy.bloomheal( (int)bloomvalue );
        System.out.println("The Enemy "+enemy.getname()+" attacked you! ("+(int)attackvalue+" dealt!)");
        } 
        else if (t.chosenzokemon instanceof FireZok){
        int bloompercentage = r.nextInt(5, 16);
        double bloomvalue = enemy.getmaxhealth() * (bloompercentage/100);
        double attackvalue = (enemy.getattack() * 0.75);
        t.chosenzokemon.isattacked( (int)attackvalue);
        enemy.bloomheal( (int)bloomvalue );
        System.out.println("The Enemy "+enemy.getname()+" attacked you! ("+(int)attackvalue+" dealt!)");
        }
        else if (t.chosenzokemon instanceof GrassZok){
        int bloompercentage = r.nextInt(5, 16);
        double bloomvalue = enemy.getmaxhealth() * (bloompercentage/100);
        double attackvalue = (enemy.getattack());
        t.chosenzokemon.isattacked( (int)attackvalue);
        enemy.bloomheal( (int)bloomvalue );
        System.out.println("The Enemy "+enemy.getname()+" attacked you! ("+(int)attackvalue+" dealt!)");
        }
    }

    if (t.chosenzokemon.getcurrhealth() <= 0){ // if your zokemon fainted
    t.chosenzokemon.fainted();
    System.out.println("Your Zokemon has fainted!");
    int faintedall = 0;
        for (int a = 0; a < t.getZokemons().size(); a++){
            if (t.getZokemons().get(a).getfaintstat() == true){
            faintedall++;
            }
        }
        if (faintedall == t.getZokemons().size()){
            System.out.println("Battle Lost!");
            int randomlost = r.nextInt(30, 71);
            t.addmoney(-randomlost);
            break;
        }
    System.out.print("Continue battle? (Y/N) : ");
        String yesno = s.next()+s.nextLine();
    while (!yesno.equalsIgnoreCase("y") && !yesno.equalsIgnoreCase("n")){
    System.out.println("Input can only be Y or N! Continue battle? (Y/N) : ");
    }
        if (yesno.equalsIgnoreCase("y")){
            System.out.println("==========Choosing New Active Zokemon==========");
            for (int a = 0; a < t.getZokemons().size(); a++){
                if (t.getZokemons().get(a) instanceof FireZok){
                    if (t.getZokemons().get(a).getfaintstat() == true){
                    System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Fire || Fainted!!");
                    }
                    else {
                    System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Fire");
                    }
                } else if (t.getZokemons().get(a) instanceof WaterZok){
                    if (t.getZokemons().get(a).getfaintstat() == true){
                    System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Water || Fainted!!");
                    }
                    else {
                    System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Water");
                    }
                } else if (t.getZokemons().get(a) instanceof GrassZok){
                    if (t.getZokemons().get(a).getfaintstat() == true){
                    System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Grass || Fainted!!");
                    }
                    else {
                    System.out.println("["+(a+1)+"] "+t.getZokemons().get(a).getname()+" || Grass");
                    }
                }
            }
            System.out.print("Choose Zokemon : ");
            int choosenewzok = s.nextInt();
                while (choosenewzok < 1 || choosenewzok > t.getZokemons().size() || t.getZokemons().get(choosenewzok-1).getfaintstat() == true){ // cannot choose fainted zokemon
                System.out.print("Input not valid! Choose Zokemon : ");
                choosenewzok = s.nextInt();
                }
            t.chooseactivezokemon(choosenewzok-1);
            System.out.println(t.getZokemons().get(choosenewzok-1).getname()+" is now the Active Zokemon!");
        } else if (yesno.equalsIgnoreCase("n")){
        System.out.println("Battle Lost!");
        int randomlost = r.nextInt(30, 71);
        t.addmoney(-randomlost);
        break; // exits loop
        }
    }
    } // else if enemy frozenstat false here

    } // while loop true here
    break;

    case "3":
    System.out.println("\n==========WOKE MART==========");
    System.out.println("What are you buying, Stranger?");
    System.out.println("Money : $"+t.getmoney());
    System.out.println("\n[1. ] Wokeball $10\n[2. ] Potion $40");
        if (t instanceof Aquamancer){
        System.out.println("[3. ] Oceball $20");
        } else if (t instanceof Pyromaniac){
        System.out.println("[3. ] Volcaball $20");
        } else if (t instanceof Druid){
        System.out.println("[3. ] Gaiaball $20");
        }
    System.out.println("[0. ] Back");
    System.out.print("Your option : ");
    String buyshop = s.next()+s.nextLine();
    while (!buyshop.equals("1") && !buyshop.equals("2") && !buyshop.equals("3") && !buyshop.equals("0")){
    System.out.print("Input not valid! Your option : ");
    buyshop = s.next()+s.nextLine();
    }
    if (buyshop.equals("0")){
        System.out.println("Returning to main menu....");
        break;
    } else if (buyshop.equals("1")){
        if (t.getmoney() < 10){
        System.out.println("Your money is not enough!");
        break;
        }
    t.addmoney(-10);
    t.buywb();
    System.out.println("Bought a Zokeball!");
    break;
    } else if (buyshop.equals("2")){
        if (t.getmoney() < 40){
        System.out.println("Your money is not enough!");
        break;
        }
    t.addmoney(-40);
    t.buypotion();
    System.out.println("Bought a potion!");
    break;
    } else if (buyshop.equals("3")){
        if (t.getmoney() < 20){
        System.out.println("Your money is not enough!");
        break;
        }
    t.addmoney(-20);
    t.buysb();
        if (t instanceof Aquamancer){
        System.out.println("Bought an Oceball!");
        } else if (t instanceof Pyromaniac){
        System.out.println("Bought a Volcaball!");
        } else if (t instanceof Druid){
        System.out.println("Bought a Gaiaball!");
        }
    break;
    } 
    break;

    case "4":
    System.out.println("\nReturning to login page....");
    menu();
    break;

    default:
    System.out.println("Input not available!");
    break;
} // switch menupilih here

    for (int a = 0; a < t.zokecollection.size(); a++){ // for checking any fainted zokemons
        if (t.zokecollection.get(a).getfaintstat() == true){
        t.zokecollection.get(a).revive();
        t.zokecollection.get(a).wakeup(); // faintstat false
        }
    }
} // while true here
}

    public void menu() {
        //Mau Login atau Register
        Scanner s = new Scanner(System.in);
        Trainer currentTrainer = null;
            if (donce == 0){
            System.out.println("\n==========WELCOME TO ZOKEMON==========");
            currentTrainer = register();
            donce = 1;
            t = currentTrainer;
            startgame();
            }
        //
        while (currentTrainer == null) {
            System.out.println("\n==========WELCOME TO ZOKEMON==========");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose menu : ");
            int choose = s.nextInt();
            if (choose == 1) {
                currentTrainer = register();
            } 
            else if (choose == 2) {
                currentTrainer = login();
            }
            else if (choose == 3){
            System.out.println("See you next time!");
            System.exit(0);
            }
            if (currentTrainer != null) {
            t = currentTrainer;
            startgame();
            }
        }
    }

    public Trainer login() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nChoose player: ");
        for (int a = 0; a < Trainerlist.size(); a++){
            if (Trainerlist.get(a) instanceof Aquamancer){
            System.out.println((a+1)+" | "+Trainerlist.get(a).getTrainername()+" | Type: Aquamancer"); 
            }
            else if (Trainerlist.get(a) instanceof Pyromaniac){
            System.out.println((a+1)+" | "+Trainerlist.get(a).getTrainername()+" | Type: Pyromaniac"); 
            }
            else if (Trainerlist.get(a) instanceof Druid){
            System.out.println((a+1)+" | "+Trainerlist.get(a).getTrainername()+" | Type: Druid"); 
            }
        }
        System.out.print("Choose: ");
        int chooseplayer = s.nextInt();
        while (chooseplayer < 1 || chooseplayer > Trainerlist.size()){
        System.out.print("Input not available! Choose: ");
        chooseplayer = s.nextInt();
        }
        t = Trainerlist.get(chooseplayer-1);
        return t;
    }

    public Trainer register() {
        //Minta Trainername dan password
        Scanner s = new Scanner(System.in);
        System.out.print("Input your name: ");
        String uname = s.next()+s.nextLine();
        System.out.println("Choose your Trainer Class : \n1. Aquamancer\n2. Pyromaniac\n3. Druid");
        System.out.print("Your Option : ");
        String choosetclass = s.next()+s.nextLine();
        while (!choosetclass.equals("1") && !choosetclass.equals("2") && !choosetclass.equals("3")){
        System.out.print("Input not valid! Your Option : ");
        choosetclass = s.next()+s.nextLine();
        }
        Trainer newTrainer = null;
        if (choosetclass.equals("1")){
            newTrainer = new Aquamancer();
            newTrainer.setTrainername(uname);
            Trainerlist.add(newTrainer);
        } else if (choosetclass.equals("2")){
            newTrainer = new Pyromaniac();
            newTrainer.setTrainername(uname);
            Trainerlist.add(newTrainer);
        } else if (choosetclass.equals("3")){
            newTrainer = new Druid();
            newTrainer.setTrainername(uname);
            Trainerlist.add(newTrainer);
        }
        //Buat objek player baru
        return newTrainer;
    }
}
