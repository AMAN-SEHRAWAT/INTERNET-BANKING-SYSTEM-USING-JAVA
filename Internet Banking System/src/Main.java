import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        // Sample Accounts
        bank.addAccount(new Account("1001", "Krishna", "pass123", "Savings", 5000));
        bank.addAccount(new Account("1002", "Aman", "1234", "Current", 3000));

        System.out.println("---- Welcome to Internet Banking System ----");
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        Account user = bank.login(accNo, pass);
        if (user == null) {
            System.out.println("Invalid credentials! Exiting...");
            return;
        }

        int choice;
        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Fund Transfer");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + user.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    user.deposit(dep);
                    System.out.println("Deposited Successfully!");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    if (user.withdraw(wd)) System.out.println("Withdrawal Successful!");
                    else System.out.println("Insufficient Balance!");
                    break;
                case 4:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter receiver account number: ");
                    String toAccNo = sc.nextLine();
                    Account receiver = bank.getAccount(toAccNo);
                    if (receiver == null) {
                        System.out.println("Receiver account not found!");
                        break;
                    }
                    System.out.print("Enter amount to transfer: ");
                    double amt = sc.nextDouble();
                    if (user.transfer(receiver, amt)) System.out.println("Transfer Successful!");
                    else System.out.println("Transfer Failed! Insufficient balance.");
                    break;
                case 5:
                    user.viewTransactions();
                    break;
                case 6:
                    System.out.println("Thank you for using Internet Banking!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}