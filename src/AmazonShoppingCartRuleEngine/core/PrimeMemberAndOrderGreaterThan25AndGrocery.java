package AmazonShoppingCartRuleEngine.core;

import AmazonShoppingCartRuleEngine.api.Rule;
import AmazonShoppingCartRuleEngine.dto.ShoppingCart;

public class PrimeMemberAndOrderGreaterThan25AndGrocery extends Rule<ShoppingCart> {

    public PrimeMemberAndOrderGreaterThan25AndGrocery(int priority) {
        super(priority);
    }

    @Override
    public boolean evaluate(ShoppingCart cart) {

        if(cart.getUser().isPrime() && cart.getTotalPrice()>25 && cart.isGroceryOnly()){
            return true;
        }
        return false;
    }

    @Override
    public void fireRule(ShoppingCart cart) {
        cart.setShippingOfferedInHours(2);
    }
}
