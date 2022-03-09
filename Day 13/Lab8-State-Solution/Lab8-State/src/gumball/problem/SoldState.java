package gumball.problem;;

public class SoldState implements State {

	private static volatile SoldState soldState;
	  
	public static State getSoldState() {
		if (soldState == null ) {
			synchronized (SoldState.class) {
				if (soldState == null) {
					soldState = new SoldState();
				}
			}
		}
		return soldState;
	}
       
	public State insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumball");
		return getSoldState();
	}
 
	public State ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
		return getSoldState();
	}
 
	public State turnCrank(Integer gumBalls) {
		System.out.println("Turning twice doesn't get you another gumball!");
		return getSoldState();
	}
 
	public State dispense() {
		GumballMachine.releaseBall();
		if (GumballMachine.getCount() > 0) {
//			gumballMachine.setState(gumballMachine.getNoQuarterState());
			return NoQuarterState.getNoQuarterState();
		} else {
			System.out.println("Oops, out of gumballs!");
//			gumballMachine.setState(gumballMachine.getSoldOutState());
			return SoldOutState.getSoldOutState();
		}
	}
	
	public State refill() { return getSoldState(); }
 
	public String toString() {
		return "dispensing a gumball";
	}
}
