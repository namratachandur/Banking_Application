import java.util.Scanner;

public class Main 
{
    // Main method to run the Bank Management System
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in); // Scanner for user input
        Bank bank = new Bank(); // Creates a new Bank object

        System.out.println("Welcome to the Bank Management System!");

        boolean validLogin = false; // Boolean variable to check if login is valid
        BankAccount currentAccount = null; 

        while (!validLogin) 
        {
            // Prompts user for login details
            System.out.println("\nPlease log in to your account.");
            
            System.out.println("Enter your account number: ");
            int accountNumber = input.nextInt();

            System.out.println("Enter your PIN: ");
            int pin = input.nextInt();

            currentAccount = bank.findAccount(accountNumber, pin);

            if (currentAccount != null) 
            {
                validLogin = true;
                System.out.println("\nWelcome, " + currentAccount.getAccountHolderName());
                bank.performTransaction(currentAccount); // Perform transactions for the logged-in account
            } 
            else 
            {
                // If login fails, prompts user to try again
                System.out.println("Invalid account number or PIN. Please try again.");
            }
        }
        input.close(); // Close the scanner
    }
}
