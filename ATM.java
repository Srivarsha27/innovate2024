import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Transaction class to store transaction history
class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + ": " + amount;
    }
}

// User class to represent ATM users
class User {
    private String userID;
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;

    public User(String userID, String pin) {
        this.userID = userID;
        this.pin = pin;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public boolean validatePin(String pin) {
        return this.pin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}

// ATM class to manage ATM functionalities
public class ATM {
    private User currentUser;
    private Scanner scanner;

    public ATM() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");

        // Prompt for user ID and PIN
        System.out.print("Enter User ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        // Validate user credentials
        currentUser = validateUser(userID, pin);
        if (currentUser != null) {
            System.out.println("User authenticated. Welcome, " + currentUser.getUserID() + "!");
            displayMenu();
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }

        scanner.close();
    }

    private User validateUser(String userID, String pin) {
        // Dummy user validation, replace with actual user database check
        if (userID.equals("12345") && pin.equals("1234")) {
            return new User(userID, pin);
        }
        return null;
    }

    private void displayMenu() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("Transfer functionality not implemented.");
                    break;
                case 5:
                    System.out.println("Quitting ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }

    private void displayTransactionHistory() {
        System.out.println("\nTransaction History:");
        List<Transaction> transactions = currentUser.getTransactionHistory();
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        currentUser.deposit(amount);
        System.out.println("Deposit successful. New balance: " + currentUser.getBalance());
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (currentUser.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: " + currentUser.getBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
