package User;
import java.util.ArrayList;
import Properti.Properti;

public abstract class UserAbs implements UserInt{
protected String username, password;
protected ArrayList<Properti> allproperti = new ArrayList<Properti>();

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String input) {
        this.username = input;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String input) {
        this.password = input;
    }

    @Override
    public void setProperti(Properti pp) {
        allproperti.add(pp);
    }

    @Override
    public void sellProperti(int a) {
        allproperti.remove(a);
    }

    @Override
    public ArrayList<Properti> getProperti() {
        return allproperti;
    }

}
