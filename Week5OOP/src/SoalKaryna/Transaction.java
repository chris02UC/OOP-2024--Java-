package SoalKaryna;

public class Transaction {
    private Account sender, receiver;
    private Banks banksender, bankreceiver;
    private int amount, tf_fee, total_amount;
    private String description, type;

    // public Transaction(Account sender, Account receiver, Banks banksender, Banks bankreceiver, int amount, int total_amount, String description){
    //     this.sender = sender;
    //     this.receiver = receiver;
    //     this.banksender = banksender;
    //     this.bankreceiver = bankreceiver;
    //     this.amount = amount;
    //     this.total_amount = total_amount;
    //     this.description = description;
    // }

    public String gettype(){
    return this.type;
    }
    public void settype(String a){
    this.type = a;
    }


    public Account getsender(){
        return this.sender;
    }
    public void setsender(Account a){
        this.sender = a;
    }
    public Account getreceiver(){
        return this.receiver;
    }
    public void setreceiver(Account a){
        this.receiver = a;
    }
    public Banks getbanksender(){
        return this.banksender;
    }
    public void setbanksender(Banks a){
        this.banksender = a;
    }
    public Banks getbankreceiver(){
        return this.bankreceiver;
    }
    public void setbankreceiver(Banks a){
        this.bankreceiver = a;
    }
    public int getamount(){
        return this.amount;
    }
    public void setamount(int a){
        this.amount = a;
    }
    public int gettf_fee(){
        return this.tf_fee;
    }
    public void settf_fee(int a){
        this.tf_fee = a;
    }
    public int gettotal_amount(){
        return this.total_amount;
    }
    public void settotal_amount(int a){
        this.total_amount = a;
    }
    public String getdesc(){
        return this.description;
    }
    public void setdesc(String a){
        description = a;
    }

}
