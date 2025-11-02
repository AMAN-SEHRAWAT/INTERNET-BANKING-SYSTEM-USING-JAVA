import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account acc) {
        accounts.put(acc.getAccNo(), acc);
    }

    public Account login(String accNo, String password) {
        Account acc = accounts.get(accNo);
        if (acc != null && acc.getPassword().equals(password)) {
            return acc;
        }
        return null;
    }

    public Account getAccount(String accNo) {
        return accounts.get(accNo);
    }
}