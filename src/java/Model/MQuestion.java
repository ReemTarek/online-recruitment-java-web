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
public class MQuestion 
{
    public int id;
    public int examId;
    public String text;
    
    public MQuestion()
    {
        id = 0;
        examId = 0;
        text = null;
    }
    
    public boolean AddQuestion() throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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

            String sqlString = "INSERT INTO question (examID, text) VALUES "
                    + "('" + examId + "','" + text + "')";
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

    public ArrayList<MQuestion> GetQuestions() 
    {
        ArrayList<MQuestion> questions = new ArrayList();
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();
            PreparedStatement ps1 = Con.prepareStatement("select * from question");

            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {
                MQuestion obj = new MQuestion();
                obj.id = Integer.parseInt(rs.getString("id"));
                obj.examId = Integer.parseInt(rs.getString("examID"));
                obj.text = rs.getString("text");
                questions.add(obj);
            }
            rs.close();
            stat.close();
            Con.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
    
    public int GetQuestionById(int idq) 
    {
        int qid = 0;
        MQuestion question = new MQuestion();
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();
            String sqlString = "select * from question where id = '" + idq + "';";
            ResultSet rs = stat.executeQuery(sqlString);
            while (rs.next()) 
            {
                question.id = Integer.parseInt(rs.getString("id"));
                question.examId = Integer.parseInt(rs.getString("examID"));
                question.text = rs.getString("text");
            }
            qid = question.examId;
            rs.close();
            Con.close();
            stat.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return qid;
    }
    public ArrayList<MQuestion> GetQuestionByExamId(int examId) 
    {
        ArrayList<MQuestion> questions = new ArrayList();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();
            PreparedStatement ps1 = Con.prepareStatement("select * from question where examID = '" + examId + "';");

            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {
                MQuestion obj = new MQuestion();
                obj.id = Integer.parseInt(rs.getString("id"));
                obj.examId = Integer.parseInt(rs.getString("examID"));
                obj.text = rs.getString("text");
                questions.add(obj);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
    
    public boolean UpdateQuestion(int idQ) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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

            String sqlString = "update question set examID = '" + examId + "', text = '" + text 
                    + "' where id = '" + idQ + "';";
            int count = stmt.executeUpdate(sqlString);
            System.out.println("********** " + count);
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
    
    public boolean DeleteQuestion(int idQ) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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

            String sqlString = "delete from question where id = '" + idQ + "';";
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
}
