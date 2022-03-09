package gumball.problem;;

public class NoQuarterState implements State {

	private static volatile NoQuarterState noQuarterState;
	  
	public static State getNoQuarterState() {
		if (noQuarterState == null ) {
			synchronized (NoQuarterState.class) {
				if (noQuarterState == null) {
					noQuarterState = new NoQuarterState();
				}
			}
		}
		return noQuarterState;
	}
 
	public State insertQuarter() {
		System.out.println("You inserted a quarter");
		return HasQuarterState.getHasQuarterState();
	}
 
	public State ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
		return getNoQuarterState();
	}
 
	public State turnCrank(Integer gumBalls) {
		System.out.println("You turned, but there's no quarter");
		return getNoQuarterState();
	 }
 
	public State dispense() {
		System.out.println("You need to pay first");
		return getNoQuarterState();
	} 
	
	public State refill() { return getNoQuarterState(); }
 
	public String toString() {
		return "waiting for quarter";
	}

}
