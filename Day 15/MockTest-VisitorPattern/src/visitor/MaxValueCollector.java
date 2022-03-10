package visitor;

import java.util.function.Supplier;

public class MaxValueCollector implements Visitor, Supplier<Component> {
    private Component maxValueComponent;

    @Override
    public void visit(Composite composite) {
        visitCompare(composite);
    }

    @Override
    public void visit(Leaf leaf) {
        visitCompare(leaf);

    }

    private void visitCompare(Component component) {
        if(maxValueComponent == null){
            maxValueComponent = component;
        }else{
            if(component.getValue()> maxValueComponent.getValue()){
                maxValueComponent = component;
            }
        }
    }

    @Override
    public Component get() {
        return maxValueComponent;
    }

}
