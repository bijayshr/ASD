package visitor;

import java.util.function.Supplier;

public class TotalCollector implements Visitor, Supplier<Double> {
    private Component totalValueComponent;
    private double val=0;

    @Override
    public void visit(Composite composite) {
        visitTotal(composite);
    }

    @Override
    public void visit(Leaf leaf) {
        visitTotal(leaf);
    }

    private void visitTotal(Component component){
        if(totalValueComponent == null){
            totalValueComponent = component;
            val = component.getValue();
        }else{
            val += component.getValue();
        }

    }

    @Override
    public Double get() {
        System.out.println("Total Value :: " + val);
        return val;
    }
}
