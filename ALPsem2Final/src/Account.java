import java.io.Serializable;

public class Account implements Serializable{
    private static final long serialVersionUID = 1L;
    
    protected int id;
    protected String username;
    protected String password;
    protected String address;
    protected String accountType;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}