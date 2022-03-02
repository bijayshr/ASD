package lab3;

public class SavingsAccount implements AccountInterest{

    @Override
    public double addInterest(double balance) {
        if(balance>5000){
            return balance*0.04;
        }else if (balance>1000 && balance<5000){
            return balance*0.02;
        }else return balance*0.01;
    }

}