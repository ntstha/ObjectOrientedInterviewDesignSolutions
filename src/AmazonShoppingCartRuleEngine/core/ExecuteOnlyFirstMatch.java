package AmazonShoppingCartRuleEngine.core;

import AmazonShoppingCartRuleEngine.api.Rule;

import java.util.TreeSet;

public class ExecuteOnlyFirstMatch<U> extends Rule<U> {
    TreeSet<Rule<U>> rules = new TreeSet<Rule<U>>();

    private Rule<U> ruleToExecute=null;

    public ExecuteOnlyFirstMatch(int priority) {
        super(priority);
    }

    public void addRule(Rule<U> rule){
        this.rules.add(rule);
    }

    @Override
    public boolean evaluate(U bean) {

        for(Rule rule:rules){
            if(rule.evaluate(bean)){
                this.ruleToExecute = rule;
                return true;
            }
        }
        return false;
    }

    @Override
    public void fireRule(U bean) {
        if(ruleToExecute!=null){
            System.out.println("Rule executed is "+ruleToExecute.getClass().getName());
            ruleToExecute.fireRule(bean);
        }
    }

}
