package core;

import api.RuleEngine;
import dto.Item;
import dto.ShoppingCart;
import dto.User;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        User user = new User(1,"Nishit","Shrestha",true);
        Item item1 = new Item("Toothbrush",1,5.54,false,true);
        Item item2 = new Item("Noodles",2,10.43,true,true);
        Item item3 = new Item("Shirt",3,20.25,false,false);

        List<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        ShoppingCart cart = new ShoppingCart(user,items);
        RuleEngine<ShoppingCart> ruleEngine = new ShoppingCartRuleEngine();

        ExecuteOnlyFirstMatch shippingOfferRules = new ExecuteOnlyFirstMatch(1);
        shippingOfferRules.addRule(new PrimeMemberAndOrderGreaterThan100AndGrocery(0));
        shippingOfferRules.addRule(new PrimeMemberAndOrderGreaterThan25AndGrocery(1));
        shippingOfferRules.addRule(new PrimeMemberAndOrderGreaterThan125(2));
        shippingOfferRules.addRule(new PrimeMember(3));
        shippingOfferRules.addRule(new NotPrimeOrderGreaterThan35(4));

        ruleEngine.register(shippingOfferRules);

        ruleEngine.register(new Discount10PercentIfSubscribedAndSaved(0));

        ruleEngine.execute(cart);

        System.out.println("Shipping offered is "+cart.getShippingOfferedInHours());
    }
}
