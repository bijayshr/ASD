package lab3;

public class CheckingAccount implements AccountInterest{

    @Override
    public double addInterest(double balance) {
        if(balance>1000){
            return balance*0.025;
        }else return balance*0.015;
    }
}
