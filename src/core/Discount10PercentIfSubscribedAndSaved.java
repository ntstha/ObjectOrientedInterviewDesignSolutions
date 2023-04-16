package core;

import api.Rule;
import dto.Item;
import dto.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Discount10PercentIfSubscribedAndSaved extends Rule<ShoppingCart> {

    List<Item> applicableItems = new ArrayList<Item>();

    public Discount10PercentIfSubscribedAndSaved(int priority) {
        super(priority);
    }

    @Override
    public boolean evaluate(ShoppingCart cart) {

        for(Item item:cart.getItems()){
            if(item.isSubscribed()){
                applicableItems.add(item);
            }
        }

        if(applicableItems.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public void fireRule(ShoppingCart bean) {
        for(Item item:applicableItems){
            System.out.println("Discount applied on item id :"+item.getItemId()+" from class "+this.getClass().getName());
            item.setDiscountedPrice(item.getPrice() - 0.1 * item.getPrice());
        }
    }


}
