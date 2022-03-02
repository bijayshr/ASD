package lab3;

public class InterestPromotionP3 extends InterestPromotionDecorator{

    public InterestPromotionP3(AccountInterest accountInterest) {
        super(accountInterest);
    }

    @Override
    public double addInterest(double balance) {
        double regularInterest = getAccountInterest().addInterest(balance);
        double promotionalInterest = (regularInterest + balance) * 0.03;
        return regularInterest + promotionalInterest;
    }
}
