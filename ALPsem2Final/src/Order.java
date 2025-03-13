import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String orderDate;
    private double totalDp;
    private double totalFinal;
    private boolean dpPaid;
    private boolean finalPaid;
    private String status;
    private String trackingNumber;
    private String dpTransactionNumber;
    private String dpBank;
    private String finalTransactionNumber;
    private String finalBank;

    private List<OrderDetail> orderDetails;

    public Order(int id, String username, String orderDate, double totalDp, double totalFinal, boolean dpPaid, boolean finalPaid, String status, String dpBank, String dpTransactionNumber) {
        this.id = id;
        this.username = username;
        this.orderDate = orderDate;
        this.totalDp = totalDp;
        this.totalFinal = totalFinal;
        this.dpPaid = dpPaid;
        this.finalPaid = finalPaid;
        this.status = status;
        this.dpBank = dpBank;
        this.dpTransactionNumber = dpTransactionNumber;
        this.orderDetails = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalDp() {
        return totalDp;
    }

    public void setTotalDp(double totalDp) {
        this.totalDp = totalDp;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    public boolean isDpPaid() {
        return dpPaid;
    }

    public void setDpPaid(boolean dpPaid) {
        this.dpPaid = dpPaid;
    }

    public boolean isFinalPaid() {
        return finalPaid;
    }

    public void setFinalPaid(boolean finalPaid) {
        this.finalPaid = finalPaid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void addOrderDetail(OrderDetail detail) {
        this.orderDetails.add(detail);
    }

    public String getDpTransactionNumber() {
        return dpTransactionNumber;
    }

    public void setDpTransactionNumber(String dpTransactionNumber) {
        this.dpTransactionNumber = dpTransactionNumber;
    }

    public String getFinalTransactionNumber() {
        return finalTransactionNumber;
    }

    public void setFinalTransactionNumber(String finalTransactionNumber) {
        this.finalTransactionNumber = finalTransactionNumber;
    }

    public String getDpBank() {
        return dpBank;
    }

    public void setDpBank(String dpBank) {
        this.dpBank = dpBank;
    }
    
    public String getFinalBank() {
        return finalBank;
    }

    public void setFinalBank(String finalBank) {
        this.finalBank = finalBank;
    }
}
