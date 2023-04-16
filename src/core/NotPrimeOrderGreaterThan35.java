package core;

import api.Rule;
import dto.ShoppingCart;

public class NotPrimeOrderGreaterThan35 extends Rule<ShoppingCart> {

    public NotPrimeOrderGreaterThan35(int priority) {
        super(priority);
    }

    @Override
    public boolean evaluate(ShoppingCart cart) {

        if(cart.getUser().isPrime() && cart.getTotalPrice()>35){
            return true;
        }

        return false;
    }

    @Override
    public void fireRule(ShoppingCart cart) {
        cart.setShippingOfferedInHours(2*24);
    }
}
