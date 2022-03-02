package lab5;

public class UndoAccountCommand implements Command {

    Account account;

    public UndoAccountCommand(Account account){
        this.account = account;
    }

    @Override
    public void undo() {
        if(account.getEntryList().isEmpty())
            System.err.println("No operations to undo...");
        else
            account.undoLastOperation();
    }
}
