public class LoggerObserverImpl implements AccountObserver, DisplayAccountChange{

    private Account account;

    public LoggerObserverImpl(Account account){
        this.account = account;
        account.registerObserver(this);
    }

    @Override
    public void update() {
      display();
    }

    @Override
    public void display() {
        System.out.println("[Log] Account " + account.getAccountNumber() + " updated!");
    }
}
