/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsitter2022;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author caeciliacitra
 */
public class LoginRegister {

    private ArrayList<Player> playerList = new ArrayList<Player>();

    public LoginRegister() {
        Player p = new Player();
        p.setUsername("citra");
        p.setPassword("1234");
        playerList.add(p);

        p = new Player();
        p.setUsername("admin");
        p.setPassword("admin");
        playerList.add(p);

        menu();
    }

    public void menu() {
        //Mau Login atau Register
        Scanner s = new Scanner(System.in);
        Player curPlayer = null;
        while (curPlayer == null) {
            System.out.println("Menu");
            System.out.println("1. Login");
            System.out.println("2. Register");
            int choose = s.nextInt();
            if (choose == 1) {
                curPlayer = login();
            } else if (choose == 2) {
                curPlayer = register();
            }
            if (curPlayer != null) {
                Game game = new Game(curPlayer, this);
                game.playGame();
            }
        }
    }

    public Player login() {
        String tryagain = "";
        while (!tryagain.equalsIgnoreCase("n")) {
            //Minta username dan password
            Scanner s = new Scanner(System.in);
            System.out.println("Please Login");
            System.out.println("Username :");
            String uname = s.next();
            System.out.println("Password : ");
            String pwd = s.next();

            //Cocokkan username dan password dengan yg ada di list
            for (Player p : playerList) {
                if (p.getUsername().equals(uname)
                        && p.getPassword().equals(pwd)) {
                    return p;
                }
            }
            //Berikan pesan error
            System.out.println("Userame or Password don't match ! ");
            System.out.println("Try Again (Y/N) ? ");
            tryagain = s.next();
        }
        return null;
    }

    public Player register() {
        //Minta username dan password
        Scanner s = new Scanner(System.in);
        System.out.println("Please Register");
        System.out.println("Username :");
        String uname = s.next();
        System.out.println("Password : ");
        String pwd = s.next();

        //Buat objek player baru
        Player p = new Player();
        p.setUsername(uname);
        p.setPassword(pwd);
        System.out.println("New player has successfully been registered");
        
        return p;
    }
}
