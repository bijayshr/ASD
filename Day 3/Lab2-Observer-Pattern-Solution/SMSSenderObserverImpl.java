public class SMSSenderObserverImpl implements AccountObserver, DisplayAccountChange{

    private Account account;

    public SMSSenderObserverImpl(Account account) {
        this.account = account;
        account.registerObserver(this);
    }

    @Override
    public void update() {
        display();
    }

    @Override
    public void display() {
        System.out.println("[SMS] Account " + account.getAccountNumber() + " updated!");
    }
}
