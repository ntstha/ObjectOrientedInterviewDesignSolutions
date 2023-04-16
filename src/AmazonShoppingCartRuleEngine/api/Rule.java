package AmazonShoppingCartRuleEngine.api;

public abstract class Rule<U> implements Comparable<Rule>{

    private int priority;

    public Rule(int priority){
        this.priority = priority;
    }

    public abstract boolean evaluate(U bean);

    public abstract void fireRule(U bean);

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    @Override
    public int compareTo(Rule o) {
        return this.priority - o.priority;
    }
}
