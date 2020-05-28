package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Om-mostafa El-Hariry
 */
public class Mhr 
{
    public String username;
    public String password;
    public String email;
    public Mhr()
    {   email="";
        username = "";
        password = "";
    }
    public boolean CheckHR() 
    {
        boolean check = false;
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();
            String getHR = "select * from hr where email='"+email+"' and password='"+password+"'";
            PreparedStatement ps1 = Con.prepareStatement(getHR);

            ResultSet rs1 = ps1.executeQuery();
            check = rs1.next();

            Con.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
