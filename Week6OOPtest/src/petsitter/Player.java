package petsitter;

import java.util.ArrayList;

public class Player {

    private int foodStock;
    private double money;
    private String username;
    private String password;
    private ArrayList<Dog> pets = new ArrayList<>();

    public Player() {
        foodStock = 50;
        money = 100;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    //buy dog, mobey will decrease
    public void buyADog(Dog newDog) {
        pets.add(newDog);
        // substract money with dog's price
        money = money - newDog.getPrice();
    }

    public void sellADog(Dog soldDog) {
        pets.remove(soldDog);
        money += soldDog.getPrice();
    }

    public int getPetsNumber() {
        return pets.size();
    }

    public void showPetsNames() {
        int no = 1;
        for (Dog d : pets) {
            System.out.println(no + ". " + d.getName());
            no++;
        }
    }

    public Dog getADog(int index) {
        return pets.get(index);
    }

    public void decreaseFoogStock(int amount) {
        foodStock -= amount;
    }

}
