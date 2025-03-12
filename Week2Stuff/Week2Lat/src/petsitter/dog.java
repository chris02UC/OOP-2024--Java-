package petsitter;

public class dog {
//    Attibute

    private String name;
    private int happiness, fullness, cleanliness, health, intelligence, amount_food;
    private double age, price;
    private boolean alive;

//    Constructor
    public dog() {
        name = "";
        happiness = 3;
        fullness = 3;
        cleanliness = 3;
        health = 3;
        intelligence = 0;
        amount_food = 10;
        age = 0;
        price = 50;
        alive = true;
    }

//    Function Overloading
    public dog(String name) {
        this.name = name;
        happiness = 3;
        fullness = 3;
        cleanliness = 3;
        health = 3;
        intelligence = 0;
        amount_food = 10;
        age = 0;
        price = 50;
        alive = true;
    }

//    Behavior
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void play() {
        happiness += 2;
        cleanliness -= 2;
        fullness -= 1;

        this.setAlive();
    }

    public void train() {
        happiness -= 2;
        fullness -= 1;
        intelligence += 1;

        this.setAlive();
    }

    public void feed() {
        fullness = 5;

        this.setAlive();
    }

    public void bath() {
        cleanliness = 5;
        happiness -= 3;

        this.setAlive();
    }

    public void sleep() {
        fullness -= 1;
        intelligence -= 1;
        health += 1;
        age += 0.5;

        this.setAlive();
    }

    public void showStatus() {
        System.out.println("\n" + name + " Status");
        System.out.println("happiness: " + happiness);
        System.out.println("fullness: " + fullness);
        System.out.println("cleanliness: " + cleanliness);
        System.out.println("health: " + health);
        System.out.println("intelligence: " + intelligence);
        System.out.println("age: " + age);
        System.out.println("price: " + price);
    }

    private void UpperLimit() {
        if (this.happiness >= 5) {
            this.happiness = 5;
        }

        if (this.fullness >= 5) {
            this.fullness = 5;
        }

        if (this.cleanliness >= 5) {
            this.cleanliness = 5;
        }

        if (this.health >= 5) {
            this.health = 5;
        }
    }

    private void BottomLimit() {
        if (this.happiness < 0) {
            this.happiness = 0;
        }

        if (this.fullness < 0) {
            this.fullness = 0;
        }

        if (this.cleanliness < 0) {
            this.cleanliness = 0;
        }

        if (this.health < 0) {
            this.health = 0;
        }

        if (this.intelligence < 0) {
            this.intelligence = 0;
        }
    }

    private void setAlive() {

        UpperLimit();
        BottomLimit();

        if (this.fullness < 3 || this.cleanliness < 2) {
            this.health -= 1;
        }

        if (this.health <= 0) {
            this.health = 0;
            this.alive = false;
        }
    }

    public double getprice(){
        return price;
    }

    public void dog() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dog'");
    }
    
}
