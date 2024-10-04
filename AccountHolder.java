import java.util.ArrayList;
import java.util.List;

public class AccountHolder {
    private String id;
    private String name;
    private List<BankAccount> accounts;

    public AccountHolder(String id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    //Getters/Setters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    //Class to get account details
    public BankAccount getAccountByNumber(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
