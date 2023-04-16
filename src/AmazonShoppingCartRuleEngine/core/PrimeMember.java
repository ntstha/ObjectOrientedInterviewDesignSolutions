package AmazonShoppingCartRuleEngine.core;

import AmazonShoppingCartRuleEngine.api.Rule;
import AmazonShoppingCartRuleEngine.dto.ShoppingCart;

public class PrimeMember extends Rule<ShoppingCart> {

    public PrimeMember(int priority) {
        super(priority);
    }

    @Override
    public boolean evaluate(ShoppingCart cart) {
        if(cart.getUser().isPrime()){
            return true;
        }
        return false;
    }

    @Override
    public void fireRule(ShoppingCart cart) {
        cart.setShippingOfferedInHours(2*24);
    }
}
