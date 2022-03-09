package gumball.problem;;

import java.util.Random;

public class HasQuarterState implements State {
	Random randomWinner = new Random(System.currentTimeMillis());
 
	private static volatile HasQuarterState hasQuarterState;
  
	public static HasQuarterState getHasQuarterState() {
		if (hasQuarterState == null ) {
			synchronized (HasQuarterState.class) {
				if (hasQuarterState == null) {
					hasQuarterState = new HasQuarterState();
				}
			}
		}
		return hasQuarterState;
	}
	
	public State insertQuarter() {
		System.out.println("You can't insert another quarter");
		return getHasQuarterState();
	}
 
	public State ejectQuarter() {
		System.out.println("Quarter returned");
//		gumballMachine.setState(gumballMachine.getNoQuarterState());
		return NoQuarterState.getNoQuarterState();
	}
 
	public State turnCrank(Integer gumBalls) {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumBalls > 1)) {
//			gumballMachine.setState(gumballMachine.getWinnerState());
			return WinnerState.getWinnerState();
		} else {
//			gumballMachine.setState(gumballMachine.getSoldState());
			return SoldState.getSoldState();
		}
	}

    public State dispense() {
        System.out.println("No gumball dispensed");
        return getHasQuarterState();
    }
    
    public State refill() { return getHasQuarterState(); }
 
	public String toString() {
		return "waiting for turn of crank";
	}

}
