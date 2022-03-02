package lab1;

public class CheckingAccountInterestStrategyImpl implements InterestBehaviorStrategy {

    public double calculateInterest(Account account) {
        double balance = account.getBalance();
        double amount = 0.0;
        if (account.getBalance() < 1000D) {
            amount = balance * 0.015;
        } else {
            amount = balance * 0.025;
        }
        return amount;
    }
}
