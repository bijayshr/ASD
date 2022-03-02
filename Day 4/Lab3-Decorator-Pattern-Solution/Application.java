package lab3;

public class Application {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();

        AccountInterest savAccount = new SavingsAccount();
        InterestPromotionDecorator savingsPromotionDecorator = new InterestPromotionP1(savAccount);

        AccountInterest chkAccount = new CheckingAccount();
        InterestPromotionDecorator checkingPromotionDecorator = new InterestPromotionP1(chkAccount);


        // create 2 accounts;
        Account checkingAccount = accountService.createAccount("1263862", "Frank Brown", savingsPromotionDecorator);
        Account savingsAccount = accountService.createAccount("4253892", "John Doe", checkingPromotionDecorator);
        // use account 1;
        accountService.deposit("1263862", 240);
        accountService.deposit("1263862", 529);
        accountService.withdraw("1263862", 230);
        //add interest in checking account
        accountService.addInterest("1263862");
        // use account 2;
        accountService.deposit("4253892", 12450);
        accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");

        //add interest in savings account
        accountService.addInterest("4253892");


        // show balances
        for (Account account : accountService.getAllAccounts()) {
            Customer customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountNumber());
            System.out.println("Account Holder: " + customer.getName());

            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");

            for (AccountEntry entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n",
                        entry.getDate().toString(),
                        entry.getDescription(),
                        entry.getAmount());
            }

            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }
    }

}
