package lab1;

public class SavingsAccountInterestStrategyImpl implements InterestBehaviorStrategy {
    public double calculateInterest(Account account) {
        double balance = account.getBalance();
        double amount = 0.0;
        if (balance < 1000D) {
            amount = balance * 0.01;
        } else if (balance > 1000 && balance < 5000) {
            amount = balance * 0.02;
        } else {
            amount = balance * 0.04;
        }
        return amount;
    }
}
