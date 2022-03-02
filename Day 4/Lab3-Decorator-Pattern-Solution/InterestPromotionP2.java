package lab3;

public class InterestPromotionP2 extends InterestPromotionDecorator {

    public InterestPromotionP2(AccountInterest accountInterest) {
        super(accountInterest);
    }

    @Override
    public double addInterest(double balance) {
        double regularInterest = getAccountInterest().addInterest(balance);
        double promotionalInterest = (regularInterest + balance) * 0.02;
        return regularInterest + promotionalInterest;
    }
}
