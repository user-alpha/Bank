
package bank;

import java.sql.Connection;
import java.sql.Statement;
import java.text.NumberFormat;

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
      
      //Sync the record with Database
      try{
        Connection con = new Database().getConnection();
        Statement stmt=con.createStatement();
        String insert= "SET @AccountNo = " + acctNumber + ",\n" +
                        "    @OwnerName = '" + name + "',\n" +
                        "    @balance = " + balance + ";\n" +
                        "INSERT INTO bankaccount\n" +
                        "    (AccountNo, OwnerName, balance)\n" +
                        "VALUES\n" +
                        "    (@AccountNo, @OwnerName, @balance)\n" +
                        "ON DUPLICATE KEY UPDATE\n" +
                        "    OwnerName = @OwnerName,\n" +
                        "    balance = @balance;";
        stmt.executeUpdate(insert);
      }
      catch(Exception e){
        System.out.println("Databse Error : "+e);
      }
      
   }

   //-----------------------------------------------------------------
   //  Deposits the specified amount doubleo the account. Returns the
   //  new balance.
   //-----------------------------------------------------------------
   public double deposit(double amount)
   {
      balance = balance + amount;
      
      try{
        Connection con = new Database().getConnection();
        Statement stmt=con.createStatement();
        String insert= " UPDATE  bankaccount\n" +
                        "     SET balance = " + balance + " \n" +
                        "     WHERE AccountNo = " + acctNumber + ";";
        stmt.executeUpdate(insert);
      }
      catch(Exception e){
        System.out.println("Databse Error : "+e);
      }
      
      return balance;
   }

   //-----------------------------------------------------------------
   //  Withdraws the specified amount from the account and applies
   //  the fee. Returns the new balance.
   //-----------------------------------------------------------------
   public double withdraw(double amount, double fee)
   {
      balance = balance - amount - fee;
      try{
        Connection con = new Database().getConnection();
        Statement stmt=con.createStatement();
        String insert= " UPDATE  bankaccount\n" +
                        "     SET balance = " + balance + " \n" +
                        "     WHERE AccountNo = " + acctNumber + ";";
        stmt.executeUpdate(insert);
      }
      catch(Exception e){
        System.out.println("Databse Error : "+e);
      }
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