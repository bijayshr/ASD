package gumball.problem;

public interface State {
 
	public State insertQuarter();
	public State ejectQuarter();
	public State turnCrank(Integer gumBalls);
	public State dispense();
	
	public State refill();
}
