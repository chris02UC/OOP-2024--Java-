package petsitter;

public class Dog {

    protected String name;
    protected int fullness, happiness, cleaniness, health, intelligence;
    protected double age, price;
    protected int food_amount;
    protected boolean die = false;
    protected int lipi; //this is not an atribute. This is just a helpful variable to check the increasing price;
    protected boolean dec3yo, dec7yo; //these are not attributes of Dog. They are help variables to check whether proce has been decreased once the dog reaches age of 3 and 7 yoa
    //constructor

    public Dog() {
        happiness = 3;
        cleaniness = 3;
        fullness = 3;
        health = 3;
        price = 50;
        food_amount = 10;
    }

    public Dog(String name) {
        this.name = name;
        happiness = 3;
        cleaniness = 3;
        fullness = 3;
        health = 3;
        price = 50;
        food_amount = 10;
    }

    //behaiors
    public void play() {
        //When they play, dogs will gain their happiness by +2, lose their cleaniness by -2 and their fullness by -1
        happiness += 2;
        cleaniness -= 2;
        fullness -= 1;
        if (happiness > 5) {
            happiness = 5;
        }
        if (cleaniness < 0) {
            cleaniness = 0;
        }
        if (fullness < 0) {
            fullness = 0;
        }
        //When dogs’ fullness is below 3 or cleniness is below 2, then their helth decreases by 1
        if (fullness < 3 || cleaniness < 2) {
            health -= 1;
        }
        if (health <= 0) {
            die = true;
        }
    }

    public void bath() {
        //When they take a bath, dogs will gain their cleaniness by maximum, but loss their happiness by -1.
        cleaniness = 5;
        happiness -= 3;
        if (happiness < 0) {
            happiness = 0;
        }
    }

    public void train() {
        //When they train, dogs will loss their happiness by -2, gain their intelligence by +1, and loss their fullness by -1
        happiness -= 2;
        intelligence += 1;
        fullness -= 1;
        if (happiness < 0) {
            happiness = 0;
        }
        if (fullness < 0) {
            fullness = 0;
        }
        if (intelligence > 100) {
            intelligence = 100;
        }
        //For each 10 point intelligence increase, the price will be increased by 10%
        changePrice();
        //When dogs’ fullness is below 3 or cleniness is below 2, then their helth decreases by 1
        if (fullness < 3) {
            health -= 1;
        }
        if (health <= 0) {
            die = true;
        }

    }

    public void sleep() {
        //When they sleep, dogs will be losw their fullness by -1,gain their health by +1, and age 0.5 years.
        fullness -= 1;
        health += 1;
        age += 0.5;
        if (fullness < 0) {
            fullness = 0;
        }
        if (health > 5) {
            health = 5;
        }
        changePrice();
        //When dogs’ fullness is below 3 or cleniness is below 2, then their helth decreases by 1
        if (fullness < 3) {
            health -= 1;
        }
        if (health <= 0) {
            die = true;
        }
    }

    public void eat() {
        //When they eat, dogs will gain their fullness by maximum (5)
        fullness = 5;

    }

    public void showStatus() {
        System.out.println(name + "'s Status");
        System.out.println("----------------");
        System.out.println("Age   : " + age);
        System.out.println("Price : " + price);
        System.out.println("Health       : " + health);
        System.out.println("Happiness    : " + happiness);
        System.out.println("Fullness     : " + fullness);
        System.out.println("Cleaness     : " + cleaniness);
        System.out.println("Intelligence : " + intelligence);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    //this is a method that only be invoked inside this class, that is why it is private.
    //this method will change price of a dog based on its age and intelligence
    public void changePrice() {
        //price will increase 10% when intelligence increase by 10.
        if (intelligence - lipi >= 10) {
            price += 0.1 * price;
            lipi = intelligence;
        }

        if (age > 7) {
            if (!dec7yo) {
                price -= 0.5 * price;
                dec7yo = true; // make it true so the price won't keep decreasing.
            }
        } else if (age > 3) {
            if (dec3yo == false) {
                price -= 0.25 * price;
                dec3yo = true; // make it true so the price won't keep decreasing.
            }
        }

    }

    public int getFoodAmount() {
        return food_amount;
    }
}
