import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, AccountHolder> accountHolders;

    public Bank() {
        this.accountHolders = new HashMap<>();
    }

    public void addAccountHolder(AccountHolder holder) {
        accountHolders.put(holder.getId(), holder);
    }

    public AccountHolder getAccountHolder(String id) {
        return accountHolders.get(id);
    }

    //Class to handle getting and transferring funds
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        BankAccount fromAccount = null;
        BankAccount toAccount = null;

        for (AccountHolder holder : accountHolders.values()) {
            if (fromAccount == null) {
                fromAccount = holder.getAccountByNumber(fromAccountNumber);
            }
            if (toAccount == null) {
                toAccount = holder.getAccountByNumber(toAccountNumber);
            }
            if (fromAccount != null && toAccount != null) {
                break;
            }
        }

        //Error checking
        if (fromAccount != null && toAccount != null) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } else {
            throw new IllegalArgumentException("Invalid account numbers");
        }
    }
}
