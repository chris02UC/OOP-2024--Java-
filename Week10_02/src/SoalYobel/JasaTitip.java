package SoalYobel;

import java.util.LinkedList;
import java.util.Queue;

public class JasaTitip {
    Queue<String> AntrianCust = new LinkedList<String>();
    String namajt;
    Long hargajt;

    public void addCust(String cust){
        AntrianCust.add(cust);
    }
    public int getANsize(){
        return AntrianCust.size();
    }
    public String peekAntrianCust() {
        return AntrianCust.peek();
    }
    public void revolveAntrianCust(){
        AntrianCust.add(AntrianCust.poll());
    }
    public String peekAntrian(){
        return AntrianCust.peek();
    }
    public void enqueueAntrian(String cust){
        AntrianCust.add(cust);
    }
    public String dequeueAntrian(){
        return AntrianCust.remove();
    }
    public void setAntrianCust(Queue<String> antrianCust) {
        AntrianCust = antrianCust;
    }
    public String getNamajt() {
        return namajt;
    }
    public void setNamajt(String namajt) {
        this.namajt = namajt;
    }
    public Long getHargajt() {
        return hargajt;
    }
    public void setHargajt(Long hargajt) {
        this.hargajt = hargajt;
    }
    public void minusHargajt(Long hargajt){
        this.hargajt -= hargajt;
    }

}
