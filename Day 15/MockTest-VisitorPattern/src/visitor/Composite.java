package visitor;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private Component component;
    private List<Component> components = new ArrayList<>();

    public Composite(Component component){
        this.component = component;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
        for(Component component: components){
            component.accept(v);
        }
    }

    public Component getComponent(){
        return component;
    }

    public List<Component> getComponents(){
        return components;
    }
}
