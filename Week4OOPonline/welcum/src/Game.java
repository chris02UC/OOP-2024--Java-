/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsitter2022;

import java.util.Scanner;

/**
 *
 * @author caeciliacitra
 */
public class Game {

    private Player p;
    LoginRegister lr;

    public Game(Player player, LoginRegister parent) {
        p = player;
        lr = parent;
        
        System.out.println("Money : " + p.getMoney());
        System.out.println("Food Stock  : " + p.getFoodStock());
        //Scanner s = new Scanner(System.in);
        //System.out.println("Your Username : ");
        //String name = s.next();
        //p.setUsername(name);
    }

    public void playGame() {
        int pilihan = 0;
        Dog curPet = null;
        while (pilihan <= 9) {
            //Tampilkan menu
            System.out.println("WHAT TO DO :");
            System.out.println("1. Buy a Pet");
            System.out.println("2. Play with Pet");
            System.out.println("3. Train Pet");
            System.out.println("4. Feed Pet");
            System.out.println("5. Put Pet to Bath");
            System.out.println("6. Put Pet to Sleep");
            System.out.println("7. Show Pet Status");
            System.out.println("8. Sell Pet");
            System.out.println("9. Select PEt");
            System.out.println("10. Logout");
            System.out.println("Choose : ");
            Scanner s = new Scanner(System.in);
            pilihan = s.nextInt();

            //Suruh pet dari player untuk melakukan aktivitas yg dipilih
            switch (pilihan) {
                case 1:
                    //1. Buat objek Dog baru
                    Dog newDog = new Dog();
                    System.out.println("Name your pet");
                    String dogName = s.nextLine() + s.next();
                    newDog.setName(dogName);
                    //2. Assign objek Dog baru menjadi pet-nya Pkayer
                    p.addDog(newDog);
                    break;
                case 2:
                    //cek apakah player punya pet
                    if (curPet != null) {
                        curPet.play();
                    } else {
                        System.out.println("You must selet a pet first!");
                    }
                    break;
                case 3:
                    //cek apakah player punya pet
                    if (curPet != null) {
                        curPet.train();
                    } else {
                        System.out.println("You must selet a pet first!");
                    }
                    break;
                case 4:
                    //cek apakah player punya pet
                    if (curPet != null) //cek apakah food stock player mencukup
                    {
                        if (p.getFoodStock() >= curPet.getFoodAmount()) {
                            int food = curPet.eat();
                            p.foodStock(food);
                        } else {
                            System.out.println("You don't have enough food to feed your pet");
                        }
                    } else {
                        System.out.println("You must selet a pet first!");
                    }
                    break;
                case 5:
                    //cek apakah player punya pet
                    if (curPet != null) {
                        curPet.bath();
                    } else {
                        System.out.println("You must selet a pet first!");
                    }
                    break;
                case 6:
                    //cek apakah player punya pet
                    if (curPet != null) {
                        curPet.sleep();
                    } else {
                        System.out.println("You must selet a pet first!");
                    }
                    break;
                case 7:
                    //Dog d = p.getPet;
                    if (curPet == null) {
                        System.out.println("You must selet a pet first!");
                    } else {
                        System.out.println("Your Pet Status");
                        System.out.println("Name        : " + curPet.getName());
                        System.out.println("Age         : " + curPet.getAge());
                        System.out.println("Health      : " + curPet.getHealth());
                        System.out.println("Happiness   : " + curPet.getHappiness());
                        System.out.println("Intelligence: " + curPet.getIntelligence());
                        System.out.println("Cleanliess  : " + curPet.getCleniness());
                        System.out.println("Fullness    : " + curPet.getFullness());
                        System.out.println("Price       : " + curPet.getPrice());
                    }
                    break;
                case 8:
                    if (curPet != null) {
                        p.sellDog(curPet);
                    } else {
                        System.out.println("You must selet a pet first!");
                    }
                    break;
                case 9:
                    if (p.getAllPetNames().length > 0) {
                        while(curPet==null){
                        System.out.println("Select a Pet You Wanna Play with :");
                        int no = 1;
                        for (String dogname : p.getAllPetNames()) {
                            System.out.println(no + ". " + dogname);
                            no++;
                        }
                        System.out.println("Type the name you choose:");
                        String name = s.nextLine() + s.next();
                        
                        curPet = p.getPet(name);
                        if(curPet == null)
                                System.out.println("No pet has that name");
                        }
                    } else {
                        System.out.println("You don't have a pet. Biy a pet first !");
                    }
                    break;

                case 10:
                    //LoginRegister lr= new LoginRegister();
                    lr.menu();
            }

            //cek pet hidup/mati
            if (curPet != null) {
                if (curPet.isDie()) {
                    p.dogDies(curPet);
                    curPet = null;
                }
            }
        }
    }

}
