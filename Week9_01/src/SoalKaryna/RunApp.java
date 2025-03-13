package SoalKaryna;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class RunApp {
    private ArrayList<Song>musicList = new ArrayList<Song>();
    private LinkedList<Song> songList = new LinkedList<Song>();
    private LinkedList<Song> Queue = new LinkedList<Song>();
    private LinkedList<Playlist> AllPlaylist = new LinkedList<Playlist>();
    private int firstaddmusic = 0;
    
    public void runapp(){
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    String inputmm = "";
    int cyclesongsqueue = 0;
        if (firstaddmusic == 0){
            addfirstmusic();
            Playlist newp = new Playlist();
            newp.setPName("Liked Songs");
            newp.setDescription("your go to favorite songs");
            newp.addMusic(songList.get(2));
            newp.addMusic(songList.get(3));
            newp.addMusic(songList.get(4));
            newp.addMusic(songList.get(5));
            AllPlaylist.add(newp);
                for (int a = 0; a < newp.getAllMusic().size(); a++){
                    Queue.addLast(newp.getAllMusic().get(a));
                }
            // ListIterator<Song> nextsong = Queue.listIterator();
            System.out.println("test");
            firstaddmusic = 1;
        }

    ListIterator<Song> nextsong = Queue.listIterator();

    while (!inputmm.equals("4")){
        System.out.println("\nHello! What would you like to do?");  
        // System.out.println(cyclesongsqueue);
        System.out.println("Song currently playing: "+Queue.get(cyclesongsqueue).gettitle()+" | "+Queue.get(cyclesongsqueue).getartist()+" | "+Queue.get(cyclesongsqueue).getreleaseyear()+" | "+Queue.get(cyclesongsqueue).getduration());
        System.out.println("1. Check All Music\n2. View All Playlists\n3. Next Song\n4. Exit");
        System.out.print("Choice: ");
        inputmm = s.next()+s.nextLine();
        while (!inputmm.equals("1") && !inputmm.equals("2") && !inputmm.equals("3") && !inputmm.equals("4")){
        System.out.print("Input not valid! Choice: ");
        inputmm = s.next()+s.nextLine();
        }
    switch (inputmm){
    case "1":
    System.out.println("\nDisplaying All Music");
    for (int nomer1 = 0; nomer1 < songList.size(); nomer1++){
        System.out.println((nomer1+1)+". "+songList.get(nomer1).gettitle()+" | "+songList.get(nomer1).getartist()+" | "+songList.get(nomer1).getduration()+" | "+songList.get(nomer1).getreleaseyear());
    }
    System.out.println("--------------------------------------");
    System.out.println("What would you like to do?");
    System.out.println("1. Play Song\n2. Add to Queue\n3. Add to Playlist\n4. Go Back");
    System.out.print("Choice: ");
    String inputmenu1 = s.next()+s.nextLine();
    while (!inputmenu1.equals("1") && !inputmenu1.equals("2") && !inputmenu1.equals("3") && !inputmenu1.equals("4")){
        System.out.print("Input invalid! Choice: ");
        inputmenu1 = s.next()+s.nextLine();
    }
    System.out.println("----------------------------------");
    if (inputmenu1.equals("1")){
        System.out.println("Play Song");
        System.out.print("Choose song number to play: ");
        int playsong = s.nextInt();
            while (playsong < 1 || playsong > songList.size()){
                System.out.print("Input not valid! Choose song number to play: ");
                playsong = s.nextInt();
            }
        int randomsong1 = r.nextInt(0, 17);
        int randomsong2 = r.nextInt(0, 17);
        int randomsong3 = r.nextInt(0, 17);
        int randomsong4 = r.nextInt(0, 17);
        int randomsong5 = r.nextInt(0, 17);
        Queue.clear();
        Queue.addFirst(songList.get(playsong-1));
        Queue.addLast(songList.get(randomsong1));
        Queue.addLast(songList.get(randomsong2));
        Queue.addLast(songList.get(randomsong3));
        Queue.addLast(songList.get(randomsong4));
        Queue.addLast(songList.get(randomsong5));
        cyclesongsqueue = 0;
    break;
    }
    else if (inputmenu1.equals("2")){
        System.out.println("Add Song to Queue");
        System.out.print("Choose song number to add to queue: ");
        int addtoqueue = s.nextInt();
        while (addtoqueue < 1 || addtoqueue > songList.size()){
            System.out.print("Input not valid! Choose song number to add to queue: ");
            addtoqueue = s.nextInt();
        }
        Queue.addLast(songList.get(addtoqueue-1)); //adds last
        break;
    }
    else if (inputmenu1.equals("3")){
    System.out.print("Choose song number to add to playlist: ");
    int addsong = s.nextInt();
    while (addsong < 1 || addsong > songList.size()){
        System.out.print("Input not valid! Choose song number to add to playlist: ");
        addsong = s.nextInt();
    }
    System.out.println("Displaying all Playlists");
        for (int a = 0; a < AllPlaylist.size(); a++){
            System.out.println((a+1)+". "+AllPlaylist.get(a).getPName());
        }
    System.out.println("Choose Playlist to add to: ");
    int addtoplaylist = s.nextInt();
    while (addtoplaylist < 0 || addtoplaylist > AllPlaylist.size()){
        System.out.print("Input not valid! Choose Playlist to add to: ");
        addtoplaylist = s.nextInt();
    }
    AllPlaylist.get(addtoplaylist-1).addMusic(songList.get(addsong-1));
    break;
    }
    else if (inputmenu1.equals("4")){
        System.out.println("Going back to menu.....");
        break;
    }
    break;

    case "2":
    System.out.println("\nView All Playlist");
    for (int a = 0; a < AllPlaylist.size(); a++){
        System.out.println((a+1)+". "+AllPlaylist.get(a).getPName());
    }
    System.out.println("-------------------------");
    System.out.println("1. View Playlist\n2. Create New Playlist\n3. Back to Menu");
    System.out.print("Choice: ");
    String inputmenu2 = s.next()+s.nextLine();
    while (!inputmenu2.equals("1") && !inputmenu2.equals("2") && !inputmenu2.equals("3")){
        System.out.print("Input invalid! Choice: ");
        inputmenu1 = s.next()+s.nextLine();
    }
    System.out.println("-------------------------");
    if (inputmenu2.equals("1")){
        System.out.println("View Playlist");
        System.out.print("Choose Playlist to view: ");
        int inputchooseplaylist = s.nextInt();
        while (inputchooseplaylist < 1 || inputchooseplaylist > AllPlaylist.size()){
            System.out.print("Input not valid! Choose playlist to view: ");
            inputchooseplaylist = s.nextInt();
        }
        System.out.println("-------------------------");
        System.out.println("Name: "+AllPlaylist.get(inputchooseplaylist-1).getPName());
        System.out.println("Description: "+AllPlaylist.get(inputchooseplaylist-1).getDescription());
        for (int a = 0; a < AllPlaylist.get(inputchooseplaylist-1).getAllMusic().size(); a++){
            System.out.println((a+1)+". "+AllPlaylist.get(inputchooseplaylist-1).getAllMusic().get(a).gettitle()+" | "+AllPlaylist.get(inputchooseplaylist-1).getAllMusic().get(a).getartist()+" | "+AllPlaylist.get(inputchooseplaylist-1).getAllMusic().get(a).getduration()+" | "+AllPlaylist.get(inputchooseplaylist-1).getAllMusic().get(a).getreleaseyear());
        }
    System.out.print("Play this Playlist? (Y/N): ");
    String playplaylist = s.next()+s.nextLine();
        while (!playplaylist.equalsIgnoreCase("y") && !playplaylist.equalsIgnoreCase("n")){
        System.out.print("Input not valid! Play this Playlist? (Y/N): ");
        playplaylist = s.next()+s.nextLine();
        }
        if (playplaylist.equalsIgnoreCase("y")){
            if (AllPlaylist.get(inputchooseplaylist-1).getAllMusic().size() == 0){
                System.out.println("Your playlist is empty!");
                break;
            }
            System.out.println("Playing "+AllPlaylist.get(inputchooseplaylist-1).getPName()+" Playlist!");
            cyclesongsqueue = 0;
            Queue.clear();
            for (int a = 0; a < AllPlaylist.get(inputchooseplaylist-1).getAllMusic().size(); a++){
                Queue.addLast(AllPlaylist.get(inputchooseplaylist-1).getAllMusic().get(a));
            }
            break;
        } else if (playplaylist.equalsIgnoreCase("n")){
            System.out.println("Returning to menu.....");
            break;
        }
    }
    else if (inputmenu2.equals("2")){
        System.out.println("Creating new playlist!");
        System.out.println("Input name: ");
        String newname = s.next()+s.nextLine();
        System.out.println("Input description: ");
        String newdesc = s.next()+s.nextLine();
        Playlist p = new Playlist();
        p.setPName(newname);
        p.setDescription(newdesc);
        AllPlaylist.add(p);
        break;
    } else if (inputmenu2.equals("3")){
        System.out.println("Returning to menu.....");
        break;
    }
    break;

    case "3":
    System.out.println("\nPlaying next song in current queue!");
    cyclesongsqueue++;
        if (cyclesongsqueue == Queue.size()){
            cyclesongsqueue = 0;
        }
    break;

    case "4":
    System.out.println("Exiting....");
    System.exit(0);
    break;

    default:
    System.out.println("Input not available!");
    break;
    }
    } //while loop ends here   

    } // runapp ends here

    public void addfirstmusic(){
    songList.add(new Song("Midas Touch", "KISS OF LIFE", "2:43", 2024));
    songList.add(new Song("Espresso", "Sabrina Carpenter", "2:55", 2024));
    songList.add(new Song("we can't be friends", "Ariana Grande", "3:48", 2024));
    songList.add(new Song("intro", "Ariana Grande", "1:32", 2024));
    songList.add(new Song("Wide Awake", "Katy Perry", "3:40", 2013));
    songList.add(new Song("Cruel Summer", "Taylor Swift", "2:59", 2019));
    songList.add(new Song("My Love Mine All Mine", "Mitski", "2:19", 2023));
    songList.add(new Song("Kill Bill", "SZA", "2:35", 2022));
    songList.add(new Song("Angels Like You", "Miley Cyrus", "3:18", 2020));
    songList.add(new Song("Monokrom", "Tulus", "3:30", 2016));
    songList.add(new Song("Cupid - Twin Ver.", "FIFTY FIFTY", "2:54", 2023));
    songList.add(new Song("I Wanna Be Yours", "Arctic Monkeys", "3:04", 2013));
    songList.add(new Song("Lantas", "Juicy Luicy", "3:14", 2010));
    songList.add(new Song("Grenade", "Bruno Mars", "3:45", 2010));
    songList.add(new Song("Seandainya", "Vierra", "4:25", 2009));
    songList.add(new Song("What is Love?", "Twice", "3:29", 2018));
    songList.add(new Song("no song without you", "HONNE", "2:40", 2020));
    }
}
