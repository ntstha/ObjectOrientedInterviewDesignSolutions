package AmazonShoppingCartRuleEngine.core;

import AmazonShoppingCartRuleEngine.api.Rule;

import java.util.TreeSet;

public class ExecuteAllThatMatch<U> extends Rule<U> {
    TreeSet<Rule<U>> rules = new TreeSet<Rule<U>>();

    TreeSet<Rule<U>> rulesToExecute = new TreeSet<Rule<U>>();

    public ExecuteAllThatMatch(int priority) {
        super(priority);
    }

    public void addRule(Rule<U> rule){
        this.rules.add(rule);
    }

    @Override
    public boolean evaluate(U bean) {
        boolean result = false;
        for(Rule<U> rule:rules){
            if(rule.evaluate(bean)){
                rulesToExecute.add(rule);
                result = true;
            }
        }
        return result;
    }

    @Override
    public void fireRule(U bean) {
        for(Rule<U> rule:rulesToExecute) {
            rule.fireRule(bean);
        }
    }
}
