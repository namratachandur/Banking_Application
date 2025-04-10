public class BankAccount
{
    // Class to represent a bank account with attributes and methods for transactions
    private int account_number; 
    private int pin;
    private String account_holder_name;
    private double balance;

    public BankAccount(int account_number, int pin, String account_holder_name, double balance) 
    {
        // Constructor to initialize the bank account
        this.account_number = account_number;
        this.pin = pin;
        this.account_holder_name = account_holder_name;
        this.balance = balance;
    }

    public int getAccountNumber() 
    {
        // Getter for private variable account_number
        return account_number;
    }

    public String getAccountHolderName() 
    {
        // Getter for private variable account_holder_name
        return account_holder_name;
    }

    public boolean validatePin(int pin)
    {
        // Method to validate the PIN code
        return this.pin == pin;
    }

    public void deposit(double amount, int pin)
    {
        /* Method to deposit money into the active account
            Checks if the provided PIN is correct and if the amount is positive */
        if (this.pin == pin)
        {
            if (amount > 0) 
            {
                balance += amount;
                System.out.printf("Deposited: %.2f\nCurrent balance: %.2f\n", amount, balance);
            } 
            else 
            {
                System.out.println("Deposit amount must be positive.");
            }
        }
        else
        {
            System.out.println("Incorrect PIN code.");
        }
    }

    public void withdraw(double amount, int pin)
    {
        /* Method to withdraw money from the active account
            Checks if the provided PIN is correct and if the amount is positive */
        if (this.pin == pin) 
        {
            if (amount > 0 ) 
            {
                if (amount <= balance)
                {
                    balance -= amount;
                    System.out.printf("Withdrawn: %.2f\nCurrent balance: %.2f\n", amount, balance);
                } 
                else 
                {
                    System.out.println("Insufficient funds");
                }
            }
            else 
            {
                System.out.println("Withdraw amount must be positive.");
            } 
        }
        else 
        {
            System.out.println("Incorrect PIN code.");
        }
    }

    public double checkBalance(int pin)
    {
        /* Method to check the balance of the active account
            Checks if the provided PIN is correct */
        if (this.pin == pin) 
        {
            return balance;
        } 
        else 
        {
            System.out.println("Incorrect PIN code.");
            return -1;
        }
    }
}
