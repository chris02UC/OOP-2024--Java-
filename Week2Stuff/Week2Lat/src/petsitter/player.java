package petsitter;
import java.util.ArrayList;

public class player {
    private int foodstock;
    private double money;
    private ArrayList<dog> pets = new ArrayList<dog>();

    public player(){
        foodstock = 50;
        money = 100;
    }


    //buy dog, money decrease
    public void buydog(dog newdog){
        pets.add(newdog);
        //subtract money with dog price
        money = money - newdog.getprice();
    }

    public void selldog(dog solddog){
        pets.remove(solddog);
        money += solddog.getprice();
    }

    public int getpetnumber(){
        return pets.size();
    }

    public void showpetname(){
    int no = 1;
    for (dog d: pets){
        System.out.println(no+ ". " +d.getName());
        no++;
    }
    }

    public dog getdogarraylist(int index){
    return pets.get(index); //get index from arraylist
    }
}
