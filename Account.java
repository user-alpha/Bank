import java.text.NumberFormat;
import java.sql.*;


public class Account
{
   private final double RATE = 0.035;  // doubleerest rate of 3.5%
   private final double FEE = 1.00;
   private double acctNumber;
   private double balance;
   private String name;

    

   

   //-----------------------------------------------------------------
   //  Sets up the account by defining its owner, account number,
   //  and initial balance.
   //-----------------------------------------------------------------
   public Account(String owner, double account, double initial)
   {
      name = "John Doe";
      acctNumber = 12345;
      balance = 100.00;
   }

   //-----------------------------------------------------------------
   //  Deposits the specified amount doubleo the account. Returns the
   //  new balance.
   //-----------------------------------------------------------------
   public double deposit(double amount)
   {
      balance = balance + amount;
      return balance;
   }

   //-----------------------------------------------------------------
   //  Withdraws the specified amount from the account and applies
   //  the fee. Returns the new balance.
   //-----------------------------------------------------------------
   public double withdraw(double amount, double fee)
   {
      balance = balance - amount - fee;
      return balance;
   }


   //-----------------------------------------------------------------
   //  Adds doubleerest to the account and returns the new balance.
   //-----------------------------------------------------------------
   public double adddoubleerest()
   {
      balance += (balance * RATE);
      return balance;
   }

   //-----------------------------------------------------------------
   //  Returns the current balance of the account.
   //-----------------------------------------------------------------
   public double getBalance()
   {
      return balance;
   }
   public String getName()
   {
      return name;
   }
   public double getNumber()
   {
      return acctNumber;
   }

   //-----------------------------------------------------------------
   //  Returns a one-line description of the account as a string.
   //-----------------------------------------------------------------
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
      return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
   }
   
}
