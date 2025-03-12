/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsitter2022;

import java.util.ArrayList;

/**
 *
 * @author caeciliacitra
 */
public class Player {

    
  private ArrayList<Dog> pets = new ArrayList<Dog>();
  //private Dog curPet=null;
    private String username;
    private String password;
    private int food_stock, money;
    
    //constructor
    public Player(){
        food_stock = 50;
        money = 100;
    }
    
    //getter setter
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public int getFoodStock(){
        return food_stock;
    }
    
    public int getMoney(){
        return money;
    }
    
    public Dog getPet(String dogname){
        int index = -1;
        for(int i=0; i< pets.size();i++){
            if(pets.get(i).getName().equals(dogname)){
                index = i;
                break;
            }
        }
        //curPet = pets.get(index);
        return pets.get(index);
    }
    
    //public Dog getCurPet(){
      //  return curPet;
    //}
    
    public void setUsername(String username){
        this.username = username;
    }
    
    //methods OR behaviours
    public void addDog(Dog abcPet){
        money = money - abcPet.getPrice();
        pets.add(abcPet);
    }
    
    
    public void dogDies(Dog adog){
        pets.remove(adog);
    }
    
    public void sellDog(Dog adog){
        money = money + adog.getPrice();
        pets.remove(adog);
    }
    
    public void foodStock(int am){
        food_stock = food_stock - am;
    }
    
    public String[] getAllPetNames(){
        String[] names = new String[pets.size()];
        int id = 0;
        for(Dog pet: pets){
            names[id] = pet.getName();
            id++;
        }
        return names;
    }

}
