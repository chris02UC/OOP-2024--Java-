package Soal1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class soal1 {
    public static ArrayList<String> cname = new ArrayList<String>();
    public static ArrayList<String> cnumber = new ArrayList<String>();
    public static ArrayList<String> cemail = new ArrayList<String>();
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int firstadd = 0;
    while (true){
    try{
    System.out.println("=== Welcome to GetContact ===");
    System.out.println("1. Add Contact\n2. Find Contact\n3. Delete Contact\n4. Display All Contacts");
    System.out.print("Input: ");
    String menu = s.next()+s.nextLine();
    if (firstadd == 0 && (menu.matches("2") || menu.matches("3") || menu.matches("4"))){
    System.out.println("Add first contact first!\n");
    continue;
    }
    
    switch (menu) {
    case "1":
        System.out.println("== Add new contact ==");
        System.out.print("Name: ");
        String inpname = s.next()+s.nextLine();
        while (!inpname.matches("^[a-zA-z\\s]*$")){
        System.out.println("Input invalid!");
        System.out.print("Name: ");
        inpname = s.next()+s.nextLine();
        }
        System.out.print("Telephone number: ");
        String inptelp = s.next()+s.nextLine();
        while (!inptelp.matches("\\d+")){
        System.out.println("Input invalid!");
        System.out.print("Telephone number: ");
        inptelp = s.next()+s.nextLine();        
        }
        System.out.print("Email: ");
        String inpemail = s.next()+s.nextLine();        
        System.out.println("");
        cname.add(inpname);
        cnumber.add(inptelp);
        cemail.add(inpemail);
        System.out.println("Data successfully added!");
        firstadd = 1;
        break;

    case "2":
        System.out.println("== Find contact ==");
        System.out.print("Search name or telephone number? (N/T): ");
        String nt = s.next()+s.nextLine();
        while (!nt.equalsIgnoreCase("n")  && !nt.equalsIgnoreCase("t")){
        System.out.print("Input invalid! Search name or telephone number? (N/T): ");
        nt = s.next()+s.nextLine();
        }
        if (nt.equalsIgnoreCase("n")){
        System.out.print("Search name: ");
        int temp = 0;
        String nameindex = s.next()+s.nextLine();
        while (!nameindex.matches("^[a-zA-z\\s]*$")){
            System.out.println("Input invalid!");
            System.out.print("Search name: ");
            nameindex = s.next()+s.nextLine();
            }
        for (int a = 0; a < cname.size(); a++){
            if(cname.get(a).equals(nameindex)){
                System.out.println("\tName\t\t\t\t\tTelp Number\t\t\t\tEmail");
                System.out.print("\t");
                if (cname.get(a).length() >= 8 && cname.get(a).length() < 16){
                    System.out.print(cname.get(a)+"\t\t\t\t");
                    }
                    else if (cname.get(a).length() >= 16 && cname.get(a).length() <= 20){
                    System.out.print(cname.get(a)+"\t\t\t");        
                    }
                    else if (cname.get(a).length() < 8){
                    System.out.print(cname.get(a)+"\t\t\t\t\t");
                    }
                if (cnumber.get(a).length() >= 8 && cnumber.get(a).length() < 16){
                    System.out.print(cnumber.get(a)+"\t\t\t\t");
                    }
                    else if (cnumber.get(a).length() >= 16 && cnumber.get(a).length() <= 20){
                    System.out.print(cnumber.get(a)+"\t\t\t");        
                    }
                    else if (cnumber.get(a).length() < 8){
                    System.out.print(cnumber.get(a)+"\t\t\t\t\t");
                    }
                System.out.print(cemail.get(a));
            temp = 1;            
            }
        }
            if (temp == 0){
            System.out.println("Contact not found!");
            }
        }
        else if (nt.equalsIgnoreCase("t")){
        System.out.print("Search telephone number: ");
        int temp = 0;
        String numberindex = s.next()+s.nextLine();
        while (!numberindex.matches("\\d+")){
            System.out.println("Input invalid!");
            System.out.print("Search telephone number: ");
            numberindex = s.next()+s.nextLine();        
            } //compare
        for (int a = 0; a < cnumber.size(); a++){
            if(cnumber.get(a).equals(numberindex)){
                System.out.println("\tName\t\t\t\t\tTelp Number\t\t\t\tEmail");
                System.out.print("\t");
                if (cname.get(a).length() >= 8 && cname.get(a).length() < 16){
                    System.out.print(cname.get(a)+"\t\t\t\t");
                    }
                    else if (cname.get(a).length() >= 16 && cname.get(a).length() <= 20){
                    System.out.print(cname.get(a)+"\t\t\t");        
                    }
                    else if (cname.get(a).length() < 8){
                    System.out.print(cname.get(a)+"\t\t\t\t\t");
                    }
                if (cnumber.get(a).length() >= 8 && cnumber.get(a).length() < 16){
                    System.out.print(cnumber.get(a)+"\t\t\t\t");
                    }
                    else if (cnumber.get(a).length() >= 16 && cnumber.get(a).length() <= 20){
                    System.out.print(cnumber.get(a)+"\t\t\t");        
                    }
                    else if (cnumber.get(a).length() < 8){
                    System.out.print(cnumber.get(a)+"\t\t\t\t\t");
                    }
                    System.out.print(cemail.get(a));
                temp = 1;            
            }
        }
            if (temp == 0){
            System.out.println("Contact not found!");
            System.out.println("");
            }
        }
        System.out.println("");
        break;

    case "3":
    System.out.println("== Delete contact ==");
    System.out.print("Search name or telephone number? (N/T): ");
    nt = s.next()+s.nextLine();
    while (!nt.equalsIgnoreCase("n")  && !nt.equalsIgnoreCase("t")){
    System.out.print("Input invalid! Search name or telephone number? (N/T): ");
    nt = s.next()+s.nextLine();
    }
    if (nt.equalsIgnoreCase("n")){
    System.out.print("Search name: ");
    int temp = 0;
    String nameindex = s.next()+s.nextLine();
    while (!nameindex.matches("^[a-zA-z\\s]*$")){
        System.out.println("Input invalid!");
        System.out.print("Search name: ");
        nameindex = s.next()+s.nextLine();
        }
    for (int a = 0; a < cname.size(); a++){
        if(cname.get(a).equals(nameindex)){
            System.out.println("\tName\t\t\t\t\tTelp Number\t\t\t\tEmail");
            System.out.print("\t");
            if (cname.get(a).length() >= 8 && cname.get(a).length() < 16){
                System.out.print(cname.get(a)+"\t\t\t\t");
                }
                else if (cname.get(a).length() >= 16 && cname.get(a).length() <= 20){
                System.out.print(cname.get(a)+"\t\t\t");        
                }
                else if (cname.get(a).length() < 8){
                System.out.print(cname.get(a)+"\t\t\t\t\t");
                }
            if (cnumber.get(a).length() >= 8 && cnumber.get(a).length() < 16){
                System.out.print(cnumber.get(a)+"\t\t\t\t");
                }
                else if (cnumber.get(a).length() >= 16 && cnumber.get(a).length() <= 20){
                System.out.print(cnumber.get(a)+"\t\t\t");        
                }
                else if (cnumber.get(a).length() < 8){
                System.out.print(cnumber.get(a)+"\t\t\t\t\t");
                }
            System.out.print(cemail.get(a));
        temp = 1;
        System.out.println("");
        System.out.print("Are you sure you want to delete this contact? (Y/N): ");
        String delete = s.next()+s.nextLine();
        while (!delete.equalsIgnoreCase("Y")  && !delete.equalsIgnoreCase("N")){
        System.out.print("Input invalid! Are you sure you want to delete this contact? (Y/N):  ");
        }
        if (delete.equalsIgnoreCase("y")){
            if (cname.size() == 1){
            firstadd = 0;
            }       
        cname.remove(a);
        cnumber.remove(a);
        cemail.remove(a);
        System.out.println("Data successfully deleted!");   
        }
        else if (delete.equalsIgnoreCase("n")){
        System.out.println("Make up your mind!");
        }
        }
    }
        if (temp == 0){
        System.out.println("Contact not found!");
        }
    }
    else if (nt.equalsIgnoreCase("t")){
    System.out.print("Search telephone number: ");
    int temp = 0;
    String numberindex = s.next()+s.nextLine();
    while (!numberindex.matches("\\d+")){
        System.out.println("Input invalid!");
        System.out.print("Search telephone number: ");
        numberindex = s.next()+s.nextLine();        
        } //compare //compare
    for (int a = 0; a < cnumber.size(); a++){
        if(cnumber.get(a).equals(numberindex)){
            System.out.println("\tName\t\t\t\t\tTelp Number\t\t\t\tEmail");
            System.out.print("\t");
            if (cname.get(a).length() >= 8 && cname.get(a).length() < 16){
                System.out.print(cname.get(a)+"\t\t\t\t");
                }
                else if (cname.get(a).length() >= 16 && cname.get(a).length() <= 20){
                System.out.print(cname.get(a)+"\t\t\t");        
                }
                else if (cname.get(a).length() < 8){
                System.out.print(cname.get(a)+"\t\t\t\t\t");
                }
            if (cnumber.get(a).length() >= 8 && cnumber.get(a).length() < 16){
                System.out.print(cnumber.get(a)+"\t\t\t\t");
                }
                else if (cnumber.get(a).length() >= 16 && cnumber.get(a).length() <= 20){
                System.out.print(cnumber.get(a)+"\t\t\t");        
                }
                else if (cnumber.get(a).length() < 8){
                System.out.print(cnumber.get(a)+"\t\t\t\t\t");
                }
                System.out.print(cemail.get(a));
            temp = 1;
            System.out.println("");
            System.out.print("Are you sure you want to delete this contact? (Y/N): ");
            String delete = s.next()+s.nextLine();
            while (!delete.equalsIgnoreCase("Y")  && !delete.equalsIgnoreCase("N")){
            System.out.print("Input invalid! Are you sure you want to delete this contact? (Y/N):  ");
            }
            if (delete.equalsIgnoreCase("y")){
                if (cnumber.size() == 1){
                firstadd = 0;
                }       
            cname.remove(a);
            cnumber.remove(a);
            cemail.remove(a);
            System.out.println("Data successfully deleted!");   
            }
            else if (delete.equalsIgnoreCase("n")){
            System.out.println("Make up your mind!");
            }            
        }
    }
        if (temp == 0){
        System.out.println("Contact not found!");
        System.out.println("");
        }
    }
    System.out.println("");
        break;

    case "4":
        System.out.println("=== Displaying All Contacts! ===");
        System.out.println("\tNo. \t\t\tName\t\t\t\t\tTelp Number\t\t\t\tEmail");
        for (int a = 0; a < cname.size(); a++){
        System.out.print("\t"+(a+1)+"\t\t\t");
        if (cname.get(a).length() >= 8 && cname.get(a).length() < 16){
            System.out.print(cname.get(a)+"\t\t\t\t");
            }
            else if (cname.get(a).length() >= 16 && cname.get(a).length() <= 20){
            System.out.print(cname.get(a)+"\t\t\t");        
            }
            else if (cname.get(a).length() < 8){
            System.out.print(cname.get(a)+"\t\t\t\t\t");
            }
        if (cnumber.get(a).length() >= 8 && cnumber.get(a).length() < 16){
            System.out.print(cnumber.get(a)+"\t\t\t\t");
            }
            else if (cnumber.get(a).length() >= 16 && cnumber.get(a).length() <= 20){
            System.out.print(cnumber.get(a)+"\t\t\t");        
            }
            else if (cnumber.get(a).length() < 8){
            System.out.print(cnumber.get(a)+"\t\t\t\t\t");
            }
        System.out.print(cemail.get(a));
        System.out.println("");
        }
        System.out.println("");
        break;
    default:
        System.out.println("Input invalid!\n");
        break;   
    }

    } catch (Exception e){
    System.out.println("Error, try again!\n");
    }

    }
    }

}
