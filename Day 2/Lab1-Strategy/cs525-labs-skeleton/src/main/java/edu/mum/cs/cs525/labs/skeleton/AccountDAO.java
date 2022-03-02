package edu.mum.cs.cs525.labs.skeleton;

import java.util.Collection;

public interface AccountDAO {
	void saveAccount(Account account);
	void updateAccount(Account account);
	Account loadAccount(String accountnumber);
	Collection<Account> getAccounts();
}
