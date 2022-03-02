public class EmailSenderObserverImpl implements AccountObserver, DisplayAccountChange {

    private Account account;

    public EmailSenderObserverImpl(Account account) {
        this.account = account;
        account.registerObserver(this);
    }

    @Override
    public void update() {
        display();
    }

    @Override
    public void display() {
        System.out.println("[Email] Account " + account.getAccountNumber() + " updated!");
    }
}
