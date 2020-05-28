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
public class MPosition
{
    public String name;
    public int available;
    public int count;
    public int id;

    public MPosition() 
    {
        name = "new position";
        available = 0;
        count = 0;
        id = 0;
    }

    public ArrayList<MPosition> GetPositions() 
    {
        ArrayList<MPosition> pos = new ArrayList();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();

            PreparedStatement ps1 = Con.prepareStatement("select * from position");
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                MPosition obj = new MPosition();
                obj.name = rs.getString("name");
                obj.available = Integer.parseInt(rs.getString("available"));
                obj.count = Integer.parseInt(rs.getString("count"));
                obj.id = Integer.parseInt(rs.getString("id"));
                pos.add(obj);
            }
            stat.close();
            Con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return pos;
    }
    
    public MPosition GetPositionByName(String name) 
    {
        MPosition position = new MPosition();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();

            PreparedStatement ps1 = Con.prepareStatement("select * from position where name = '" + name + "';");
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {
                position.available = Integer.parseInt(rs.getString("available"));
                position.count = Integer.parseInt(rs.getString("count"));
                position.id = Integer.parseInt(rs.getString("id"));
            }
            stat.close();
            Con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return position;
    }

    public MPosition GetPositionById(int idp) 
    {
        MPosition position = new MPosition();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();

            PreparedStatement ps1 = Con.prepareStatement("select * from position where id = '" + idp + "';");
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {
                position.available = Integer.parseInt(rs.getString("available"));
                position.count = Integer.parseInt(rs.getString("count"));
                position.name = rs.getString("name");
            }
            stat.close();
            Con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return position;
    }

    public boolean AddPosition() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();

            String sqlString = "INSERT INTO position (name, available, count) VALUES ('" 
                    + name + "','" + 1 + "','" + 0 + "')";
            int count = stmt.executeUpdate(sqlString);
            if (count > 0) {
                stmt.close();
                Con.close();
                return true;
            } else {
                stmt.close();
                Con.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean UpdatePosition(int idp) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();

            String sqlString = "update position set name = '" + name + "', available = '" + available
                    + "' where id = '" + idp + "';";
            int count = stmt.executeUpdate(sqlString);
            System.out.println("------> count  = " + count);
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
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean DeletePosition(int idp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();

            String sqlString = "delete from position where id = '" + idp + "';";
            int count = stmt.executeUpdate(sqlString);
            if (count > 0) {
                stmt.close();
                Con.close();
                return true;
            } else {
                stmt.close();
                Con.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<MPosition> GetPositionsName(String namepos) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        ArrayList<MPosition> allpos = new ArrayList();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();

            String sqlString = "select * from position where name = '" + namepos + "'";
            ResultSet res = stmt.executeQuery(sqlString);
            while (res.next()) {
                MPosition pos = new MPosition();
                pos.available = Integer.parseInt(res.getString("available"));
                pos.count = Integer.parseInt(res.getString("count"));
                pos.name = res.getString("name");
                pos.id = Integer.parseInt(res.getString("id"));
                allpos.add(pos);
            }
            res.close();
            stmt.close();
            Con.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return allpos;
    }
}