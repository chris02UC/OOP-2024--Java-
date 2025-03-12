package spotmufy;

import java.util.ArrayList;
import java.util.Scanner;

public class LogReg {
    private ArrayList<User> userList;
    private int firsttry = 0;
    private int IndexCurruser = -1;
    private RunApp r = new RunApp();
    
    public LogReg(){
        userList = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin");
        userList.add(user1);
        
        User user2 = new User();
        user2.setUsername("test");
        user2.setPassword("123");
        userList.add(user2);
    }
    
    public void Menu(){
        Scanner scan = new Scanner(System.in);
        User curruser = null;
        
        while (firsttry == 0){
            System.out.println("Welcome to Spotmufy");
            System.out.println("Please make an account");
            curruser = Register(); 
            if(curruser != null){
                userList.set(IndexCurruser, curruser);
                curruser = r.runapppublic(curruser);
            }
        firsttry = 1;
        }

        while (true) {
            System.out.println("Welcome to Spotmufy");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choose = scan.nextInt();
            
            switch(choose){
                case 1:
                    curruser = Login();
                    break;
                case 2:
                    curruser = Register();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
            
            if(curruser != null){
                curruser = r.runapppublic(curruser);
                userList.set(IndexCurruser, curruser);
            }
        }
    }
    
    public User Login(){
        String tryAgain = "";
        
        while (!tryAgain.equalsIgnoreCase("N")) {
            Scanner s = new Scanner(System.in);
            System.out.println("Please Login");
            System.out.print("Username : ");
            String uname = s.next();
            System.out.print("Password : ");
            String pwd = s.next();
            
            for(User p: userList){
                
                if(p.getUsername().equalsIgnoreCase(uname) && p.getPassword().equalsIgnoreCase(pwd)){
                    this.IndexCurruser = userList.indexOf(p);
                    return p;
                }
            }
            
            System.out.println("Userame or Password don't match ! ");
            System.out.println("Try Again (Y/N) ? ");
            tryAgain = s.next();
        }
        
        return null;
    }
    
    public User Register(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please Register");
        System.out.print("Username : ");
        String uname = s.next();
        System.out.print("Password : ");
        String pwd = s.next();
        
        User newuser = new User();
        newuser.setUsername(uname);
        newuser.setPassword(pwd);
        userList.add(newuser);
        this.IndexCurruser = userList.size()-1;
            if (firsttry == 0){
            Login();
            }
        return newuser;
    }

}
