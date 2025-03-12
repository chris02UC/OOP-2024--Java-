/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsitter2022;

/**
 *
 * @author caeciliacitra
 */
public class Dog {
  //atributtes
    private String name;
    private double age;
    private int happiness, cleaniness, fullness, intelligence, health, price, food_amount;
    private boolean die = false;
    
 //getter-setter
    public boolean isDie(){
        return die;
    }
    public String getName(){
        return name;
    }
    public double getAge(){
        return age;
    }
    public int getHappiness(){
        return happiness;
    }
    public int getCleniness(){
        return cleaniness;
    }
    public int getFullness(){
        return fullness;
    }
    public int getHealth(){
        return health;
    }
    public int getIntelligence(){
        return intelligence;
    }
    public int getPrice(){
        return price;
    }
    public int getFoodAmount(){
        return food_amount;
    }
    
    public void setName(String name){
        if(name.equalsIgnoreCase("Blacky")) {
            name = null;
        }
        this.name = name;
    }
    
    
//methods
    public void play(){
        //When they play, dogs will gain their happiness by +2, lose their cleaniness by -2 and their fullness by -1
        happiness +=2;
        cleaniness -= 2;
        fullness -= 1;
        if(happiness > 5) happiness = 5;
        if (cleaniness < 0) cleaniness = 0;
        if(fullness < 0) fullness = 0;
        //When dogs’ fullness is below 3 or cleniness is below 2, then their helth decreases by 1
        if(fullness < 3 || cleaniness < 2) health -=1;
        if(health <= 0) die = true;
    }
    public void bath() {
        //When they take a bath, dogs will gain their cleaniness by maximum, but loss their happiness by -1.
        cleaniness = 5;
        happiness -= 3;
        if(happiness < 0 ) happiness = 0;
    }
    public void train(){
        //When they train, dogs will loss their happiness by -2, gain their intelligence by +1, and loss their fullness by -1
        happiness -=2;
        intelligence += 1;
        fullness -=1;
        if(happiness < 0) happiness = 0;
        if(fullness < 0) fullness = 0;
        if(intelligence > 100) intelligence = 100;
        //For each 10 point intelligence increase, the price will be increased by 10%
        if(intelligence % 10 == 0){
            price = price + (int)(0.1*price);
        }
        //When dogs’ fullness is below 3 or cleniness is below 2, then their helth decreases by 1
        if(fullness < 3) health -=1;
        if(health <= 0) die = true;
        
    }
    public void sleep(){
        //When they sleep, dogs will be losw their fullness by -1,gain their health by +1, and age 0.5 years.
        fullness -= 1;
        health += 1;
        age += 0.5;
        if(fullness < 0) fullness = 0;
        if(health > 5) health = 5;
        //When dog ages >3 years, its price decrease by 25%. Age >7 years, price decreses by 50%
        if(age > 7) 
            price = price - (int)(0.5*price);
        else if(age > 3)
               price = price - (int)(0.25*price);
        //When dogs’ fullness is below 3 or cleniness is below 2, then their helth decreases by 1
        if(fullness < 3) health -=1;
        if(health <= 0) die = true;
    }
    
    public int eat(){
        //When they eat, dogs will gain their fullness by maximum (5)
        fullness = 5;
        return food_amount;
    }
    
    //constructor
    public Dog(){
        happiness = 3;
        cleaniness = 3;
        fullness = 3;
        health = 3;
        price = 50;
        food_amount = 10;
    }
    
    public Dog(String name){
        this.name = name;
        happiness = 3;
        cleaniness = 3;
        fullness = 3;
        health = 3;
        price = 50;
        food_amount = 10;
    }
  
}
