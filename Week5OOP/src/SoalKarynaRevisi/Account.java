package SoalKarynaRevisi;
import java.util.ArrayList;

public class Account {
    private String name, PIN, tphonenumber;
    private int account_id, balance;
    private ArrayList<Transaction> History = new ArrayList<Transaction>();

    public ArrayList<Transaction> gethistory(){
        return History;
    }
    public void addhistory(Transaction add){
        History.add(add);
    }
    public void setname(String a){
        this.name = a;
    }
    public String getname(){
        return this.name;
    }

    public void setPIN(String a){
        this.PIN = a;
    }
    public String getPIN(){
        return this.PIN;
    }

    public void settphonenumber(String a){
        this.tphonenumber = a;
    }
    public String gettphonenumber(){
        return this.tphonenumber;
    }

    public void setaccount_id(int a){
        this.account_id = a;
    }
    public int getaccount_id(){
        return this.account_id;
    }

    public void setbalance(int a){
        this.balance = a;
    }
    public int getbalance(){
        return this.balance;
    }

    public void transfermoney(int a){
        this.balance -=a;
    }
    public void depositmoney(int a){
        this.balance +=a;
    }
    public void withdrawmoney(int a){
        this.balance -=a;
    }
    public void receivemoney(int a){
        this.balance +=a;
    }
}
