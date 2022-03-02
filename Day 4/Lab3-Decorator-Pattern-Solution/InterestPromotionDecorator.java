package lab3;

import lab3.Account;
import lab3.AccountInterest;

public abstract class InterestPromotionDecorator implements AccountInterest {

    private AccountInterest accountInterest;

    public InterestPromotionDecorator(AccountInterest accountInterest) {
        this.accountInterest = accountInterest;
    }

    @Override
    public double addInterest(double balance) {
        return accountInterest.addInterest(balance);
    }

    public AccountInterest getAccountInterest() {
        return accountInterest;
    }
}
