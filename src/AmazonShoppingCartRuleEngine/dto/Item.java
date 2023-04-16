package AmazonShoppingCartRuleEngine.dto;

public class Item {
    String name;
    long itemId;
    double price;
    boolean isGrocery;
    double discountedPrice;
    boolean isSubscribed;

    public Item(String name, long itemId, double price, boolean isGrocery,boolean isSubscribed) {
        this.name = name;
        this.itemId = itemId;
        this.price = price;
        this.isGrocery = isGrocery;
        this.discountedPrice = price;
        this.isSubscribed = isSubscribed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isGrocery() {
        return isGrocery;
    }

    public void setGrocery(boolean grocery) {
        isGrocery = grocery;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }
}
