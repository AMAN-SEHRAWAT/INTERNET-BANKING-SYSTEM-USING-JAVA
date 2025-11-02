import java.util.ArrayList;

public class Account {
    private String accNo;
    private String name;
    private String password;
    private String accountType;
    private double balance;
    private ArrayList<String> transactions;

    public Account(String accNo, String name, String password, String accountType, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.password = password;
        this.accountType = accountType;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Getters
    public String getAccNo() { return accNo; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public double getBalance() { return balance; }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: ₹" + amount);
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: ₹" + amount);
            return true;
        } else {
            return false;
        }
    }

    // Transfer method
    public boolean transfer(Account receiver, double amount) {
        if (withdraw(amount)) {
            receiver.deposit(amount);
            transactions.add("Transferred: ₹" + amount + " to " + receiver.getAccNo());
            return true;
        } else {
            return false;
        }
    }

    // View Transaction History
    public void viewTransactions() {
        System.out.println("---- Transaction History ----");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactions) {
                System.out.println(t);
            }
        }
    }
}