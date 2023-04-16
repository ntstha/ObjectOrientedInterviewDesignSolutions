package api;

public interface RuleEngine<U> {
    public void register(Rule rule);

    public void execute(U bean);
}
