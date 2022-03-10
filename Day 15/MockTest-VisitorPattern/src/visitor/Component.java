package visitor;

import java.util.function.Consumer;

public abstract class Component implements Consumer<Visitor> {
    private Double value;
    public final double getValue(){return value;}

}
