package SoalIanToTes;
import java.util.Scanner;
import java.util.ArrayList;


public class Menu {
    ArrayList<Aquarium> Allaqua = new ArrayList<Aquarium>();
    double money;
    double margin_profit;

    public void startapp(){
    Scanner s = new Scanner(System.in);
    System.out.println("Hi Rinaldy!");
    System.out.print("Enter your money : ");
    money = s.nextDouble();
        while (money <= 0){
        System.out.print("Input not valid! Enter your money : ");
        money = s.nextDouble();
        }
    System.out.print("Enter your desired margin of profit : ");
    margin_profit = s.nextDouble();
    while (margin_profit <= 0){
        System.out.print("Input not valid! Input margin of profit : ");
        margin_profit = s.nextDouble();
    }
    while (true){
    System.out.println("###################################\n\n");
    System.out.println("Hi Rinaldy!");
    System.out.println("Your money : $"+money);
    System.out.println("Your desired margin profit : "+margin_profit);
    System.out.println("What do you want to do?\n1. Make Aquarium\n2. See Aquarium Detail\n3. Sell Aquarium\n4. Change margin of profit\n0. Exit");
    System.out.print("Choose: ");
    String choicemenu = s.next()+s.nextLine();

    switch (choicemenu){
    case "1":
    String mrc = "";
    while (!mrc.equalsIgnoreCase("m") && !mrc.equalsIgnoreCase("c")){
    System.out.println("\nChoose a shape: \n1. Cube\n2. Block\n3. Upside down Pyramid\n4. Tube\n0. Cancel");
    System.out.print("Choose: ");
    int chooseshape = s.nextInt();
    while (chooseshape < 0 || chooseshape > 4){
        System.out.print("Input not valid! Choose: ");
        chooseshape = s.nextInt();
    }
    if (chooseshape == 1){
    System.out.print("Input length: ");
    Double inputlength = s.nextDouble();
        while (inputlength <= 0){
        System.out.print("Input not valid! Input length: ");
        inputlength = s.nextDouble();
        }
    Cube c = new Cube();
    c.setlength(inputlength);
    c.calcsurfacearea();
    c.calcvolume();
    c.calc_price();
    System.out.println("Surface area of the cube aquarium is "+c.getsurface_area());
    System.out.println("Volume of the cube aquarium is "+c.getvolume());
    System.out.println("Price to make is $"+c.getprice()+", do you want to make, redo, or cancel? (M/R/C)");
    System.out.print("Choice: ");
        mrc = s.next()+s.nextLine();
        while (!mrc.equalsIgnoreCase("m") && !mrc.equalsIgnoreCase("r") && !mrc.equalsIgnoreCase("c")){
        System.out.print("Input not valid! Choice: ");
        mrc = s.next()+s.nextLine();
        }
    if (mrc.equalsIgnoreCase("m")){
            if (c.price > money){
            System.out.println("Insufficient Money!");
            break;
            }
    money -= c.getprice();
    Allaqua.add(c);
    System.out.println("Successful");
    break;
    } else if (mrc.equalsIgnoreCase("r")){
        //continue
    }else if (mrc.equalsIgnoreCase("c")){
    System.out.println("Canceled");
    break;
    }
    //end of cube
    } else if (chooseshape == 2){
    System.out.print("Input length: ");
    Double inputlength = s.nextDouble();
    while (inputlength <= 0){
        System.out.print("Input not valid! Input length: ");
        inputlength = s.nextDouble();
        }
    System.out.print("Input Width: ");
    Double inputwidth = s.nextDouble();
    while (inputwidth <= 0){
        System.out.print("Input not valid! Input Width: ");
        inputwidth = s.nextDouble();
        }
    System.out.print("Input Height: ");
    Double inputheight = s.nextDouble();
    while (inputheight <= 0){
        System.out.print("Input not valid! Input Height: ");
        inputheight = s.nextDouble();
        }
    Block b = new Block();
    b.setlength(inputlength);
    b.setwidth(inputwidth);
    b.setheight(inputheight);
    b.calcsurfacearea();
    b.calcvolume();
    b.calc_price();
    System.out.println("Surface area of the block aquarium is "+b.getsurface_area());
    System.out.println("Volume of the block aquarium is "+b.getvolume());
    System.out.println("Price to make is $"+b.getprice()+", do you want to make, redo, or cancel? (M/R/C)");
    System.out.print("Choice: ");
        mrc = s.next()+s.nextLine();
        while (!mrc.equalsIgnoreCase("m") && !mrc.equalsIgnoreCase("r") && !mrc.equalsIgnoreCase("c")){
        System.out.print("Input not valid! Choice: ");
        mrc = s.next()+s.nextLine();
        }
    if (mrc.equalsIgnoreCase("m")){
        if (b.price > money){
            System.out.println("Insufficient Money!");
            break;
            }
    money -= b.getprice();
    Allaqua.add(b);
    System.out.println("Successful");
    break;
    } else if (mrc.equalsIgnoreCase("r")){
        //continue
    }else if (mrc.equalsIgnoreCase("c")){
    System.out.println("Canceled");
    break;
    }

    } else if (chooseshape == 3){
    System.out.print("Input length: ");
    Double inputlength = s.nextDouble();
    while (inputlength <= 0){
        System.out.print("Input not valid! Input length: ");
        inputlength = s.nextDouble();
        }
    System.out.print("Input Width: ");
    Double inputwidth = s.nextDouble();
    while (inputwidth <= 0){
        System.out.print("Input not valid! Input Width: ");
        inputwidth = s.nextDouble();
        }
    System.out.print("Input Height: ");
    Double inputheight = s.nextDouble();
    while (inputheight <= 0){
        System.out.print("Input not valid! Input Height: ");
        inputheight = s.nextDouble();
        }
    UDpyramid udp = new UDpyramid();
    udp.setlength(inputlength);
    udp.setwidth(inputwidth);
    udp.setheight(inputheight);
    udp.calcsurfacearea();
    udp.calcvolume();
    udp.calc_price();
    System.out.println("Surface area of the upside-down pyramid aquarium is "+udp.getsurface_area());
    System.out.println("Volume of the upside-down pyramid aquarium is "+udp.getvolume());
    System.out.println("Price to make is $"+udp.getprice()+", do you want to make, redo, or cancel? (M/R/C)");
    System.out.print("Choice: ");
        mrc = s.next()+s.nextLine();
        while (!mrc.equalsIgnoreCase("m") && !mrc.equalsIgnoreCase("r") && !mrc.equalsIgnoreCase("c")){
        System.out.print("Input not valid! Choice: ");
        mrc = s.next()+s.nextLine();
        }
    if (mrc.equalsIgnoreCase("m")){
        if (udp.price > money){
            System.out.println("Insufficient Money!");
            break;
            }
    money -= udp.getprice();
    Allaqua.add(udp);
    System.out.println("Successful");
    break;
    } else if (mrc.equalsIgnoreCase("r")){
        //continue
    }else if (mrc.equalsIgnoreCase("c")){
    System.out.println("Canceled");
    break;
    }

    } else if (chooseshape == 4){
    System.out.print("Input diameter: ");
    Double inputdiameter = s.nextDouble();
    while (inputdiameter <= 0){
        System.out.print("Input not valid! Input diameter: ");
        inputdiameter = s.nextDouble();
        }
    System.out.print("Input Height: ");
    Double inputheight = s.nextDouble();
    while (inputheight <= 0){
        System.out.print("Input not valid! Input Height: ");
        inputheight = s.nextDouble();
        }
    Tube t = new Tube();
    t.setdiameter(inputdiameter);
    t.setheight(inputheight);
    t.calcsurfacearea();
    t.calcvolume();
    t.calc_price();
    System.out.println("Surface area of the tube aquarium is "+t.getsurface_area());
    System.out.println("Volume of the tube aquarium is "+t.getvolume());
    System.out.println("Price to make is $"+t.getprice()+", do you want to make, redo, or cancel? (M/R/C)");
    System.out.print("Choice: ");
        mrc = s.next()+s.nextLine();
        while (!mrc.equalsIgnoreCase("m") && !mrc.equalsIgnoreCase("r") && !mrc.equalsIgnoreCase("c")){
        System.out.print("Input not valid! Choice: ");
        mrc = s.next()+s.nextLine();
        }
    if (mrc.equalsIgnoreCase("m")){
        if (t.price > money){
            System.out.println("Insufficient Money!");
            break;
            }
    money -= t.getprice();
    Allaqua.add(t);
    System.out.println("Successful");
    break;
    } else if (mrc.equalsIgnoreCase("r")){
        //continue
    }else if (mrc.equalsIgnoreCase("c")){
    System.out.println("Canceled");
    break;
    }

    } else if (chooseshape == 0){
    System.out.println("Cancelling.....");
    break;
    }
    }//while mrc not r
    break;

    case "2":
        if (Allaqua.size() == 0){
        System.out.println("You have no aquarium! Same as Valen :v");
        break;
        }
    for (int a = 0; a < Allaqua.size(); a++){
        if (Allaqua.get(a) instanceof Cube){
        System.out.println((a+1)+". Type: Cube, you spend: $"+Allaqua.get(a).getprice());
        } else if (Allaqua.get(a) instanceof Block){
        System.out.println((a+1)+". Type: Block, you spend: $"+Allaqua.get(a).getprice());
        } else if (Allaqua.get(a).getClass().equals(UDpyramid.class)){
        System.out.println((a+1)+". Type: Inverted Pyramid, you spend: $"+Allaqua.get(a).getprice());
        } else if (Allaqua.get(a).getClass().equals(Tube.class)){
        System.out.println((a+1)+". Type: Tube, you spend: $"+Allaqua.get(a).getprice());
        }
    }

    System.out.println("0. Back");
    System.out.print("Choose: ");
    int choosedetails = s.nextInt();
    while (choosedetails < 0 || choosedetails > Allaqua.size()){
        System.out.print("Input not available! Choose: ");
        choosedetails = s.nextInt();
    }
        if (choosedetails == 0){
        System.out.println("Back to menu...");
        break;
        }

    if (Allaqua.get(choosedetails-1).getClass().equals(Cube.class)){
        System.out.println("Type: Cube");
        System.out.println("Length: "+Allaqua.get(choosedetails-1).getlength());
        System.out.println("Surface Area: "+Allaqua.get(choosedetails-1).getsurface_area());
        System.out.println("Volume: "+Allaqua.get(choosedetails-1).getvolume());
        System.out.println("Crafting price: $"+Allaqua.get(choosedetails-1).getprice());
        System.out.println("Selling price: $"+ (Allaqua.get(choosedetails-1).getprice() + (Allaqua.get(choosedetails-1).getprice() * margin_profit)));
    } else if (Allaqua.get(choosedetails-1).getClass().equals(Block.class)){
        System.out.println("Type: Block");
        System.out.println("Length: "+Allaqua.get(choosedetails-1).getlength());
        System.out.println("Width: "+Allaqua.get(choosedetails-1).getwidth());
        System.out.println("Height: "+Allaqua.get(choosedetails-1).getheight());
        System.out.println("Surface Area: "+Allaqua.get(choosedetails-1).getsurface_area());
        System.out.println("Volume: "+Allaqua.get(choosedetails-1).getvolume());
        System.out.println("Crafting price: $"+Allaqua.get(choosedetails-1).getprice());
        System.out.println("Selling price: $"+ (Allaqua.get(choosedetails-1).getprice() + (Allaqua.get(choosedetails-1).getprice() * margin_profit)));
    } else if (Allaqua.get(choosedetails-1).getClass().equals(UDpyramid.class)){
        System.out.println("Type: Inverted Pyramid");
        System.out.println("Length: "+Allaqua.get(choosedetails-1).getlength());
        System.out.println("Width: "+Allaqua.get(choosedetails-1).getwidth());
        System.out.println("Height: "+Allaqua.get(choosedetails-1).getheight());
        System.out.println("Surface Area: "+Allaqua.get(choosedetails-1).getsurface_area());
        System.out.println("Volume: "+Allaqua.get(choosedetails-1).getvolume());
        System.out.println("Crafting price: $"+Allaqua.get(choosedetails-1).getprice());
        System.out.println("Selling price: $"+ (Allaqua.get(choosedetails-1).getprice() + (Allaqua.get(choosedetails-1).getprice() * margin_profit)));
    } else if (Allaqua.get(choosedetails-1).getClass().equals(Tube.class)){
        System.out.println("Type: Tube");
        System.out.println("Diameter: "+Allaqua.get(choosedetails-1).getdiameter());
        System.out.println("Height: "+Allaqua.get(choosedetails-1).getheight());
        System.out.println("Surface Area: "+Allaqua.get(choosedetails-1).getsurface_area());
        System.out.println("Volume: "+Allaqua.get(choosedetails-1).getvolume());
        System.out.println("Crafting price: $"+Allaqua.get(choosedetails-1).getprice());
        System.out.println("Selling price: $"+ (Allaqua.get(choosedetails-1).getprice() + (Allaqua.get(choosedetails-1).getprice() * margin_profit)));
    } 
    break;
    
    case "3":
    if (Allaqua.size() == 0){
        System.out.println("You have no aquarium! Same as Valen :v");
        break;
        }
    for (int a = 0; a < Allaqua.size(); a++){
        if (Allaqua.get(a) instanceof Cube){
        System.out.println((a+1)+". Type: Cube, Selling price: $"+(Allaqua.get(a).getprice()+(Allaqua.get(a).getprice()*margin_profit)));
        } else if (Allaqua.get(a) instanceof Block){
        System.out.println((a+1)+". Type: Block, Selling price: $"+(Allaqua.get(a).getprice()+(Allaqua.get(a).getprice() * margin_profit)));
        } else if (Allaqua.get(a).getClass().equals(UDpyramid.class)){
        System.out.println((a+1)+". Type: Inverted Pyramid, Selling price: $"+(Allaqua.get(a).getprice() + (Allaqua.get(a).getprice() * margin_profit)));
        } else if (Allaqua.get(a).getClass().equals(Tube.class)){
        System.out.println((a+1)+". Type: Tube, Selling price: $"+(Allaqua.get(a).getprice()+(Allaqua.get(a).getprice()*margin_profit)));
        }
    }
    System.out.println("0. Exit");
    System.out.print("Choose: ");
    int choosetosell = s.nextInt();
    while (choosetosell < 0 || choosetosell > Allaqua.size()){
        System.out.print("Input not available! Choose: ");
        choosetosell = s.nextInt();
    }
        if (choosetosell == 0){
        System.out.println("Back to menu...");
        break;
        }
        
    if (Allaqua.get(choosetosell-1).getClass().equals(Cube.class)){
        money += (Allaqua.get(choosetosell-1).getprice() + (Allaqua.get(choosetosell-1).getprice() * margin_profit));
        System.out.println("Cube Aquarium sucessfully sold for $"+(Allaqua.get(choosetosell-1).getprice() + (Allaqua.get(choosetosell-1).getprice() * margin_profit)));
        Allaqua.remove(choosetosell-1);
    } else if (Allaqua.get(choosetosell-1).getClass().equals(Block.class)){
        money += (Allaqua.get(choosetosell-1).getprice() + (Allaqua.get(choosetosell-1).getprice() * margin_profit));
        System.out.println("Block Aquarium sucessfully sold for $"+(Allaqua.get(choosetosell-1).getprice() + (Allaqua.get(choosetosell-1).getprice() * margin_profit)));
        Allaqua.remove(choosetosell-1);
    } else if (Allaqua.get(choosetosell-1).getClass().equals(UDpyramid.class)){
        money += (Allaqua.get(choosetosell-1).getprice() + (Allaqua.get(choosetosell-1).getprice() * margin_profit));
        System.out.println("Inverted Pyramid Aquarium sucessfully sold for $"+(Allaqua.get(choosetosell-1).getprice() + (Allaqua.get(choosetosell-1).getprice() * margin_profit)));
        Allaqua.remove(choosetosell-1);
    } else if (Allaqua.get(choosetosell-1).getClass().equals(Tube.class)){
        money += (Allaqua.get(choosetosell-1).getprice() + (Allaqua.get(choosetosell-1).getprice() * margin_profit));
        System.out.println("Tube Aquarium sucessfully sold for $"+(Allaqua.get(choosetosell-1).getprice() + (Allaqua.get(choosetosell-1).getprice() * margin_profit)));
        Allaqua.remove(choosetosell-1);
    }
    // if (choosetosell > 0 && choosetosell <= collcube.size()){
    //     money += (collcube.get(choosetosell-1).getprice() + (collcube.get(choosetosell-1).getprice() * margin_profit));
    //     System.out.println("Aquarium sucessfully sold for $"+(collcube.get(choosetosell-1).getprice() + (collcube.get(choosetosell-1).getprice() * margin_profit)));
    //     collcube.remove(choosetosell-1);
    //     } else if (choosetosell > collcube.size() && choosetosell <= collcube.size()+collblock.size() ){
    //     money += (collblock.get(choosetosell-(1+collcube.size())).getprice() + (collblock.get(choosetosell-(1+collcube.size())).getprice() * margin_profit));
    //     System.out.println("Aquarium sucessfully sold for $"+(collblock.get(choosetosell-(1+collcube.size())).getprice() + (collblock.get(choosetosell-(1+collcube.size())).getprice() * margin_profit)));
    //     collblock.remove(choosetosell-(1+collcube.size()));
    //     } else if (choosetosell > collcube.size()+collblock.size() && choosetosell <= collcube.size()+collblock.size()+collUDP.size()){
    //     money += (collUDP.get(choosetosell-(1+collcube.size()+collblock.size())).getprice() + (collUDP.get(choosetosell-(1+collcube.size()+collblock.size())).getprice() * margin_profit));
    //     System.out.println("Aquarium sucessfully sold for $"+(collUDP.get(choosetosell-(1+collcube.size()+collblock.size())).getprice() + (collUDP.get(choosetosell-(1+collcube.size()+collblock.size())).getprice() * margin_profit)));
    //     collUDP.remove(choosetosell-(1+collcube.size()+collblock.size()));
    //     } else if (choosetosell > collcube.size()+collblock.size()+collUDP.size() && choosetosell <= collcube.size()+collblock.size()+collUDP.size()+colltube.size()){
    //     money += (colltube.get(choosetosell-(1+collcube.size()+collblock.size()+collUDP.size())).getprice() + (colltube.get(choosetosell-(1+collcube.size()+collblock.size()+collUDP.size())).getprice() * margin_profit));
    //     System.out.println("Aquarium sucessfully sold for $"+(colltube.get(choosetosell-(1+collcube.size()+collblock.size()+collUDP.size())).getprice() + (colltube.get(choosetosell-(1+collcube.size()+collblock.size()+collUDP.size())).getprice() * margin_profit)));
    //     colltube.remove(choosetosell-(1+collcube.size()+collblock.size()+collUDP.size()));
    //     }
    break;

    case "4":
    System.out.print("\nWhat is your new margin of profit? : ");
    double newmp = s.nextDouble();
    while (newmp <= 0){
        System.out.print("Input not valid! Input new margin of profit : ");
        newmp = s.nextDouble();
    }
    margin_profit = newmp;
    break;

    case "0":
    System.out.println("See you next time!");
    System.exit(0);
    break;
    
    default:
    System.out.println("Input not valid!");
    break;
    }
    } // while true
    }
}
