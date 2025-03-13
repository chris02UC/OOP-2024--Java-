package Cards;

public class Duke extends Cards{
boolean blockassassin, blocksteal, blockforaid;
int editcoin;

    @Override
    public void blockassassin() {
        this.blockassassin = false;
    }

    @Override
    public void blocksteal() {
        this.blocksteal = false;        
    }

    @Override
    public void blockforaid() {
        this.blockforaid = true;
    }

    @Override
    public int geteditcoin() {
        return this.editcoin;
    }

    @Override
    public void paycoin() {
        editcoin = editcoin;
    }

    @Override
    public void takecoin() {
        this.editcoin = 3;
    }

    @Override
    public boolean statblockassasin() {
        return blockassassin;
    }

    @Override
    public boolean statblocksteal() {
        return blocksteal;
    }

    
    @Override
    public boolean statblockforaid() {
        return blockforaid;
    }    
}
