package petsitter;

public class BeautyDog extends Dog{

    //attribute
    private double hairLength;
    private String hairColor;

    //constructor
    public BeautyDog(String name){
        super(name);
        this.price = 100;
        this.hairLength = 0;
        this.hairColor = "";
    }

    //function
    public double getHairLength(){
        return hairLength;
    }
    public String getHaircolor(){
        return hairColor;
    }

    @Override
    public void bath(){
        cleaniness = 5;
        hairLength += 0.1;
    }

    @Override
    public void showStatus() {
        // System.out.println(name + "'s Status");
        // System.out.println("----------------");
        // System.out.println("Age   : " + age);
        // System.out.println("Price : " + price);
        // System.out.println("Health       : " + health);
        // System.out.println("Happiness    : " + happiness);
        // System.out.println("Fullness     : " + fullness);
        // System.out.println("Cleaness     : " + cleaniness);
        // System.out.println("Intelligence : " + intelligence);
        // System.out.println("Hair length  : "+ hairLength);
        super.showStatus();
        System.out.println("Hair length  : "+ hairLength);
        System.out.println("Hair Color   : "+ hairColor);
    }
}
