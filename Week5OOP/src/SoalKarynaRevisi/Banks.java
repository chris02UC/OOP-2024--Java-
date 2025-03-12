package SoalKarynaRevisi;

import java.util.ArrayList;

public class Banks {
    private String bankname;
    private int transactionfee;
    private ArrayList<Account>accounts = new ArrayList<Account>();

    public Banks(String bname, int tfee){
        this.bankname = bname;
        this.transactionfee = tfee;
    }

    public void setbankname(String a){
        this.bankname = a;
    }
    public String getbankname(){
        return this.bankname;
    }
    public void settf(int a){
        this.transactionfee = a;
    }
    public int gettf(){
        return this.transactionfee;
    }

    public void addaccount(Account add){
        accounts.add(add);
    }
    public ArrayList<Account> getaccount(){
        return this.accounts;
    }

}
