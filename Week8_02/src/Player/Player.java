package Player;
import java.util.ArrayList;
import java.util.Arrays;
import Cards.Cards;

public class Player {
    protected String playername;
    protected int coin = 2;
    protected Cards card1, card2;

    public String getPlayername() {
        return playername;
    }
    public void setPlayername(String input) {
        this.playername = input;
    }
    public int getCoin() {
        return coin;
    }
    public void setCoin(int editcoin) {
        this.coin += editcoin;
    }
    public Cards getCard1() {
        return card1;
    }
    public void setCard1(Cards rcard) {
        this.card1 = rcard;
    }
    public Cards getCard2() {
        return card2;
    }
    public void setCard2(Cards rcard) {
        this.card2 = rcard;
    }

    
}
