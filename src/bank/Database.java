
package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    
    Connection con = null;
    String user = "root";
    String password = "123Alpha";
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost/Bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",user,password);
        }
        catch(Exception e){
            System.out.println("Databse Error : "+e);
        }
        return con;
    }
    
}
