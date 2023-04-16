package AmazonShoppingCartRuleEngine.core;

import AmazonShoppingCartRuleEngine.api.Rule;
import AmazonShoppingCartRuleEngine.dto.ShoppingCart;

public class PrimeMemberAndOrderGreaterThan100AndGrocery extends Rule<ShoppingCart> {
    public PrimeMemberAndOrderGreaterThan100AndGrocery(int priority) {
        super(priority);
    }

    @Override
    public boolean evaluate(ShoppingCart cart) {
        if(cart.getUser().isPrime() && cart.getTotalPrice()>100 && cart.isGroceryOnly()){
            return true;
        }
        return false;
    }

    @Override
    public void fireRule(ShoppingCart cart) {
        cart.setShippingOfferedInHours(1);
    }
}
