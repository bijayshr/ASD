package gumball.problem;

public class GumballMachine {
 
	State state = SoldOutState.getSoldOutState();
	static int count = 0;
 
	public GumballMachine(int numberGumballs) {
		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = NoQuarterState.getNoQuarterState();
		} 
	}
 
	public void insertQuarter() {
		setState(state.insertQuarter());
	}
 
	public void ejectQuarter() {
		setState(state.ejectQuarter());
	}
 
	public void turnCrank() {
		setState(state.turnCrank(getCount()));
		setState(state.dispense());
	
	}

	void setState(State state) {
		this.state = state;
	}
 
	static void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count > 0) {
			count = count - 1;
		}
	}
 
	static int getCount() {
		return count;
	}
 
	void refill(int count) {
		this.count += count;
		System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
		setState(state.refill());
	}

    public State getState() {
        return state;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
