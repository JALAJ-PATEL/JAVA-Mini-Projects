import java.util.Scanner;

public class Bank_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        int choice;

        do{
            System.out.println("\nBank Management System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter Account Holder Name : ");
                    String accountHolder = sc.next();
                    System.out.println("Enter Initial Balance : ");
                    double initial_Balance = sc.nextDouble();
                    bank.createAccount(accountHolder, initial_Balance);
                    System.out.println("Account Created Successfully!!");
                    break;
                case 2:
                    System.out.println("Enter Account Number : ");
                    int accountNumberDeposit = sc.nextInt();
                    System.out.println("Enter Deposit Amount : ");
                    double DepositAmount = sc.nextDouble();
                    bank.deposit(accountNumberDeposit, DepositAmount);
                    break;
                case 3:
                    System.out.println("Enter Account Number : ");
                    int accountNumberWithdraw = sc.nextInt();
                    System.out.println("Enter Witdrawal Amount : ");
                    double withdrawAmount = sc.nextDouble();
                    bank.withdraw(accountNumberWithdraw, withdrawAmount);
                    break;
                case 4:
                    System.out.println("Enter Account Number : ");
                    int accountNumberBalance = sc.nextInt();
                    bank.checkBalance(accountNumberBalance);
                    break;
                case 5:
                    System.out.println("EXITING Bank Management System. GOODBYE!!");
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter a valid option.");
            }
        }
        while(choice != 5); 

        sc.close();
    }
}
class Bank{
    private static int accnt_Counter = 1001; // Starting Account Number
    private Account[] accounts = new Account[100]; // Array to store accounts

    // Create a new Account
    public void createAccount(String accountHolder, double initial_Balance){
        Account accnt = new Account(accnt_Counter++, accountHolder, initial_Balance);
        accounts[accnt.getAccountNumber() - 1001] = accnt;
    }
    // Deposit money into an account
    public void deposit(int accountNumber, double amount){
        Account accnt = getAccount(accountNumber);
        if(accnt != null){
            accnt.deposit(amount);
            System.out.println("Deposit SUCCESSFUL.\n Current Balance : " + accnt.getBalance());
        }
        else{
            System.out.println("Account Not Found.");
        }
    }
    // Withdraw money from an account
    public void withdraw(int accountNumber, double amount){
        Account accnt = getAccount(accountNumber);
        if(accnt != null){
            if(accnt.withdraw(amount)){
                System.out.println("Withdrawal SUCCESSFUL. \n Current Balance : " + accnt.getBalance());
            }
            else{
                System.out.println("Insufficiet Funds.");
            }
        }
        else{
            System.out.println("Account Not Found.");
        }
    }
    // Check account Balance
    public void checkBalance(int accountNumber){
        Account accnt = getAccount(accountNumber);
        if(accnt != null){
            System.out.println("Account Balance : " + accnt. getBalance());
        }
        else{
            System.out.println("Account Not Found.");
        }
    }
    // Helper method to get an account by account number 
    private Account getAccount(int accountNumber){
        if(accountNumber >= 1001 && accountNumber <= accnt_Counter){
            return accounts[accountNumber - 1001];
        }
        return null;
    }
}
class Account{
    private int accountNumber;
    private String accountHolder;
    private double Balance;

    public Account(int accountNumber, String accountHolder, double Balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.Balance = Balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return Balance;
    }
    public void deposit(double amount){
        Balance += amount;
    }
    public boolean withdraw(double amount){
        if(Balance >= amount){
            Balance -= amount;
            return true;
        }
        return false;
    }
}