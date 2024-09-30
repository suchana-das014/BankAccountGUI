import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankApp extends JFrame {
    private Bank bank;

    public BankApp() {
        bank = new Bank();
        setTitle("Bank Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        JButton createAccountButton = new JButton("Create Account");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton transferButton = new JButton("Transfer");
        JButton displayButton = new JButton("Display Account Details");
        JButton exitButton = new JButton("Exit");

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter account holder name:");
                if (name != null && !name.trim().isEmpty()) {
                    bank.createAccount(name);
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog("Enter account number:");
                    int accountNumber = Integer.parseInt(input);
                    BankAccount account = bank.findAccount(accountNumber);
                    if (account != null) {
                        String amountInput = JOptionPane.showInputDialog("Enter deposit amount:");
                        double amount = Double.parseDouble(amountInput);
                        account.deposit(amount);
                    } else {
                        JOptionPane.showMessageDialog(null, "Account not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog("Enter account number:");
                    int accountNumber = Integer.parseInt(input);
                    BankAccount account = bank.findAccount(accountNumber);
                    if (account != null) {
                        String amountInput = JOptionPane.showInputDialog("Enter withdrawal amount:");
                        double amount = Double.parseDouble(amountInput);
                        account.withdraw(amount);
                    } else {
                        JOptionPane.showMessageDialog(null, "Account not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        });

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog("Enter your account number:");
                    int sourceAccountNumber = Integer.parseInt(input);
                    BankAccount sourceAccount = bank.findAccount(sourceAccountNumber);
                    if (sourceAccount != null) {
                        String targetInput = JOptionPane.showInputDialog("Enter target account number:");
                        int targetAccountNumber = Integer.parseInt(targetInput);
                        BankAccount targetAccount = bank.findAccount(targetAccountNumber);
                        if (targetAccount != null) {
                            String amountInput = JOptionPane.showInputDialog("Enter the amount to transfer:");
                            double amount = Double.parseDouble(amountInput);
                            sourceAccount.transfer(targetAccount, amount);
                        } else {
                            JOptionPane.showMessageDialog(null, "Target account not found.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Your account not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog("Enter account number:");
                    int accountNumber = Integer.parseInt(input);
                    BankAccount account = bank.findAccount(accountNumber);
                    if (account != null) {
                        account.displayAccountDetails();
                    } else {
                        JOptionPane.showMessageDialog(null, "Account not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(createAccountButton);
        add(depositButton);
        add(withdrawButton);
        add(transferButton);
        add(displayButton);
        add(exitButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankApp app = new BankApp();
            app.setVisible(true);
        });
    }
}
