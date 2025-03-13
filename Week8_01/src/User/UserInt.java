package User;
import java.util.ArrayList;
import Properti.Properti;

public interface UserInt {
    String getUsername();
    void setUsername(String us);
    String getPassword();
    void setPassword(String pw);
    ArrayList<Properti> getProperti();
    void setProperti(Properti pp);
    void sellProperti(int i);
}
