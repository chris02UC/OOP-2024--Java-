import java.io.Serializable;

public class Admin extends Account implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public Admin() {
        this.accountType = "admin";
    }

}
