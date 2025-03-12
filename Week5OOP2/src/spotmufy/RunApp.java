package spotmufy;
import java.util.ArrayList;
import java.util.Scanner;

public class RunApp {
private User u;
int donce = 0;
private ArrayList<User>userlist = new ArrayList<User>();
private ArrayList<Music>musiclist = new ArrayList<Music>();
private int tambahmusic = 0;

public void runapp(){
Scanner s = new Scanner(System.in);
    if (tambahmusic == 0){
    addmusic1st();
    tambahmusic = 1;
    }
    if (u.getfirstpps() == 0){
        for (int a = 0; a < musiclist.size(); a++){
        u.setpps(0);
        }
    }
    while (true){
    System.out.println("\nHello, "+u.getusername()+". What would you like to listen today?");
    System.out.println("Total Listening duration: "+u.getlistdur());
    System.out.println("1. Search Music\n2. Choose Music\n3. Play Music \n4. Make Playlist\n5. Add to Playlist\n6. Remove From Playlist\n7. Exit");
   // System.out.println("1. Listen to music\n2. Check Playlist\n3. Logout");
    System.out.print("Choose: ");
    String inputmenu = s.next()+s.nextLine();
    switch(inputmenu){
    case "2":
    System.out.println("\nMusic Available: ");
        for (int a = 0; a < musiclist.size(); a++){
        System.out.println((a+1)+". "+musiclist.get(a).gettitle()+" ("+musiclist.get(a).getreleaseyear()+") | Duration: "+musiclist.get(a).getduration()+" | Artist: "+musiclist.get(a).getartist()+" | Plays: "+u.getpps().get(a));
        }
    System.out.println("Choose music: ");
    int pilihmusic = s.nextInt();
        while (pilihmusic < 1 || pilihmusic > musiclist.size() ){
        System.out.print("Not Available! Choose music: ");
        pilihmusic = s.nextInt();
        }
    u.setlistdur(musiclist.get(pilihmusic-1).getduration());
    u.setppsdetail(pilihmusic-1, u.getpps().get(pilihmusic-1)+1);
    System.out.println("");
    break;
        
    case "4":
    System.out.println("Current playlists: ");
        if (u.getplaylist().size() == 0){
        System.out.println("== No Playlists Detected ==");
        }
        else{
            for (int a = 0; a < u.getplaylist().size(); a++){
            System.out.println((a+1)+". "+u.getplaylist().get(a).getplname());
            }
        }
    
    System.out.println("1. Make playlist\n2. Check playlist contents");
    int input2 = s.nextInt();
        while (input2!=1 && input2!= 2){
        System.out.print("Input invalid! Choose: ");
        input2 = s.nextInt();
        }
    if (input2 == 1){
    System.out.println("\nMaking Playlist!");
    System.out.print("name this playlist: ");
    String nama = s.next();
    Playlist p = new Playlist();
    p.setplname(nama);
    String yesno = "";
    while (!yesno.equals("y")){
        for (int a = 0; a < musiclist.size(); a++){
        System.out.println((a+1)+". "+musiclist.get(a).gettitle()+" ("+musiclist.get(a).getreleaseyear()+") | Duration: "+musiclist.get(a).getduration()+" | Artist: "+musiclist.get(a).getartist()+" | Plays: "+u.getpps().get(a));
        }
        System.out.println("Choose music: ");
        int input3 = s.nextInt();
        while (input3 < 1 || input3 > musiclist.size() ){
        System.out.print("Not Available! Choose music: ");
        input3 = s.nextInt();
        }
    p.addmusicinplaylist(musiclist.get(input3-1));
    System.out.print("Add more?");
    yesno = s.next();
    }
    u.setplaylist(p);
    }
    else if (input2 == 2){
        if (u.getplaylist().size() == 0){
            System.out.println("== No Playlists Detected ==");
            break;
        }
        else{
            for (int a = 0; a < u.getplaylist().size(); a++){
            System.out.println((a+1)+". "+u.getplaylist().get(a).getplname());
            }
        System.out.print("Choose playlist: ");
        int cpl = s.nextInt();
        while (cpl < 1 || cpl > u.getplaylist().size() ){
        System.out.print("Not Available! Choose playlist ");
        cpl = s.nextInt();
        }
            for (int a = 0; a < u.getplaylist().get(cpl-1).getmusicinplaylist().size(); a++){
            System.out.println((a+1)+". "+u.getplaylist().get(cpl-1).getmusicinplaylist().get(a).gettitle());
            }
        }
    }

    break;

    case "7":
    menu();
    break;

    case "addmusic":
    System.out.print("Input name of song: ");
    String namesong = s.next();
    System.out.print("Input artist: ");
    String nameartist = s.next();
    System.out.print("Input albumname: ");
    String namealbum = s.next();
    System.out.print("Input duration of song: ");
    int dur = s.nextInt();
    System.out.print("Input year of release: ");
    int yor = s.nextInt();
    Music addmusic = new Music(nameartist, namesong, namealbum, dur, yor);
    musiclist.add(addmusic);
    u.setpps(0); // adds 0 to end instead of replacing, extends the arraylist
    break;

    default:
    System.out.println("Input not available!");
    break;
    }
    }
}
    
    public void menu() {
        //Mau Login atau Register
        Scanner s = new Scanner(System.in);
            if (donce == 0){
            addadmin();
            donce = 1;
            }
        User currentuser = null;
        //
        while (currentuser == null) {
            System.out.println("\nWelcome to Spotmufy");
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
            u = currentuser;
            runapp();
            }
        }
    }

    public User login() {
        String tryagain = "";
        while (!tryagain.equalsIgnoreCase("n")) {
            Scanner s = new Scanner(System.in);
            System.out.print("Input your name : ");
            String uname = s.next()+s.nextLine();
            System.out.print("Input your password : ");
            String pwd = s.next()+s.nextLine();
            for (User u : userlist) {
                if (u.getusername().equals(uname) && u.getpassword().equals(pwd)) {
                    return u;
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

    public User register() {
        //Minta username dan password
        Scanner s = new Scanner(System.in);
        System.out.print("Input your name : ");
        String uname = s.next();
        System.out.print("Input your password : ");
        String pwd = s.next();
            // while (pwd.length() < 8){
            // System.out.print("Password length must be at least ! Input your password: ");
            // pwd = s.next();
            // }
        //Buat objek player baru
        User u = new User();
        u.setusername(uname);
        u.setpassword(pwd);
        System.out.println("Registered new user");
        userlist.add(u);
        return u;
    }

public void addmusic1st(){
Music m1 = new Music("Pamungkas", "To The Bone", "This is Us", 190 , 2018);
Music m2 = new Music("ampnymmous", "Happy Birthday to You", "hey", 60 , 2000);
Music m3 = new Music("Jvke", "Golden hour", "Miss You", 175 , 2022);
musiclist.add(m1);
musiclist.add(m2);
musiclist.add(m3);
}

public void addadmin(){
    User u = new User();
    u.setusername("admin");
    u.setpassword("admin");
    User u1 = new User();
    u1.setusername("test");
    u1.setpassword("123");
    userlist.add(u);
    userlist.add(u1);
}

}
