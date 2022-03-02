package lab1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    public AccountServiceImpl() {
        accountDAO = new AccountDAOImpl();
    }

    public Account createAccount(String accountNumber, String customerName, InterestBehaviorStrategy interestBehaviorStrategy) {
        Account account = new Account(accountNumber, interestBehaviorStrategy);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);

        accountDAO.saveAccount(account);

        return account;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);

        accountDAO.updateAccount(account);
    }

    public Account getAccount(String accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        return account;
    }

    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
    }


    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
    }

    public void addInterest() {
        Collection<Account> accounts = new ArrayList<Account>();
        accounts.addAll(getAllAccounts());
        for (Account account :
                accounts) {
            account.performInterestCalculation();
            accountDAO.updateAccount(account);
        }
    }

}
