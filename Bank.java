import java.util.ArrayList;
import java.util.Scanner;

public class Bank
{
    /* Class to manage the bank accounts and transactions
       Contains methods to find an account, perform transactions, and manage user input */
    private ArrayList<BankAccount> accounts = new ArrayList<>(); // List to store the bank accounts
    Scanner input = new Scanner(System.in); // Scanner for user input

    public Bank()
    {
        // Constructor to initialize the bank with three accounts
        accounts.add(new BankAccount(1001, 1234, "John Doe", 500.00));
        accounts.add(new BankAccount(1002, 2345, "Jane Smith", 1200.00));
        accounts.add(new BankAccount(1003, 3456, "Alice Johnson", 850.00));
    }

    public BankAccount findAccount(int accountNumber, int pin)
    {
        // Method to find an account by account number and validate the PIN
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
        // Method to display the transaction menu and perform transactions
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
                    // Displays the balance amount in the account after verifying the PIN
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
                    // Allows user to deposit money into the account after verifying the PIN
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
                    // Allows user to withdraw money from the account after verifying the PIN
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
                    // Exit the transaction menu
                    newTransaction = false;
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            if (newTransaction && choice != 4) 
            {
                // Checks if the user wants to perform another transaction
                System.out.print("\nWould you like to perform another transaction? (1 for Yes, 0 for No): ");
                int continueChoice = input.nextInt();
                if (continueChoice != 0 && continueChoice != 1) 
                {
                    // Invalid choice handling
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
        input.close(); // Close the scanner
    }
}
