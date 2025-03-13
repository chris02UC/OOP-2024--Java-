import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer extends Account implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<Order> orders;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Customer() {
    this.orders = new ArrayList<>();
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    public void addOrder(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
    }

    public void removeOrder(Order order) {
        if (orders != null) {
            orders.remove(order);
        }
    }

    public int getTotalOrdersCount() {
        if (orders == null) {
            return 0;
        }
        return orders.size();
    }

    public double getTotalAmountSpent() {
        double totalAmount = 0.0;
        if (orders != null) {
            for (Order order : orders) {
                totalAmount += order.getTotalDp();
                if (order.isFinalPaid()) {
                    totalAmount += order.getTotalFinal();
                }
            }
        }
        return totalAmount;
    }

    public void resetOrders() {
        if (orders != null) {
            orders.clear();
        }
    }
}
