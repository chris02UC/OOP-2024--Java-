import java.io.Serializable;

public class Items implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected String itemID;
    protected String brand;
    protected String scale;
    protected String name;
    protected String description;
    protected double price;
    protected double dp_price;
    protected double lunas_price;
    protected String maxPoDate;
    protected String estimatedTimeOfArrival;
    protected int slots;
    protected String status;

    // Constructor
    public Items() {
        // Constructor
    }

    // Constructor with parameters
    public Items(String itemID,String brand, String name, String scale, String description, double price, double dp_price, String maxPoDate, String estimatedTimeOfArrival, int slots, String status) {
        this.itemID = itemID ;
        this.brand = brand;
        this.name = name;
        this.scale = scale;
        this.description = description;
        this.price = price;
        this.dp_price = dp_price;
        this.maxPoDate = maxPoDate;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.slots = slots;
        this.status = status;
        this.lunas_price = price - dp_price;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaxPODate() {
        return maxPoDate;
    }

    public void setMaxPODate(String maxPODate) {
        this.maxPoDate = maxPODate;
    }

    public String getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }

    public void setEstimatedTimeOfArrival(String estimatedTimeOfArrival) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDp_price() {
        return dp_price;
    }

    public void setDp_price(double dp_price) {
        this.dp_price = dp_price;
    }

    public double getLunas_price() {
        return lunas_price;
    }

    public void setLunas_price(double lunas_price) {
        this.lunas_price = lunas_price;
    }

    public String getMaxPoDate() {
        return maxPoDate;
    }

    public void setMaxPoDate(String maxPoDate) {
        this.maxPoDate = maxPoDate;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

}
