package visitor;

public interface Visitor {
    public void visit(Composite composite);
    public void visit (Leaf leaf);
}
