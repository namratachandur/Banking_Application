import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("Welcome to the Bank Management System!");

        boolean validLogin = false;
        BankAccount currentAccount = null;

        while (!validLogin) 
        {
            System.out.print("Enter your account number: ");
            int accountNumber = input.nextInt();

            System.out.print("Enter your PIN: ");
            int pin = input.nextInt();

            currentAccount = bank.findAccount(accountNumber, pin);

            if (currentAccount != null) 
            {
                validLogin = true;
                System.out.printf("\nWelcome, %s!\n", currentAccount.getAccountHolderName());
                bank.performTransaction(currentAccount);
            } 
            else 
            {
                System.out.println("Invalid account number or PIN. Please try again.");
            }
        }
        input.close();
    }
}