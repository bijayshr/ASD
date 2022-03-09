package gumball.problem;;

public class WinnerState implements State {

	private static volatile WinnerState winnerState;
	  
	public static State getWinnerState() {
		if (winnerState == null ) {
			synchronized (WinnerState.class) {
				if (winnerState == null) {
					winnerState = new WinnerState();
				}
			}
		}
		return winnerState;
	}
 
	public State insertQuarter() {
		System.out.println("Please wait, we're already giving you a Gumball");
		return getWinnerState();
	}
 
	public State ejectQuarter() {
		System.out.println("Please wait, we're already giving you a Gumball");
		return getWinnerState();
	}
 
	public State turnCrank(Integer gumBalls) {
		System.out.println("Turning again doesn't get you another gumball!");
		return getWinnerState();
	}
 
	public State dispense() {
		GumballMachine.releaseBall();
		if (GumballMachine.getCount() == 0) {
//			gumballMachine.setState(gumballMachine.getSoldOutState());
			return SoldOutState.getSoldOutState();
		} else {
			GumballMachine.releaseBall();
			System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
			if (GumballMachine.getCount() > 0) {
//				gumballMachine.setState(gumballMachine.getNoQuarterState());
				return NoQuarterState.getNoQuarterState();
			} else {
            	System.out.println("Oops, out of gumballs!");
//				gumballMachine.setState(gumballMachine.getSoldOutState());
				return SoldOutState.getSoldOutState();
			}
		}
	}
 
	public State refill() { return getWinnerState(); }
	
	public String toString() {
		return "despensing two gumballs for your quarter, because YOU'RE A WINNER!";
	}
}
