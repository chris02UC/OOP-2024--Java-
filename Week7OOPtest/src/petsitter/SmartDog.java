package petsitter;

public class SmartDog extends Dog{

    public SmartDog(String name){
        super(name);
        this.price = 60;
        this.food_amount = 15;
    }

    @Override
    public void train(){ // add override annotation?
        //When they train, dogs will loss their happiness by -2, gain their intelligence by +1, and loss their fullness by -1
        intelligence += 2;
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
}
