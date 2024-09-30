public class BankAccount {
    private static int accountCounter = 1000;
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName) {
        this.accountNumber = accountCounter++;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            displayBalance("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            displayBalance("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            targetAccount.deposit(amount);
            displayBalance("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Insufficient balance or invalid amount.");
        }
    }

    public void displayAccountDetails() {
        String details = "Account Number: " + accountNumber + "\n" +
                         "Account Holder Name: " + accountHolderName + "\n" +
                         "Current Balance: " + balance;
        System.out.println(details);
    }

    private void displayBalance(String message) {
        System.out.println(message + " Current balance: " + balance);
    }
}
