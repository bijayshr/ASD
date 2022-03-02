package lab5;

import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountNumber, String customerName);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void setCommand(Command command);
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void undo();
}
