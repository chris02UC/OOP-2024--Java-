import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<OrderDetail> cartItems;
    private String cUsername;
    private transient Menu menu;

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername;
    }

    public Cart(Menu menu) {
        this.menu = menu;
        this.cartItems = new ArrayList<>();
    }

    public void addItem(OrderDetail item) {
        cartItems.add(item);
    }

    public List<OrderDetail> getCartItems() {
        return cartItems;
    }

    public double calculateTotalDp() {
        double totalDp = 0;
        for (OrderDetail detail : cartItems) {
            Items item = menu.getItemById(detail.getItemID());
            totalDp += item.getDp_price() * detail.getQuantity();
        }
        return totalDp;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (OrderDetail detail : cartItems) {
            Items item = menu.getItemById(detail.getItemID());
            totalPrice += item.getPrice() * detail.getQuantity();
        }
        return totalPrice;
    }

    public void clearCart() {
        cartItems.clear();
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    
}
