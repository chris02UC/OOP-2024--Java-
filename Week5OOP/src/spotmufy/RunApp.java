package spotmufy;
import java.util.Scanner;
import java.util.ArrayList;

public class RunApp {
    private User u;
    private ArrayList<Music>musicList = new ArrayList<Music>();
    private int firstaddmusic = 0;
    // public RunApp(){
    // System.out.println("test");
    // }

    // public RunApp(LogReg lr) {
    // this.lr = lr; // Initialize lr with the provided LogReg object
    // }

    public User runapppublic(User currentuser){
    u = currentuser;
    Scanner s = new Scanner(System.in);
    String inputmm = "";
        if (firstaddmusic == 0){
            addfirstmusic();
            System.out.println("test");
            firstaddmusic = 1;
        }
    while (!inputmm.equals("7")){
        System.out.println("\nHello, "+u.getUsername()+". What would you like to do?");
        System.out.println("Total listening duration = "+u.gettotal_listen());
        System.out.println("1. Search Music\n2. Choose Music\n3. Play Music\n4. Make Playlist\n5. Add to Playlist\n6. Remove From Playlist\n7. Exit");
        System.out.print("Choice: ");
        inputmm = s.next()+s.nextLine();
        while (!inputmm.equals("1") && !inputmm.equals("2") && !inputmm.equals("3") && !inputmm.equals("4") && !inputmm.equals("5") && !inputmm.equals("6") && !inputmm.equals("7")){
        System.out.print("Input not valid! Choice: ");
        inputmm = s.next()+s.nextLine();
        }
    switch (inputmm){
    case "1":
    System.out.println("\nSearching Music");
    System.out.println("Search by Title or Artist Name?");
    System.out.println("1. Artist\n2. Title");
    System.out.print("Choice: ");
    int choosecasesatu = s.nextInt();
    while (choosecasesatu < 1 || choosecasesatu > 2){
        System.out.println("Inpout invalid? Choice: ");
        choosecasesatu = s.nextInt();
    }
    int havedisplayed = 0;
    if (choosecasesatu == 1){
        System.out.println("Input Artist to search: ");
        String input = s.next()+s.nextLine();
        System.out.println("Result: ");
    for (int a = 0; a < musicList.size(); a++){
        if (musicList.get(a).getartist().toLowerCase().contains(input)){
        System.out.println((a+1)+". "+musicList.get(a).gettitle()+" | "+musicList.get(a).getartist()+" | "+musicList.get(a).getreleaseyear()+" | "+musicList.get(a).getduration()+" seconds");
        havedisplayed = 1;
        }
    }
    } else if (choosecasesatu == 2){
        System.out.print("Input Title to search: ");
        String input = s.next()+s.nextLine();
        System.out.println("Result: ");
        for (int a = 0; a < musicList.size(); a++){
            if (musicList.get(a).gettitle().toLowerCase().contains(input.toLowerCase())){
            System.out.println((a+1)+". "+musicList.get(a).gettitle()+" | "+musicList.get(a).getartist()+" | "+musicList.get(a).getreleaseyear()+" | "+musicList.get(a).getduration()+" seconds");
            havedisplayed = 1;
            }
        }
    }
        if (havedisplayed == 0){
        break;
        }
    System.out.print("Choose music? Y/N: ");
    String yesno = s.next()+s.nextLine();
        while (!yesno.equalsIgnoreCase("y") && !yesno.equalsIgnoreCase("n")){
        System.out.print("Input not valid! Choose music? Y/N: ");
        yesno = s.next()+s.nextLine();
        }
    if (yesno.equalsIgnoreCase("n")){
        break;
    } else if (yesno.equalsIgnoreCase("y")){
        System.out.print("Choose music: ");
        int choosemusic = s.nextInt();
        while (choosemusic < 1 || choosemusic > musicList.size()){
        System.out.print("Input not valid! Choose music: ");
        choosemusic = s.nextInt();
        }
    u.setchosenmusic(musicList.get(choosemusic-1));
    System.out.println("Music Successfully chosen!");
    }
    break;

    case "2":
    System.out.println("\nChoose music");
    for (int a = 0; a < musicList.size(); a++){
        System.out.println((a+1)+". "+musicList.get(a).gettitle()+" | "+musicList.get(a).getartist()+" | "+musicList.get(a).getreleaseyear()+" | "+musicList.get(a).getduration()+" seconds");
    }
    System.out.println("Choose music: ");
    int choosemusic = s.nextInt();
    while (choosemusic < 1 || choosemusic > musicList.size()){
    System.out.print("Input not valid! Choose music: ");
    choosemusic = s.nextInt();
    }
    u.setchosenmusic(musicList.get(choosemusic-1));
    System.out.println("Music Successfully chosen!");
    break;

    case "3":
        if (u.getchosenmusic() == null){
        System.out.println("Choose a music first!");
        break;
        }
    System.out.println("\nPlaying chosen music");
    System.out.println("Now Playing : "+u.getchosenmusic().gettitle()+" | "+u.getchosenmusic().getartist()+" | "+u.getchosenmusic().getreleaseyear());
    u.settotal_listen(u.getchosenmusic().getduration());
    u.getchosenmusic().setnumberplayed();
    break;

    case "4":
    break;

    case "5":
    break;

    case "6":
    break;

    case "7":
    System.out.println("Exiting....");
    break;

    default:
    System.out.println("Input not available!");
    break;
    }
    }   
    return this.u;
    }

    public void addfirstmusic(){
        Music m1 = new Music("To The Bone", "Pamungkas", "Album 1", 2018, 0, 190);
        Music m2 = new Music("Happy Birthday to You", "ampnymous", "Album 2", 2000, 0, 60);
        Music m3 = new Music("Golden Hour", "Jvke", "Album 3", 2022, 0, 175);
        musicList.add(m1);
        musicList.add(m2);
        musicList.add(m3);
    }
}
