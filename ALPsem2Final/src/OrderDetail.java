import java.io.Serializable;

public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int orderId;
    private String itemID;
    private int quantity;
    
    public OrderDetail(int id, int orderId, String itemID, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.itemID = itemID;
        this.quantity = quantity;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public String getItemID() {
        return itemID;
    }
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}