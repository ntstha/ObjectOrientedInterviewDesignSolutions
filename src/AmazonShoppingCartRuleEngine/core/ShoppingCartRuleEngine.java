package AmazonShoppingCartRuleEngine.core;

import AmazonShoppingCartRuleEngine.api.Rule;
import AmazonShoppingCartRuleEngine.api.RuleEngine;
import AmazonShoppingCartRuleEngine.dto.ShoppingCart;

import java.util.TreeSet;

public class ShoppingCartRuleEngine implements RuleEngine<ShoppingCart> {

    TreeSet<Rule> rules = new TreeSet<Rule>();
    @Override
    public void register(Rule rule) {
        this.rules.add(rule);
    }

    @Override
    public void execute(ShoppingCart cart) {
        for(Rule rule:rules){
            if(rule.evaluate(cart)) {
                System.out.println("Executed rule :" + rule.getClass().getName());
                rule.fireRule(cart);
            }
        }
    }
}
