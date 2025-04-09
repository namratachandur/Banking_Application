import java.util.ArrayList;
import java.util.Scanner;

public class Bank
{
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public Bank()
    {
        accounts.add(new BankAccount(1001, 1234, "John Doe", 500.00));
        accounts.add(new BankAccount(1002, 2345, "Jane Smith", 1200.00));
        accounts.add(new BankAccount(1003, 3456, "Alice Johnson", 850.00));
    }

    public BankAccount findAccount(int accountNumber, int pin)
    {
        for (BankAccount account : accounts)
        {
            if (account.getAccountNumber() == accountNumber && account.validatePin(pin))
            {
                return account;
            }
        }
        return null;
    }

    public void performTransaction(BankAccount account)
    {
        boolean newTransaction = true;

        while (newTransaction)
        {
            System.out.println("\nChoose transaction type: ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            int choice = input.nextInt();

            switch (choice)
            {
                case 1 -> 
                {
                    System.out.print("Enter PIN code: ");
                    int pin = input.nextInt();
                    double balance = account.checkBalance(pin);
                    if (balance != -1) 
                    {
                        System.out.printf("Current balance: %.2f\n", balance);
                    }
                }
                case 2 -> 
                {
                    System.out.print("Enter PIN code: ");
                    int pin = input.nextInt();
                    if (account.validatePin(pin)) 
                    {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = input.nextDouble();
                        account.deposit(depositAmount, pin);
                    }
                    else 
                    {
                        System.out.println("Incorrect PIN code.");
                    }
                }
                case 3 -> 
                {
                    System.out.print("Enter PIN code: ");
                    int pin = input.nextInt();
                    if (account.validatePin(pin)) 
                    {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = input.nextDouble();
                        account.withdraw(withdrawalAmount, pin);
                    }
                    else 
                    {
                        System.out.println("Incorrect PIN code.");
                    }
                }
                case 4 -> 
                {
                    newTransaction = false;
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            if (newTransaction && choice != 4) 
            {
                System.out.print("\nWould you like to perform another transaction? (1 for Yes, 0 for No): ");
                int continueChoice = input.nextInt();
                if (continueChoice != 0 && continueChoice != 1) 
                {
                    newTransaction = false;
                    System.out.println("Invalid choice. Exiting transaction.");
                } 
                else if (continueChoice == 0) 
                {
                    newTransaction = false;
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                } 
                else 
                {
                    newTransaction = true;
                }
            }
        }
        
    }
}
