package lab5;

public class Application {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();


        // create 2 accounts;
        Account account1 = accountService.createAccount("1263862", "Frank Brown");
        Account account2 = accountService.createAccount("4253892", "John Doe");

        // deposit in account 1;
        accountService.deposit(account1.getAccountNumber(), 240);
        accountService.deposit(account1.getAccountNumber(), 529);

        //withdraw from account 1
        accountService.withdraw(account1.getAccountNumber(), 230);
        // use account 2;
        accountService.deposit(account2.getAccountNumber(), 12450);


        accountService.transferFunds(account2.getAccountNumber(), account1.getAccountNumber(), 100, "payment of invoice 10232");

        //create a command and pass a receiver to it.
        Command undoCommand = new UndoAccountCommand(account2);
        //here pass the command to the invoker
        accountService.setCommand(undoCommand);
        //and then execution
        accountService.undo();
        accountService.undo();


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
