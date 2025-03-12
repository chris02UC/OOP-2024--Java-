package Main;
import Player.Player;
import java.util.Scanner;
import java.util.Random;

public class rungame {

public void runGame(){
Scanner s = new Scanner(System.in);
Player p1 = new Player();
Player p2 = new Player();
Player p3 = new Player();
Player p4 = new Player();

    System.out.println("You are head of a family in an Italian city-state, a city run by a weak and corrupt court.\nYou need to manipulate, bluff and bribe your way to power.\nYour object is to destroy the influence of all the other families, forcing them into exile.\nOnly one family will survive…");
    System.out.println("<- WELCOME TO COUP ->");
    System.out.println("Enter your name : ");
    String yourname = s.next()+s.nextLine();
    p1.setPlayername(yourname);
    System.out.println("Welcome, "+p1.getPlayername());
    System.out.println("Are your ready to start the game? (ketikkan 'syap')");

    String syapndak = s.next()+s.nextLine();
    while (!syapndak.equalsIgnoreCase("syap")){
    System.out.println("\nWelcome, "+p1.getPlayername());
    System.out.println("Are your ready to start the game? (ketikkan 'syap')");
    syapndak = s.next()+s.nextLine();
    }

    System.out.println("Preparing the Family...\nShuffling the Influence Cards...\nThree(3) other Players have entered the Game as your ENEMY...");

    //sudahngantuk
    System.out.println("It's "+p1.getPlayername()+"'s turn");
    System.out.println("You have "+p1.getCoin()+" coins");

}

}
