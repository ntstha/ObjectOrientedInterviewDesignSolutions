package core;

import api.Rule;
import dto.ShoppingCart;

public class PrimeMemberAndOrderGreaterThan125 extends Rule<ShoppingCart> {

    public PrimeMemberAndOrderGreaterThan125(int priority) {
        super(priority);
    }

    @Override
    public boolean evaluate(ShoppingCart cart) {
        if(cart.getUser().isPrime() && cart.getTotalPrice()>125){
            return true;
        }
        return false;
    }

    @Override
    public void fireRule(ShoppingCart cart) {
         cart.setShippingOfferedInHours(24);
    }
}
