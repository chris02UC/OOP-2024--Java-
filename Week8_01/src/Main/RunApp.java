package Main;
import java.util.Scanner;
import java.util.ArrayList;

import User.Cust;
import User.Dev;
import User.UserAbs;
import Properti.Properti;
import Properti.Apartment;
import Properti.Rumah;
import Properti.Villa;

public class RunApp {
private UserAbs ua;
private ArrayList<UserAbs>userlist = new ArrayList<UserAbs>();
private ArrayList<Properti>marketplace = new ArrayList<Properti>();
int donce = 0;

public void runapp(){
    Scanner s = new Scanner(System.in);
    if (ua instanceof Cust){
        while (true){
        System.out.println("\nHello, "+ua.getUsername());
        System.out.println("What would you like to do?");
        System.out.println("1. Check my properties\n2. Buy Property\n3. Sell Property\n4. Logout");
        System.out.print("Choose : ");
        String menucust = s.next()+s.nextLine();
        switch (menucust){
            case "1":
            System.out.println("\n===== Your Properties =====");
                if (ua.getProperti().size() == 0){
                    System.out.println("You have no properties!");
                } else {
                    for (int a = 0; a < ua.getProperti().size(); a++){
                        if (ua.getProperti().get(a) instanceof Rumah){
                            System.out.println((a+1)+". ");
                            System.out.println("Type : House");
                            System.out.println("Cluster Name : "+ua.getProperti().get(a).getnamaCluster());
                            System.out.println("Size : "+ua.getProperti().get(a).getluasBangunan()+" m\u00B2");
                            System.out.println("Price : $"+ua.getProperti().get(a).getharga());
                            System.out.println("Facilities : "+ua.getProperti().get(a).getfasilitas());
                            System.out.println("----------------------------------------------");
                        }
                        else if (ua.getProperti().get(a) instanceof Apartment){
                            System.out.println((a+1)+". ");
                            System.out.println("Type : Apartment");
                            System.out.println("Cluster Name : "+ua.getProperti().get(a).getnamaCluster());
                            System.out.println("Size : "+ua.getProperti().get(a).getluasBangunan()+" m\u00B2");
                            System.out.println("Price : $"+ua.getProperti().get(a).getharga());
                            System.out.println("Facilities : "+ua.getProperti().get(a).getfasilitas());
                            System.out.println("----------------------------------------------");
                        }
                        else if (ua.getProperti().get(a) instanceof Villa){
                            System.out.println((a+1)+". ");
                            System.out.println("Type : Villa");
                            System.out.println("Cluster Name : "+ua.getProperti().get(a).getnamaCluster());
                            System.out.println("Size : "+ua.getProperti().get(a).getluasBangunan()+" m\u00B2");
                            System.out.println("Price : $"+ua.getProperti().get(a).getharga());
                            System.out.println("Facilities : "+ua.getProperti().get(a).getfasilitas());
                            System.out.println("----------------------------------------------");
                        }
                    }
                }
            break;

            case "2":
            for (int a = 0; a < marketplace.size(); a++){
                if (marketplace.get(a) instanceof Rumah){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : House");
                    System.out.println("Cluster Name : "+marketplace.get(a).getnamaCluster());
                    System.out.println("Size : "+marketplace.get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+marketplace.get(a).getharga());
                    System.out.println("Facilities : "+marketplace.get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
                else if (marketplace.get(a) instanceof Apartment){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : Apartment");
                    System.out.println("Cluster Name : "+marketplace.get(a).getnamaCluster());
                    System.out.println("Size : "+marketplace.get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+marketplace.get(a).getharga());
                    System.out.println("Facilities : "+marketplace.get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
                else if (marketplace.get(a) instanceof Villa){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : Villa");
                    System.out.println("Cluster Name : "+marketplace.get(a).getnamaCluster());
                    System.out.println("Size : "+marketplace.get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+marketplace.get(a).getharga());
                    System.out.println("Facilities : "+marketplace.get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
            }
            System.out.print("Choose property to buy (0 to cancel) : ");
            int buyprop = s.nextInt();
            while (buyprop < 0 || buyprop > marketplace.size()){
                System.out.println("Input not available!");
                System.out.print("Choose property to buy (0 to cancel) : ");
                buyprop = s.nextInt();
            }
            if (buyprop == 0){
                break;
            }
            System.out.println("Sucessfully bought property!");
            ua.setProperti(marketplace.get(buyprop-1));
            marketplace.remove(buyprop-1);
            break;

            case "3":
            System.out.println("\n===== Sell Property =====");
            if (ua.getProperti().size() == 0){
                System.out.println("You have no properties!");
                break;
            } 
            for (int a = 0; a < ua.getProperti().size(); a++){
                if (ua.getProperti().get(a) instanceof Rumah){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : House");
                    System.out.println("Cluster Name : "+ua.getProperti().get(a).getnamaCluster());
                    System.out.println("Size : "+ua.getProperti().get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+ua.getProperti().get(a).getharga());
                    System.out.println("Facilities : "+ua.getProperti().get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
                else if (ua.getProperti().get(a) instanceof Apartment){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : Apartment");
                    System.out.println("Cluster Name : "+ua.getProperti().get(a).getnamaCluster());
                    System.out.println("Size : "+ua.getProperti().get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+ua.getProperti().get(a).getharga());
                    System.out.println("Facilities : "+ua.getProperti().get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
                else if (ua.getProperti().get(a) instanceof Villa){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : Villa");
                    System.out.println("Cluster Name : "+ua.getProperti().get(a).getnamaCluster());
                    System.out.println("Size : "+ua.getProperti().get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+ua.getProperti().get(a).getharga());
                    System.out.println("Facilities : "+ua.getProperti().get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
            }
            System.out.print("Choose property to sell : ");
            int choosetosell = s.nextInt();
            while (choosetosell < 0 || choosetosell > ua.getProperti().size()){
                System.out.print("Input not valid! Choose property to sell : ");
                choosetosell = s.nextInt();
            }
            System.out.println("Successfully sold property for $"+ua.getProperti().get(choosetosell-1).getharga());
            marketplace.add(ua.getProperti().get(choosetosell-1));
            ua.sellProperti(choosetosell-1);
            break;

            case "4":
            System.out.println("Logging out.....");
            menu();
            break;

            default:
            System.out.println("Input unavailable!");
            break;
        }
        } // while true ends here
    }
    else if (ua instanceof Dev){
        while (true){
        System.out.println("\nHello, "+ua.getUsername());
        System.out.println("What would you like to do?");
        System.out.println("1. Add Property Listing\n2. Check All Property Listings\n3. Sell Property to Customer\n4. Logout");
        System.out.print("Choose : ");
        String menudev = s.next()+s.nextLine();
        switch (menudev){
            case "1":
            System.out.println("\n===== Add Property Listings =====");
            System.out.println("Choose Type :\n1. House\n2. Apartment\n3. Villa\n4. Cancel");
            System.out.print("Choose : ");
            String newlisting = s.next()+s.nextLine();
            while (!newlisting.equalsIgnoreCase("1") && !newlisting.equalsIgnoreCase("2") && !newlisting.equalsIgnoreCase("3") && !newlisting.equalsIgnoreCase("0")){
            System.out.print("Input invalid! Choose : ");
            newlisting = s.next()+s.nextLine();
            }
            if (newlisting.equalsIgnoreCase("0")){
                System.out.println("Back to menu...");
                break;
            } else{
                System.out.print("Input cluster name : ");
                String newclusname = s.next()+s.nextLine();
                System.out.print("Input property size : ");
                double newpropsize = s.nextDouble();
                System.out.print("Input price : ");
                double newpropprice = s.nextDouble();
                System.out.print("Input facilities : ");
                String newfacil = s.next()+s.nextLine();
                    if (newlisting.equals("1")){   
                        Properti p = new Rumah(newpropsize, newclusname, newpropprice, newfacil);
                        marketplace.add(p);
                    } 
                    else if (newlisting.equals("2")){
                        Properti p = new Apartment(newpropsize, newclusname, newpropprice, newfacil);
                        marketplace.add(p);
                    }
                    else if (newlisting.equals("3")){
                        Properti p = new Villa(newpropsize, newclusname, newpropprice, newfacil);
                        marketplace.add(p);
                    }
                System.out.println("Successfully added new property listing!");
            }
            break;

            case "2":
            System.out.println("\n===== All Property Listings =====");
            for (int a = 0; a < marketplace.size(); a++){
                if (marketplace.get(a) instanceof Rumah){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : House");
                    System.out.println("Cluster Name : "+marketplace.get(a).getnamaCluster());
                    System.out.println("Size : "+marketplace.get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+marketplace.get(a).getharga());
                    System.out.println("Facilities : "+marketplace.get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
                else if (marketplace.get(a) instanceof Apartment){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : Apartment");
                    System.out.println("Cluster Name : "+marketplace.get(a).getnamaCluster());
                    System.out.println("Size : "+marketplace.get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+marketplace.get(a).getharga());
                    System.out.println("Facilities : "+marketplace.get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
                else if (marketplace.get(a) instanceof Villa){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : Villa");
                    System.out.println("Cluster Name : "+marketplace.get(a).getnamaCluster());
                    System.out.println("Size : "+marketplace.get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+marketplace.get(a).getharga());
                    System.out.println("Facilities : "+marketplace.get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
            }
            break;

            case "3":
            System.out.println("\n===== Sell Property =====");
            int checking3 = 0;
                for (int a = 0; a < userlist.size(); a++){
                    if (userlist.get(a) instanceof Cust){
                        checking3 = 1;
                    }
                }
            if (checking3 == 0){
                System.out.println("No customers available!");
                break;
            } else{
                System.out.println("Choose customer to sell property to : ");
                for (int a = 0; a < userlist.size(); a++){
                    if (userlist.get(a) instanceof Cust){
                    System.out.println((a+1)+". "+userlist.get(a).getUsername());
                    }
                }
                System.out.println("Choose customer (Input customer username) : ");
                String inputu = s.next()+s.nextLine();
            int checksell = 0;
            int usernumber = -1;
                for (int a = 0; a < userlist.size(); a++){
                    if (userlist.get(a) instanceof Cust && userlist.get(a).getUsername().equals(inputu)){
                    checksell = 1;
                    usernumber = a;
                    }
                }
                while (checksell == 0){
                    System.out.println("Customer not found! ");
                    System.out.print("Choose customer (Input customer username) : ");
                    inputu = s.next()+s.nextLine();
                    for (int a = 0; a < userlist.size(); a++){
                        if (userlist.get(a) instanceof Cust && userlist.get(a).getUsername().equals(inputu)){
                        checksell = 1;
                        usernumber = a;
                        }
                    }
                }
            // property time
            System.out.println("\n===== All Property Listings =====");
            for (int a = 0; a < marketplace.size(); a++){
                if (marketplace.get(a) instanceof Rumah){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : House");
                    System.out.println("Cluster Name : "+marketplace.get(a).getnamaCluster());
                    System.out.println("Size : "+marketplace.get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+marketplace.get(a).getharga());
                    System.out.println("Facilities : "+marketplace.get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
                else if (marketplace.get(a) instanceof Apartment){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : Apartment");
                    System.out.println("Cluster Name : "+marketplace.get(a).getnamaCluster());
                    System.out.println("Size : "+marketplace.get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+marketplace.get(a).getharga());
                    System.out.println("Facilities : "+marketplace.get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
                else if (marketplace.get(a) instanceof Villa){
                    System.out.println((a+1)+". ");
                    System.out.println("Type : Villa");
                    System.out.println("Cluster Name : "+marketplace.get(a).getnamaCluster());
                    System.out.println("Size : "+marketplace.get(a).getluasBangunan()+" m\u00B2");
                    System.out.println("Price : $"+marketplace.get(a).getharga());
                    System.out.println("Facilities : "+marketplace.get(a).getfasilitas());
                    System.out.println("----------------------------------------------");
                }
            }
            System.out.print("Choose property to sell to "+userlist.get(usernumber).getUsername()+" : ");
            int proptosell = s.nextInt();
                while (proptosell < 1 || proptosell > marketplace.size()){
                    System.out.println("Input unavailable!");
                    System.out.print("Choose property to sell to "+userlist.get(usernumber).getUsername()+" : ");
                    proptosell = s.nextInt();
                }
            System.out.println("Successfully sold property to "+userlist.get(usernumber).getUsername()+" !");
            userlist.get(usernumber).setProperti(marketplace.get(proptosell-1));
            marketplace.remove(proptosell-1);
            }
            break;

            case "4":
            System.out.println("Logging out....");
            menu();
            break;

            default: 
            System.out.println("Input invalid!");
            break;
        }
        } // while true ends
    }
}

    public void menu() {
        //Mau Login atau Register
        Scanner s = new Scanner(System.in);
            if (donce == 0){
            addfirst();
            donce = 1;
            }
        UserAbs currentuser = null;
        //
        while (currentuser == null) {
            System.out.println("\nWelcome to PrimeVision Developers and Co.");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose menu : ");
            int choose = s.nextInt();
            if (choose == 1) {
                currentuser = register();
            } 
            else if (choose == 2) {
                currentuser = login();
            }
            else if (choose == 3){
            System.out.println("See you next time!");
            System.exit(0);
            }
            if (currentuser != null) {
            ua = currentuser;
            runapp();
            }
        }
    }

    public UserAbs login() {
        String tryagain = "";
        while (!tryagain.equalsIgnoreCase("n")) {
            Scanner s = new Scanner(System.in);
            System.out.print("Input your name : ");
            String uname = s.next()+s.nextLine();
            System.out.print("Input your password : ");
            String pwd = s.next()+s.nextLine();
            for (UserAbs ua : userlist) {
                if (ua.getUsername().equals(uname) && ua.getPassword().equals(pwd)) {
                    return ua;
                }
            }
            //Berikan pesan error
            System.out.println("Username or Password don't match! ");
            System.out.print("Try Again (Y/N):  ");
            tryagain = s.next()+s.nextLine();
                while (!tryagain.equalsIgnoreCase("y") && !tryagain.equalsIgnoreCase("n")){
                System.out.print("Input invalid! Try Again (Y/N): ");
                tryagain = s.next()+s.nextLine();
                }
        }
        return null;
    }

    public UserAbs register() {
        Scanner s = new Scanner(System.in);
        System.out.println("Registering new developer account or customer account?");
        System.out.println("1. Developer\n2. Customer\n0. Exit");
        System.out.print("Choose: ");
        int regisnewacc = s.nextInt();
            if (regisnewacc < 0 || regisnewacc > 2){
                System.out.print("Input not valid! Choose option: ");
                regisnewacc = s.nextInt();
            } else if (regisnewacc == 0){
                System.out.println("Returning...");
                menu();
            }
        System.out.print("Input your name : ");
        String uname = s.next();
        System.out.print("Input your password : ");
        String pwd = s.next();
            // while (pwd.length() < 8){
            // System.out.print("Password length must be at least ! Input your password: ");
            // pwd = s.next();
            // }
        if (regisnewacc == 1){
            //dev
            System.out.print("Enter admin password to register new Developer : ");
            String apass = s.next()+s.nextLine();
                if (!apass.equals("newadmin1234567890")){
                    System.out.println("Password not valid, cancelling....\n");
                    menu();
                }
            UserAbs ua = new Dev();
            ua.setUsername(uname);
            ua.setPassword(pwd);
            System.out.println("Registered new Developer account");
            userlist.add(ua);
            return ua;
        }
        else if (regisnewacc == 2){
            //cust
            UserAbs ua = new Cust();
            ua.setUsername(uname);
            ua.setPassword(pwd);
            System.out.println("Registered new Customer account");
            userlist.add(ua);
            return ua;
        }
        System.out.println("test");
        return ua;
    }

public void addfirst(){
    UserAbs u = new Dev();
    u.setUsername("Valen");
    u.setPassword("admin12345678");
    userlist.add(u);
    Properti ap = new Apartment(40, "Central Business District", 3000, "Fully Furnished, Near Train Station, Near Supermarket");
    marketplace.add(ap);
    Properti ru = new Rumah(85, "Skyline Suburbs", 9000, "Two Floors, Fireplace, Gated Community, near Supermarket");
    marketplace.add(ru);
    Properti vi = new Villa(160, "Rich Community", 50000, "Garden with Fountain, Garage up to 5 cars, 7 Bedrooms, Fully Furnished");
    marketplace.add(vi);
}

}
