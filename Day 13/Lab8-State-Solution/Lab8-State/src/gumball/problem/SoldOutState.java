package gumball.problem;;

public class SoldOutState implements State {

	private static volatile SoldOutState SoldOutState;
	  
	public static State getSoldOutState() {
		if (SoldOutState == null ) {
			synchronized (SoldOutState.class) {
				if (SoldOutState == null) {
					SoldOutState = new SoldOutState();
				}
			}
		}
		return SoldOutState;
	}
 
	public State insertQuarter() {
		System.out.println("You can't insert a quarter, the machine is sold out");
		return getSoldOutState();
	}
 
	public State ejectQuarter() {
		System.out.println("You can't eject, you haven't inserted a quarter yet");
		return getSoldOutState();
	}
 
	public State turnCrank(Integer gumBalls) {
		System.out.println("You turned, but there are no gumballs");
		return getSoldOutState();
	}
 
	public State dispense() {
		System.out.println("No gumball dispensed");
		return getSoldOutState();
	}
	
	public State refill() { 
//		gumballMachine.setState(gumballMachine.getNoQuarterState());
		return NoQuarterState.getNoQuarterState();
	}
 
	public String toString() {
		return "sold out";
	}
}
