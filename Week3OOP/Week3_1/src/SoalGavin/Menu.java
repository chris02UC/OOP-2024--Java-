package SoalGavin;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    int money = 5000;
    ArrayList<String>invenweaponname = new ArrayList<>();
    ArrayList<String>invenweaponlvl = new ArrayList<>();
    ArrayList<String>invenweaponcost = new ArrayList<>();    
    ArrayList<String>invenacc = new ArrayList<>();
   

    Character c1 = new Character("Yobel", r.nextInt(1, 6), r.nextInt(10, 51), null, null);
    Character c2 = new Character("", r.nextInt(1, 6), r.nextInt(10, 51), null, null);
    Weapon wknife = new Weapon("Willas' Knife");// 1, 3, 1, 100, 200); (try level, cost? so not 3)
    Weapon wsword = new Weapon("Willas' Sword");// 4, 6, 1, 201, 300);
    Weapon wgaunt = new Weapon("Willas' Gauntlets"); // 7, 9, 2, 301, 400);
    Weapon willas = new Weapon("Willas");

    
    
    System.out.println("Willas: Hey there travelers, What's your guys' names?");
    System.out.print("Hey! I'm Yobel, and this is... ");
    String inputnama = s.next()+s.nextLine();
    c2.setname(inputnama);
    System.out.println("Willas: Well then, Welcome "+c1.getname()+" and "+c2.getname()+" to my shop!");
    
    while (true){ // while true
    System.out.println("\n\n== Welcome to Willas' Wacky Wares ===");
    System.out.println("Money: "+money);
    System.out.println("Weapons owned: ");
    System.out.println("Accessories owned: "+"\n");
    System.out.println("What do you want to do?");
    System.out.println("[1] Character Details\n[2] Check Inventory\n[3] Enter Store\n[4] Exit");
    String menu = s.next()+s.nextLine();
    switch (menu) {
    case "1":
    System.out.println("Which Character");
    System.out.println("[1] Yobel");
    System.out.println("[2] "+c2.getname());
    System.out.println("[0] Return");
    System.out.print("Choose: ");
    int input1 = s.nextInt();
    while (input1 < 0 || input1 > 2){
        System.out.print("Input invalid! Choose:");
        input1 = s.nextInt();
    }
    if (input1 == 1){
    System.out.println("======== Yobel's STATS ========");
    System.out.println("Health: "+c1.gethealth());
    System.out.println("Attack: "+c1.getattack());
        if (c1.getweapon() == null){
        System.out.println("Weapon: None");
        }
        else {
        System.out.println("Weapon: "+c1.getweapon());        
        }        
        if (c1.getaccess() == null){
        System.out.println("Accessory: None");
        }
        else {
        System.out.println("Accessory: "+c1.getweapon());        
        }
    System.out.println("====================================");
    System.out.println("What do you want to do?");
    System.out.println("1. Rename Character\n2. Equip Weapon\n3. Equip Accessory\n0. Return");
    System.out.print("Input: ");
    int input2 = s.nextInt();
    while (input2 < 0 || input2 > 3){
        System.out.print("Input invalid! Input:");
        input2 = s.nextInt();
    }
        if (input2 == 1){
        System.out.println("You cannot rename Yobel!");
        break;
        }
        else if (input2 == 2){
        
        }
        else if (input2 == 3){
        
        }
        else if (input2 == 0){
        System.out.println("Returning to menu...");
        break;
        }
    }
    else if (input1 == 2){
    System.out.println("======== "+c2.getname()+"'s STATS ========");
    System.out.println("Health: "+c2.gethealth());
    System.out.println("Attack: "+c2.getattack());
        if (c2.getweapon() == null){
        System.out.println("Weapon: None");
        }
        else {
        System.out.println("Weapon: "+c2.getweapon());        
        }
        if (c2.getaccess() == null){
        System.out.println("Accessory: None");
        }
        else {
        System.out.println("Accessory: "+c2.getweapon());        
        }      
    }
    else if (input1 == 0){
    System.out.println("Returning to menu....");
    break;
    }
    break;
    
    default:
    System.out.println("Input not available!");
    break;
    }
    } //while true
    }
}
