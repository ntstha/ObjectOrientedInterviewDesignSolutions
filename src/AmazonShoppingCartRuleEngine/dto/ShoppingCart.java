package AmazonShoppingCartRuleEngine.dto;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private User user;
    private List<Item> items = new ArrayList<Item>();
    private int shippingOfferedInHours=7*24;

    public ShoppingCart(User user,List<Item> items){
        this.user = user;
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalPrice(){
        double result = 0;

        for(Item item:items){
            result +=item.getDiscountedPrice();
        }
        return result;
    }

    public boolean isGroceryOnly(){
        for(Item item:items){
            if(!item.isGrocery()){
                return false;
            }
        }

        return true;
    }

    public int getShippingOfferedInHours() {
        return shippingOfferedInHours;
    }

    public void setShippingOfferedInHours(int shippingOfferedInHours) {
        this.shippingOfferedInHours = shippingOfferedInHours;
    }
}
