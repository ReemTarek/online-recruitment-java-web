package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Om-mostafa El-Hariry
 */
public class Mcandidate 
{
    public String username;
    public String email;
    public String password;
    public String telephone;
    public int id;
    
    public Mcandidate()
    {
        username = "";
        email = "";
        password = "";
        telephone = "";
        id = 0;
    }
    
    public boolean AddCandidate() throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();

            String sqlString = "INSERT INTO candidate (telephone,username,password, email) VALUES "
                    + "('" + telephone + "','" + username + "','" + password + "','" + email + "')";
            int count = stmt.executeUpdate(sqlString);
            if (count > 0) 
            {
                stmt.close();
                Con.close();
                return true;
            }
            else 
            {
                stmt.close();
                Con.close();
                return false;
            }
        }  
        catch (SQLException e) {
                e.printStackTrace();
            }
        return false;
    }
    
    public  boolean CheckCandidate() 
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
            String getCan = "select * from candidate where email = '" 
                    + email + "' and password = '" + password + "';";
            PreparedStatement ps1 = Con.prepareStatement(getCan);
            ResultSet rs1 = ps1.executeQuery();
            check = rs1.first();
            System.out.println(check);
            Con.close();
            if(check)
                return true;
            else 
                return false;
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return check;
    }
    
     public ArrayList<Mcandidate> GetAllCandidate()
     {
         ArrayList<Mcandidate> candidates = new ArrayList();
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();
            String getCan = "select * from candidate";
            PreparedStatement ps1 = Con.prepareStatement(getCan);

            ResultSet rs = ps1.executeQuery();
            while(rs.next())
            {
                Mcandidate obj = new Mcandidate();
                obj.username = rs.getString("username");
                obj.telephone = rs.getString("telephone");
                obj.email = rs.getString("email");
                obj.id = Integer.parseInt(rs.getString("id"));
                candidates.add(obj);
            }
            Con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return candidates;
     }
     
     public Mcandidate GetCandidateByEmail(String email)
     {
        Mcandidate candidate = new Mcandidate();
        try {
            
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();
            String getCan = "select * from candidate where email = '" + email + "';";
            PreparedStatement ps1 = Con.prepareStatement(getCan);
            
            ResultSet rs = ps1.executeQuery();
            while(rs.next())
            {
                candidate.username = rs.getString("username");
                candidate.telephone = rs.getString("telephone");
                candidate.email = rs.getString("email");
                candidate.id = Integer.parseInt(rs.getString("id"));
            }
            Con.close();
            stmt.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return candidate;
     }
     
    public Mcandidate GetCandidateById(int id)
    {
        Mcandidate candidate = new Mcandidate();
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();
            String getCan = "select * from candidate where id = '" + id + "';";
            PreparedStatement ps1 = Con.prepareStatement(getCan);

            ResultSet rs = ps1.executeQuery();
            while(rs.next())
            {
                candidate.username = rs.getString("username");
                candidate.email = rs.getString("email");
                candidate.telephone = rs.getString("telephone");
            }
            Con.close();
            stmt.close();
            rs.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return candidate;
    }
    
    public ArrayList<Mcandidate> GetCandidateByName(String username)
     {
        ArrayList<Mcandidate> candidate = new ArrayList();
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();
            String getCan = "select * from candidate where username = '" + username + "';";
            PreparedStatement ps1 = Con.prepareStatement(getCan);

            ResultSet rs = ps1.executeQuery();
            
            while(rs.next())
            {
                Mcandidate obj = new Mcandidate();
                obj.email = rs.getString("email");
                obj.telephone = rs.getString("telephone");
                obj.username = rs.getString("username");
                obj.id = Integer.parseInt(rs.getString("id"));
                candidate.add(obj);
            }
            Con.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return candidate;
    }   
}