import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void createAccount(String name) {
        BankAccount newAccount = new BankAccount(name);
        accounts.add(newAccount);
        System.out.println("Account created for " + name + ". Account Number: " + newAccount.getAccountNumber());
    }

    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null; // Account not found
    }
}
