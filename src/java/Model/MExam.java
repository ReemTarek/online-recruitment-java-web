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
public class MExam 
{    
    public int id;
    public String type;
    public double period;

    public MExam() {
        id = 0;
        type = "new type";
        period = 0.0;
    }
    public boolean AddExam() throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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

            String sqlString = "INSERT INTO exam (type, period) VALUES ('" + type + "','" + period + "');";
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
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<MExam> GetExams() 
    {
        ArrayList<MExam> exams = new ArrayList();
        try {
            String user_name = "root";
            String pass = "";
            Connection Con = null;
            Statement stat = null;
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Con = DriverManager.getConnection(url, user_name, pass);

            stat = Con.createStatement();

            PreparedStatement ps1 = Con.prepareStatement("select * from exam");

            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {
                MExam obj = new MExam();
                obj.id = Integer.parseInt(rs.getString("id"));
                obj.type = rs.getString("type");
                obj.period = Double.parseDouble(rs.getString("period"));
                exams.add(obj);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return exams;
    }
    
    
    public boolean UpdateExam(int idE) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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

            String sqlString = "update exam set type = '" + type + "', period = '" + period 
                    + "' where id = '" + idE + "';";
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
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<MExam> GetExamsType(String nameexam) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        ArrayList<MExam> allexams = new ArrayList();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();

            String sqlString = "select * from exam where type = '" + nameexam + "';";
            ResultSet res = stmt.executeQuery(sqlString);
            while (res.next()) 
            {
                MExam exam = new MExam();
                exam.period = Double.parseDouble(res.getString("period"));
                exam.type = res.getString("type");
                exam.id = Integer.parseInt(res.getString("id"));
                allexams.add(exam);
            }
            res.close();
            stmt.close();
            Con.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return allexams;
    }
    
    public MExam GetExamByType(String nameexam) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        MExam exam = new MExam();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();

            String sqlString = "select * from exam where type = '" + nameexam + "';";
            ResultSet res = stmt.executeQuery(sqlString);
            while (res.next()) 
            {
                exam.period = Double.parseDouble(res.getString("period"));
                exam.type = res.getString("type");
                exam.id = Integer.parseInt(res.getString("id"));
            }
            res.close();
            stmt.close();
            Con.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return exam;
    }
    
    public boolean DeleteExam(int idE) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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

            String sqlString = "delete from exam where id = '" + idE + "';";
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
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
}
