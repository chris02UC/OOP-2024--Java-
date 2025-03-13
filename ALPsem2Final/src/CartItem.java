public class CartItem {
    private int userId;
    private int itemId;
    private int quantity;
    private double dpPrice;

    public CartItem(int userId, int itemId, int quantity, double dpPrice) {
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.dpPrice = dpPrice;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDpPrice() {
        return dpPrice;
    }

    public void setDpPrice(double dpPrice) {
        this.dpPrice = dpPrice;
    }
}
