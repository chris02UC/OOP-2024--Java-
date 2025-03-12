package SoalKaryna;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Menu {
    private Account a;
    private Banks bks;

    private ArrayList<Integer> account_ids = new ArrayList<Integer>();
    Banks CBA = new Banks("CBA", 2000);
    Banks DQ = new Banks("DuoQian", 4000);
    Banks PRR = new Banks("Pororo", 10000);
    int toprintbank;

    public void runapp(Account a) {
    Scanner s = new Scanner(System.in);
    while (true){
    System.out.println("\n");
    Transaction t = new Transaction();
        if (toprintbank == 1){
        System.out.println("Bank CBA");
        bks = CBA;
        } else if (toprintbank == 2){
        System.out.println("Bank DuoQian");
        bks = DQ;
        }else if (toprintbank == 3){
        System.out.println("Bank Pororo");
        bks = PRR;
        }
        System.out.println("---------------------------------");
        System.out.println(a.getname()+", your current Balance is "+a.getbalance());
        System.out.println("-- What would you like to do today?");
        System.out.println("1. Deposit Money\n2. Withdraw Cash\n3. Transfer\n4. View all Transactions\n5. View Details\n0. Go Back");
        System.out.print("Choice -- ");
        String pilihrunapp = s.next();
        switch(pilihrunapp){
        case "1" :
        System.out.print("How much would you like to deposit? : ");
        int deposit = s.nextInt();
            while (deposit <= 0){
            System.out.println("Cannot deposit 0 or negative money!");
            System.out.print("How much would you like to deposit? : ");
            deposit = s.nextInt();
            }
        System.out.print("PIN - ");
        String inputpin = s.next();
        System.out.println(a.getPIN());
            while (!inputpin.equalsIgnoreCase(a.getPIN())){
            System.out.print("Incorrect PIN! PIN - ");
            inputpin = s.next();
            }
        System.out.println("...");
        a.depositmoney(deposit);
        t.setamount(deposit);
        t.setbanksender(bks);
        t.settotal_amount(a.getbalance());
        t.settype("Deposit");
        a.addhistory(t);
        System.out.println("Money deposited successfully!");
        break;

        case "2" :
        System.out.println("Total Balance : "+a.getbalance());
        System.out.println("How much would you like to withdraw?");
        int withdraw = s.nextInt();
        while (withdraw <= 0){
        System.out.println("Cannot withdraw 0 or negative money!");
        System.out.print("How much would you like to withdraw? : ");
        withdraw = s.nextInt();
        }
        if (withdraw > a.getbalance()){
        System.out.println("Your money is not enough!");
        break;
        }
        System.out.print("PIN - ");
        String inputpin2 = s.next();
        System.out.println(a.getPIN());
            while (!inputpin2.equalsIgnoreCase(a.getPIN())){
            System.out.print("Incorrect PIN! PIN - ");
            inputpin2 = s.next();
            }
        System.out.println("...");
        a.withdrawmoney(withdraw);
        System.out.println("Money withdrawn successfully!");
        break;

        case "3" : 
        System.out.println("which bank would you like to deposit to?");
            if (toprintbank == 1){
            System.out.println("1. CBA-- Fee : 0\n2. DuoQian-- Fee : 4000\n3. Pororo-- Fee : 10000");
            } else if (toprintbank == 2){
            System.out.println("1. CBA-- Fee : 2000\n2. DuoQian-- Fee : 0\n3. Pororo-- Fee : 10000");
            } else if (toprintbank == 3){
            System.out.println("1. CBA-- Fee : 2000\n2. DuoQian-- Fee : 4000\n3. Pororo-- Fee : 0");
            }
        System.out.print("Choice: --");
        int input3 = s.nextInt();
            while (input3 < 1 || input3 > 3){
            System.out.println("Input invalid! Choice: --");
            input3 = s.nextInt();
            }
            if (toprintbank == 1){ // if it is CBA
                if (input3 == 1){
                if (CBA.getaccount().size() == 0) {
                    System.out.println("There aren't any accounts to transfer to");
                    break;
                } else {
                    for (int z = 0; z < CBA.getaccount().size(); z++) {
                        System.out.println((z + 1) + ". " + CBA.getaccount().get(z).getname()+" -- ID."+CBA.getaccount().get(z).getaccount_id());
                    }
                }
            System.out.print("Choice -- ");
            int choicetf = s.nextInt();
                while (choicetf < 1 || choicetf > CBA.getaccount().size()){
                System.out.print("Input not available! Choice -- ");
                choicetf = s.nextInt();
                }
            if (CBA.getaccount().get(choicetf-1) == a) {
            System.out.println("You cannot transfer to yourself !");
            break;
            } else{
                System.out.println("Transfer amount: ");
                int tfamount = s.nextInt();
                    while (tfamount <= 0){
                        System.out.println("Amount cannot be 0 or less than 0! Transfer amount: ");
                        tfamount = s.nextInt();
                    }
                System.out.print("Add Description: ");
                String adddesc = s.next();
                a.withdrawmoney(tfamount);
                CBA.getaccount().get(choicetf-1).depositmoney(tfamount);
                // a.addhistory(t);
            }
            }
            if (input3 == 2){
                if (DQ.getaccount().size() == 0) {
                    System.out.println("There aren't any accounts to transfer to");
                    break;
                } else {
                    for (int z = 0; z < DQ.getaccount().size(); z++) {
                        System.out.println((z + 1) + ". " + DQ.getaccount().get(z).getname()+" -- ID."+DQ.getaccount().get(z).getaccount_id());
                    }
                }
            System.out.print("Choice -- ");
            int choicetf = s.nextInt();
                while (choicetf < 1 || choicetf > DQ.getaccount().size()){
                System.out.print("Input not available! Choice -- ");
                choicetf = s.nextInt();
                }
            if (DQ.getaccount().get(choicetf-1) == a) {
            System.out.println("You cannot transfer to yourself !");
            break;
            } else{
                System.out.println("Transfer amount: ");
                int tfamount = s.nextInt();
                    while (tfamount <=0){
                        System.out.println("Amount cannot be 0 or less than 0! Transfer amount: ");
                        tfamount = s.nextInt();
                    }
                System.out.print("Add Description: ");
                String adddesc = s.next();
                a.withdrawmoney(tfamount+4000);
                DQ.getaccount().get(choicetf-1).depositmoney(tfamount);
                // Transaction t = new Transaction(a, DQ.getaccount().get(choicetf-1), CBA, DQ, tfamount, tfamount+4000, adddesc);
                // a.addhistory(t);
            }
            }
            if (input3 == 3){
                if (PRR.getaccount().size() == 0) {
                    System.out.println("There aren't any accounts to transfer to");
                    break;
                } else {
                    for (int z = 0; z < PRR.getaccount().size(); z++) {
                        System.out.println((z + 1) + ". " + PRR.getaccount().get(z).getname()+" -- ID."+PRR.getaccount().get(z).getaccount_id());
                    }
                }
            System.out.print("Choice -- ");
            int choicetf = s.nextInt();
                while (choicetf < 1 || choicetf > PRR.getaccount().size()){
                System.out.print("Input not available! Choice -- ");
                choicetf = s.nextInt();
                }
            if (PRR.getaccount().get(choicetf-1) == a) {
            System.out.println("You cannot transfer to yourself !");
            break;
            } else{
                System.out.println("Transfer amount: ");
                int tfamount = s.nextInt();
                    while (tfamount <=0){
                        System.out.println("Amount cannot be 0 or less than 0! Transfer amount: ");
                        tfamount = s.nextInt();
                    }
                System.out.print("Add Description: ");
                String adddesc = s.next();
                a.withdrawmoney(tfamount+10000);
                PRR.getaccount().get(choicetf-1).depositmoney(tfamount);
                // Transaction t = new Transaction(a, PRR.getaccount().get(choicetf-1), CBA, PRR, tfamount, tfamount+10000, adddesc);
                // a.addhistory(t);
            }
            }
            } else if (toprintbank == 2){
                if (input3 == 1){
                    if (CBA.getaccount().size() == 0) {
                        System.out.println("There aren't any accounts to transfer to");
                        break;
                    } else {
                        for (int z = 0; z < CBA.getaccount().size(); z++) {
                            System.out.println((z + 1) + ". " + CBA.getaccount().get(z).getname()+" -- ID."+CBA.getaccount().get(z).getaccount_id());
                        }
                    }
                System.out.print("Choice -- ");
                int choicetf = s.nextInt();
                    while (choicetf < 1 || choicetf > CBA.getaccount().size()){
                    System.out.print("Input not available! Choice -- ");
                    choicetf = s.nextInt();
                    }
                if (CBA.getaccount().get(choicetf-1) == a) {
                System.out.println("You cannot transfer to yourself !");
                break;
                } else{
                    System.out.println("Transfer amount: ");
                    int tfamount = s.nextInt();
                        while (tfamount <=0){
                            System.out.println("Amount cannot be 0 or less than 0! Transfer amount: ");
                            tfamount = s.nextInt();
                        }
                    System.out.print("Add Description: ");
                    String adddesc = s.next();
                    a.withdrawmoney(tfamount+2000);
                    CBA.getaccount().get(choicetf-1).depositmoney(tfamount);
                    // Transaction t = new Transaction(a, CBA.getaccount().get(choicetf-1), CBA, DQ, tfamount, tfamount+2000, adddesc);
                    // a.addhistory(t);
                }
                }
                if (input3 == 2){
                    if (DQ.getaccount().size() == 0) {
                        System.out.println("There aren't any accounts to transfer to");
                        break;
                    } else {
                        for (int z = 0; z < DQ.getaccount().size(); z++) {
                            System.out.println((z + 1) + ". " + DQ.getaccount().get(z).getname()+" -- ID."+DQ.getaccount().get(z).getaccount_id());
                        }
                    }
                System.out.print("Choice -- ");
                int choicetf = s.nextInt();
                    while (choicetf < 1 || choicetf > DQ.getaccount().size()){
                    System.out.print("Input not available! Choice -- ");
                    choicetf = s.nextInt();
                    }
                if (DQ.getaccount().get(choicetf-1) == a) {
                System.out.println("You cannot transfer to yourself !");
                break;
                } else{
                    System.out.println("Transfer amount: ");
                    int tfamount = s.nextInt();
                        while (tfamount <=0){
                            System.out.println("Amount cannot be 0 or less than 0! Transfer amount: ");
                            tfamount = s.nextInt();
                        }
                    System.out.print("Add Description: ");
                    String adddesc = s.next();
                    a.withdrawmoney(tfamount);
                    DQ.getaccount().get(choicetf-1).depositmoney(tfamount);
                    // Transaction t = new Transaction(a, DQ.getaccount().get(choicetf-1), DQ, DQ, tfamount, tfamount, adddesc);
                    // a.addhistory(t);
                }
                }
                if (input3 == 3){
                    if (PRR.getaccount().size() == 0) {
                        System.out.println("There aren't any accounts to transfer to");
                        break;
                    } else {
                        for (int z = 0; z < PRR.getaccount().size(); z++) {
                            System.out.println((z + 1) + ". " + PRR.getaccount().get(z).getname()+" -- ID."+PRR.getaccount().get(z).getaccount_id());
                        }
                    }
                System.out.print("Choice -- ");
                int choicetf = s.nextInt();
                    while (choicetf < 1 || choicetf > PRR.getaccount().size()){
                    System.out.print("Input not available! Choice -- ");
                    choicetf = s.nextInt();
                    }
                if (PRR.getaccount().get(choicetf-1) == a) {
                System.out.println("You cannot transfer to yourself !");
                break;
                } else{
                    System.out.println("Transfer amount: ");
                    int tfamount = s.nextInt();
                        while (tfamount <=0){
                            System.out.println("Amount cannot be 0 or less than 0! Transfer amount: ");
                            tfamount = s.nextInt();
                        }
                    System.out.print("Add Description: ");
                    String adddesc = s.next();
                    a.withdrawmoney(tfamount+10000);
                    PRR.getaccount().get(choicetf-1).depositmoney(tfamount);
                    // Transaction t = new Transaction(a, PRR.getaccount().get(choicetf-1), DQ, PRR, tfamount, tfamount+10000, adddesc);
                    // a.addhistory(t);
                }
                }             
            } else if (toprintbank == 3){
                if (input3 == 1){
                    if (CBA.getaccount().size() == 0) {
                        System.out.println("There aren't any accounts to transfer to");
                        break;
                    } else {
                        for (int z = 0; z < CBA.getaccount().size(); z++) {
                            System.out.println((z + 1) + ". " + CBA.getaccount().get(z).getname()+" -- ID."+CBA.getaccount().get(z).getaccount_id());
                        }
                    }
                System.out.print("Choice -- ");
                int choicetf = s.nextInt();
                    while (choicetf < 1 || choicetf > CBA.getaccount().size()){
                    System.out.print("Input not available! Choice -- ");
                    choicetf = s.nextInt();
                    }
                if (CBA.getaccount().get(choicetf-1) == a) {
                System.out.println("You cannot transfer to yourself !");
                break;
                } else{
                    System.out.println("Transfer amount: ");
                    int tfamount = s.nextInt();
                        while (tfamount <=0){
                            System.out.println("Amount cannot be 0 or less than 0! Transfer amount: ");
                            tfamount = s.nextInt();
                        }
                    System.out.print("Add Description: ");
                    String adddesc = s.next();
                    a.withdrawmoney(tfamount+2000);
                    CBA.getaccount().get(choicetf-1).depositmoney(tfamount);
                    // Transaction t = new Transaction(a, CBA.getaccount().get(choicetf-1), PRR, CBA, tfamount, tfamount+2000, adddesc);
                    // a.addhistory(t);
                }
                }
                if (input3 == 2){
                    if (DQ.getaccount().size() == 0) {
                        System.out.println("There aren't any accounts to transfer to");
                        break;
                    } else {
                        for (int z = 0; z < DQ.getaccount().size(); z++) {
                            System.out.println((z + 1) + ". " + DQ.getaccount().get(z).getname()+" -- ID."+DQ.getaccount().get(z).getaccount_id());
                        }
                    }
                System.out.print("Choice -- ");
                int choicetf = s.nextInt();
                    while (choicetf < 1 || choicetf > DQ.getaccount().size()){
                    System.out.print("Input not available! Choice -- ");
                    choicetf = s.nextInt();
                    }
                if (DQ.getaccount().get(choicetf-1) == a) {
                System.out.println("You cannot transfer to yourself !");
                break;
                } else{
                    System.out.println("Transfer amount: ");
                    int tfamount = s.nextInt();
                        while (tfamount <=0){
                            System.out.println("Amount cannot be 0 or less than 0! Transfer amount: ");
                            tfamount = s.nextInt();
                        }
                    System.out.print("Add Description: ");
                    String adddesc = s.next();
                    a.withdrawmoney(tfamount+4000);
                    DQ.getaccount().get(choicetf-1).depositmoney(tfamount);
                    // // Transaction t = new Transaction(a, DQ.getaccount().get(choicetf-1), PRR, DQ, tfamount, tfamount+4000, adddesc);
                    // a.addhistory(t);
                }
                }
                if (input3 == 3){
                    if (PRR.getaccount().size() == 0) {
                        System.out.println("There aren't any accounts to transfer to");
                        break;
                    } else {
                        for (int z = 0; z < PRR.getaccount().size(); z++) {
                            System.out.println((z + 1) + ". " + PRR.getaccount().get(z).getname()+" -- ID."+PRR.getaccount().get(z).getaccount_id());
                        }
                    }
                System.out.print("Choice -- ");
                int choicetf = s.nextInt();
                    while (choicetf < 1 || choicetf > PRR.getaccount().size()){
                    System.out.print("Input not available! Choice -- ");
                    choicetf = s.nextInt();
                    }
                if (PRR.getaccount().get(choicetf-1) == a) {
                System.out.println("You cannot transfer to yourself !");
                break;
                } else{
                    System.out.println("Transfer amount: ");
                    int tfamount = s.nextInt();
                        while (tfamount <=0){
                            System.out.println("Amount cannot be 0 or less than 0! Transfer amount: ");
                            tfamount = s.nextInt();
                        }
                    System.out.print("Add Description: ");
                    String adddesc = s.next();
                    a.withdrawmoney(tfamount);
                    PRR.getaccount().get(choicetf-1).depositmoney(tfamount);
                    // Transaction t = new Transaction(a, PRR.getaccount().get(choicetf-1), PRR, PRR, tfamount, tfamount, adddesc);
                    // a.addhistory(t);
                }
                }                   
            }
        break;

        case "4" :
        for (int y = 0; y < a.gethistory().size(); y++) {
         //   System.out.println((y+1)+a.gethistory());
        }
        break;
        
        case "5" :
        System.out.println("Hello "+a.getname());
        System.out.println("Telephone Number: "+a.gettphonenumber());
        System.out.println("Current balance: "+a.getbalance());
        System.out.println("1. Edit Telephone number\n2. Edit PIN");
        int case5input = s.nextInt();
            if (case5input == 1){
            System.out.println("Enter new Telephone number: ");
            String newtp = s.next();
            System.out.println("...");
            a.settphonenumber(newtp);
            System.out.println("Telephone number Updated Successfully!");
            break;
            } else if (case5input == 2){
            System.out.print("Please Confirm your current PIN -- ");
            String case5inputPIN = s.next();
            while (!case5inputPIN.equalsIgnoreCase(a.getPIN())){
                System.out.print("Incorrect PIN! PIN - ");
                case5inputPIN = s.next();
                }
            System.out.println("Enter new PIN: ");
            String newpin = s.next();
            a.setPIN(newpin);
            System.out.println("...\nPIN Updated Successfully!");
            }
        break;

        case "0" :
        menumain();
        break;

        default:
        System.out.println("Input not available!");
        break;
        }
        }
    }

    public void menumain() {
        Scanner s = new Scanner(System.in);
        Account curracc = null;
        while (true) {
            System.out.println("---------------------------------\nWelcome to the bank of all Banks!");
            System.out.println("-- Choose a bank");
            System.out.println("1. CBA");
            System.out.println("2. DuoQian");
            System.out.println("3. Pororo");
            System.out.println("0. Quit");
            System.out.print("Choice --  ");
            int choose = s.nextInt();
            while (choose < 0 || choose > 3) {
                System.out.print("Input not valid! Choice -- ");
                choose = s.nextInt();
            }
            if (choose == 1) {
                curracc = menuCBA();
            } else if (choose == 2) {
                curracc = menuDQ();
            } else if (choose == 3) {
                // curracc = menuPRR();
            } else if (choose == 0) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            if (curracc != null) {
                runapp(curracc);
            }
        }
    }

    public Account menuCBA() {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        Account currentuser = null;
        while (currentuser == null) {
            System.out.println("\nBank CBA");
            System.out.println("---------------------------------");
            if (CBA.getaccount().size() == 0) {
                System.out.println("----- no accounts registered -----");
            } else {
                for (int a = 0; a < CBA.getaccount().size(); a++) {
                    System.out.println((a + 1) + ". " + CBA.getaccount().get(a).getname()+" -- ID."+CBA.getaccount().get(a).getaccount_id());
                }
            }
            System.out.println("---------------------------------");
            System.out.println("100. Create New Account\n0. Go Back");
            System.out.print("Choice-- ");
            int menubacc = s.nextInt();
            while ((menubacc < 0 || menubacc > CBA.getaccount().size()) && menubacc != 100) {
                System.out.print("Input not valid! Choice -- ");
                menubacc = s.nextInt();
            }
            if (menubacc == 100) {
                System.out.println("-- Creating New Account");
                System.out.print("Enter Name : ");
                String inputname = s.next();
                System.out.print("Enter your Telephone Number : ");
                String inputtele = s.next();
                System.out.print("Enter Initial Deposit : ");
                int inputintdep = s.nextInt();
                System.out.print("Enter PIN : ");
                String inputPIN = s.next();
                while (!inputPIN.matches("[0-9]+") || inputPIN.length() != 6) {
                    System.out.println("Pin must be numbers only and contains 6 digits!");
                    System.out.print("Enter PIN : ");
                    inputPIN = s.next();
                }
                Account a = new Account();
                a.setname(inputname);
                a.settphonenumber(inputtele);
                a.setbalance(inputintdep);
                a.setPIN(inputPIN);
                int generateid = r.nextInt(10000, 100000);
                int repeatloop = 0;
                while (repeatloop != 1) {
                    int checksame = 0;
                    for (int b = 0; b < account_ids.size(); b++) {
                        generateid = r.nextInt(10000, 100000);
                        if (account_ids.get(b) == generateid) {
                            checksame = 1;
                        }
                        if (checksame == 1) {
                            repeatloop = 0;
                            break;
                        }
                    }
                    if (checksame == 0) {
                        break;
                    }
                }
                a.setaccount_id(generateid);
                CBA.addaccount(a);
                account_ids.add(generateid);
                toprintbank = 1;
                return a;
            } else if (menubacc == 0) {
                menumain();
            } else {
                while (true){
                System.out.print("Input PIN -- ");
                String checkPIN = s.next();
                toprintbank = 1;
                if (CBA.getaccount().get(menubacc - 1).getPIN().equals(checkPIN)) {
                    a = CBA.getaccount().get(menubacc - 1);
                    return a;
                }
                
                System.out.println("Incorrect PIN!");
                System.out.print("Try Again (Y/N):  ");
                    String yesno = s.next();
                    while (!yesno.equalsIgnoreCase("y") && !yesno.equalsIgnoreCase("n")){
                    System.out.print("Choices are only Y/N! Try Again (Y/N):  ");
                    yesno = s.next();
                    }
                    if (yesno.equalsIgnoreCase("y")){
                    }
                    else if (yesno.equalsIgnoreCase("n")){
                    break;
                    }
                }
            }
        }
        return null;
    }

    public Account menuDQ() {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        Account currentuser = null;
        while (currentuser == null) {
        System.out.println("\nBank DuoQian");
            System.out.println("---------------------------------");
            if (DQ.getaccount().size() == 0) {
                System.out.println("----- no accounts registered -----");
            } else {
                for (int a = 0; a < DQ.getaccount().size(); a++) {
                    System.out.println((a + 1) + ". " + DQ.getaccount().get(a).getname()+" -- ID."+DQ.getaccount().get(a).getaccount_id());
                }
            }
            System.out.println("---------------------------------");
            System.out.println("100. Create New Account\n0. Go Back");
            System.out.print("Choice-- ");
            int menubacc = s.nextInt();
            while ((menubacc < 0 || menubacc > DQ.getaccount().size()) && menubacc != 100) {
                System.out.print("Input not valid! Choice -- ");
                menubacc = s.nextInt();
            }
            if (menubacc == 100) {
                System.out.println("-- Creating New Account");
                System.out.print("Enter Name : ");
                String inputname = s.next();
                System.out.print("Enter your Telephone Number : ");
                String inputtele = s.next();
                System.out.print("Enter Initial Deposit : ");
                int inputintdep = s.nextInt();
                System.out.print("Enter PIN : ");
                String inputPIN = s.next();
                while (!inputPIN.matches("[0-9]+") || inputPIN.length() != 6) {
                    System.out.println("Pin must be numbers only and contains 6 digits!");
                    System.out.print("Enter PIN : ");
                    inputPIN = s.next();
                }
                Account a = new Account();
                a.setname(inputname);
                a.settphonenumber(inputtele);
                a.setbalance(inputintdep);
                a.setPIN(inputPIN);
                int generateid = r.nextInt(10000, 100000);
                int repeatloop = 0;
                while (repeatloop != 1) {
                    int checksame = 0;
                    for (int b = 0; b < account_ids.size(); b++) {
                        generateid = r.nextInt(10000, 100000);
                        if (account_ids.get(b) == generateid) {
                            checksame = 1;
                        }
                        if (checksame == 1) {
                            repeatloop = 0;
                            break;
                        }
                    }
                    if (checksame == 0) {
                        break;
                    }
                }
                toprintbank = 2;
                a.setaccount_id(generateid);
                account_ids.add(generateid);
                DQ.addaccount(a);
                return a;
            } else if (menubacc == 0) {
                menumain();
            } else {
                while (true){
                System.out.print("Input PIN -- ");
                String checkPIN = s.next();
                toprintbank = 2;
                if (DQ.getaccount().get(menubacc - 1).getPIN().equals(checkPIN)) {
                    a = DQ.getaccount().get(menubacc - 1);
                    return a;
                }
                
                System.out.println("Incorrect PIN!");
                System.out.print("Try Again (Y/N):  ");
                    String yesno = s.next();
                    while (!yesno.equalsIgnoreCase("y") && !yesno.equalsIgnoreCase("n")){
                    System.out.print("Choices are only Y/N! Try Again (Y/N):  ");
                    yesno = s.next();
                    }
                    if (yesno.equalsIgnoreCase("y")){
                    }
                    else if (yesno.equalsIgnoreCase("n")){
                    break;
                    }
                }
            }
        }
        return null;
    }

    public Account menuPRR() {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        Account currentuser = null;
        while (currentuser == null) {
            System.out.println("\nBank Pororo");
            System.out.println("---------------------------------");
            if (PRR.getaccount().size() == 0) {
                System.out.println("----- no accounts registered -----");
            } else {
                for (int a = 0; a < PRR.getaccount().size(); a++) {
                    System.out.println((a + 1) + ". " + PRR.getaccount().get(a).getname()+" -- ID."+PRR.getaccount().get(a).getaccount_id());
                }
            }
            System.out.println("---------------------------------");
            System.out.println("100. Create New Account\n0. Go Back");
            System.out.print("Choice-- ");
            int menubacc = s.nextInt();
            while ((menubacc < 0 || menubacc > PRR.getaccount().size()) && menubacc != 100) {
                System.out.print("Input not valid! Choice -- ");
                menubacc = s.nextInt();
            }
            if (menubacc == 100) {
                System.out.println("-- Creating New Account");
                System.out.print("Enter Name : ");
                String inputname = s.next();
                System.out.print("Enter your Telephone Number : ");
                String inputtele = s.next();
                System.out.print("Enter Initial Deposit : ");
                int inputintdep = s.nextInt();
                System.out.print("Enter PIN : ");
                String inputPIN = s.next();
                while (!inputPIN.matches("[0-9]+") || inputPIN.length() != 6) {
                    System.out.println("Pin must be numbers only and contains 6 digits!");
                    System.out.print("Enter PIN : ");
                    inputPIN = s.next();
                }
                Account a = new Account();
                a.setname(inputname);
                a.settphonenumber(inputtele);
                a.setbalance(inputintdep);
                a.setPIN(inputPIN);
                int generateid = r.nextInt(10000, 100000);
                int repeatloop = 0;
                while (repeatloop != 1) {
                    int checksame = 0;
                    for (int b = 0; b < account_ids.size(); b++) {
                        generateid = r.nextInt(10000, 100000);
                        if (account_ids.get(b) == generateid) {
                            checksame = 1;
                        }
                        if (checksame == 1) {
                            repeatloop = 0;
                            break;
                        }
                    }
                    if (checksame == 0) {
                        break;
                    }
                }
                toprintbank = 3;
                a.setaccount_id(generateid);
                account_ids.add(generateid);
                PRR.addaccount(a);
                return a;
            } else if (menubacc == 0) {
                menumain();
            } else {
                while (true){
                System.out.print("Input PIN -- ");
                String checkPIN = s.next();
                toprintbank = 3;
                if (PRR.getaccount().get(menubacc - 1).getPIN().equals(checkPIN)) {
                    a = PRR.getaccount().get(menubacc - 1);
                    return a;
                }
                
                System.out.println("Incorrect PIN!");
                System.out.print("Try Again (Y/N):  ");
                    String yesno = s.next();
                    while (!yesno.equalsIgnoreCase("y") && !yesno.equalsIgnoreCase("n")){
                    System.out.print("Choices are only Y/N! Try Again (Y/N):  ");
                    yesno = s.next();
                    }
                    if (yesno.equalsIgnoreCase("y")){
                    }
                    else if (yesno.equalsIgnoreCase("n")){
                    break;
                    }
                }
            }
        }
        return null;
    }
}
