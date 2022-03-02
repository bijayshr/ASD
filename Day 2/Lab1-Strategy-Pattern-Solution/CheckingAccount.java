package lab1;

public class CheckingAccount extends Account{
    public CheckingAccount(String accountNumber) {
        super(accountNumber, new CheckingAccountInterestStrategyImpl());
    }
}
