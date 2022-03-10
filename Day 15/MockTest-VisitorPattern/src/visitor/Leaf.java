package visitor;

public class Leaf extends Component{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
