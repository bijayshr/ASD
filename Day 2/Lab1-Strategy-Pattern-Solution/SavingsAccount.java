package lab1;

public class SavingsAccount extends Account{
    public SavingsAccount(String accountNumber) {
        super(accountNumber, new SavingsAccountInterestStrategyImpl());
    }
}
