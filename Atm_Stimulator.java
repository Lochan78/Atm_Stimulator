import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } 
        else {
            System.out.println("Insufficient funds. Unable to withdraw.");
            return false;
        }
    }

    public boolean transfer(double amount, BankAccount targetAccount) {
        if (withdraw(amount)) {
            targetAccount.deposit(amount);
            return true;
        } 
        else {
            System.out.println("Transfer failed. Insufficient funds.");
            return false;
        }
    }
}

public class Atm_Stimulator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Create two bank accounts for demonstration
        BankAccount account1 = new BankAccount("12345", 5000.0);
        BankAccount account2 = new BankAccount("67890", 1700.0);

        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance in Account 1: Rs" + account1.getBalance());
                    System.out.println("Balance in Account 2: Rs" + account2.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: Rs");
                    double depositAmount = sc.nextDouble();
                    account1.deposit(depositAmount);
                    System.out.println("Deposited Rs" + depositAmount + " to Account 1.");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: Rs");
                    double withdrawalAmount = sc.nextDouble();
                    // account1.withdraw(withdrawalAmount);
                    if(account1.withdraw(withdrawalAmount)==true){
                    System.out.println("Withdrawn Rs" + withdrawalAmount + " from Account 1.");}
                    break;
                case 4:
                    System.out.print("Enter transfer amount: Rs");
                    double transferAmount = sc.nextDouble();
                    boolean transferSuccess = account1.transfer(transferAmount, account2);
                    if (transferSuccess) {
                        System.out.println("Transferred Rs" + transferAmount + " from Account 1 to Account 2.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting ATM. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
           
        }
    }
}
