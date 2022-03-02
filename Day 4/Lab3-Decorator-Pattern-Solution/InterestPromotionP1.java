package lab3;

public class InterestPromotionP1 extends InterestPromotionDecorator {

    public InterestPromotionP1(AccountInterest accountInterest) {
        super(accountInterest);
    }

    @Override
    public double addInterest(double balance) {
        double regularInterest = getAccountInterest().addInterest(balance);
        double promotionalInterest = (regularInterest + balance) * 0.01;
        return regularInterest + promotionalInterest;
    }

}
