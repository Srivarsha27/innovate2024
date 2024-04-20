import java.util.Scanner;

public class BankApp {
    static double Balance = 0;

    public static void checkBalance() {
        System.out.println("Your Balance amount is :" + Balance);
    }

    public static void Deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the amount you want to deposit:Rs. ");
        double amount = sc.nextDouble();
        Balance += amount;
        System.out.println("Rs" + amount + "succesfully deposited to your account");
        checkBalance();
    }

    public static void Withdraw() {
        System.out.println("Enter the amount to Withdraw:");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        if (amount > Balance) {
            System.out.println("Insufficient Balance!!");
        } else {
            Balance -= amount;
            System.out.println("RS" + amount + "is sucessfully withdrawn");
        }
        checkBalance();
    }

    public static void Exit() {
        System.out.println("THANK YOU!!");
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int select = 0;

        while (select != 4) {
            System.out.println("Welcome! please select the options given bellow: ");
            System.out.println("1.Check Account balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Exit");
            select = sc.nextInt();

            switch (select) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    Deposit();
                    break;
                case 3:
                    Withdraw();
                    break;
                case 4:
                    Exit();
                default:
                    System.out.println("Invalid!!Choose the correct option");
                    break;

            }

        }
        sc.close();
    }
}