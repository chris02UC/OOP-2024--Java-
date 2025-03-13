package SoalJason;
import java.util.Arrays;

public class User {
    private String name;
    private int money = 100;
    private Boolean ownDF = true;
    private Boolean ownBF = false;
    private Boolean ownMM = false;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void useMoney(int money){
        this.money -= money;
    }
    public void setOwnDF(Boolean ownDF) {
        this.ownDF = ownDF;
    }
    public Boolean getOwnBF() {
        return ownBF;
    }
    public void setOwnBF(Boolean ownBF) {
        this.ownBF = ownBF;
    }
    public Boolean getOwnMM() {
        return ownMM;
    }
    public void setOwnMM(Boolean ownMM) {
        this.ownMM = ownMM;
    }

}
