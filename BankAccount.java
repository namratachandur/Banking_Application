public class BankAccount
{
    private int account_number;
    private int pin;
    private String account_holder_name;
    private double balance;

    public BankAccount(int account_number, int pin, String account_holder_name, double balance) 
    {
        this.account_number = account_number;
        this.pin = pin;
        this.account_holder_name = account_holder_name;
        this.balance = balance;
    }

    public int getAccountNumber() 
    {
        return account_number;
    }

    public String getAccountHolderName() 
    {
        return account_holder_name;
    }

    public boolean validatePin(int pin)
    {
        return this.pin == pin;
    }

    public void deposit(double amount)
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

    public void withdraw(double amount, int pin)
    {
        if (this.pin == pin) 
        {
            if (amount > 0 && amount <= balance) 
            {
                balance -= amount;
                System.out.printf("Withdrawn: %.2f\nCurrent balance: %.2f\n", amount, balance);
            } 
            else 
            {
                System.out.println("Invalid withdrawal amount.");
            }
        } 
        else 
        {
            System.out.println("Incorrect PIN code.");
        }
    }

    public double checkBalance(int pin)
    {
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