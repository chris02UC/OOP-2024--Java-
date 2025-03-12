package SoalSamirLogReg;
import java.util.Scanner;
import java.util.ArrayList;

public class LogReg {
    private ArrayList<User> userlist = new ArrayList<User>();

    public LogReg(){
    User u = new User();
    u.setusername("test");
    u.setpassword("123");
    userlist.add(u);

    menu();
    }

    public void menu() {
        //Mau Login atau Register
        Scanner s = new Scanner(System.in);
        User currentuser = null;
        while (currentuser == null) {
            System.out.println("Menu");
            System.out.println("1. Login");
            System.out.println("2. Register");
            int choose = s.nextInt();
            if (choose == 1) {
                currentuser = login();
            } else if (choose == 2) {
                currentuser = register();
            }
            if (currentuser != null) {
            playgame pg = new playgame(currentuser, this);
            pg.jalangame();
            }
        }
    }

    public User login() {
        String tryagain = "";
        while (!tryagain.equalsIgnoreCase("n")) {
            //Minta username dan password
            Scanner s = new Scanner(System.in);
            System.out.println("Please Login");
            System.out.print("Username : ");
            String uname = s.next();
            System.out.print("Password : ");
            String pwd = s.next();

            //Cocokkan username dan password dengan yg ada di list
            for (User u : userlist) {
                if (u.getusername().equals(uname)
                        && u.getpassword().equals(pwd)) {
                    return u;
                }
            }
            //Berikan pesan error
            System.out.println("Userame or Password don't match ! ");
            System.out.println("Try Again (Y/N) ? ");
            tryagain = s.next();
        }
        return null;
    }

    public User register() {
        //Minta username dan password
        Scanner s = new Scanner(System.in);
        System.out.println("Please Register");
        System.out.println("Username :");
        String uname = s.next();
        System.out.println("Password : ");
        String pwd = s.next();

        //Buat objek player baru
        User u = new User();
        u.setusername(uname);
        u.setpassword(pwd);
        System.out.println("New player has successfully been registered");
        userlist.add(u);
        return u;
    }


}
