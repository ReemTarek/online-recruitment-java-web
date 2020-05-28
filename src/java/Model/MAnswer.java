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
public class MAnswer 
{
    public int id;
    public int questionId;
    public String text;
    public int correct;
    
    public MAnswer()
    {
        id =0;
        questionId = 0;
        text = null;
        correct = 0;
    }
      
    public boolean AddAnswer() throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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

            String sqlString = "INSERT INTO answer (questionID, text, correct) VALUES "
                    + "('" + questionId + "','" + text + "','" + correct + "')";
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

    public ArrayList<MAnswer> GetAnswers() 
    {
        ArrayList<MAnswer> answers = new ArrayList();
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();
            PreparedStatement ps1 = Con.prepareStatement("select * from answer");

            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {
                MAnswer obj = new MAnswer();
                obj.id = Integer.parseInt(rs.getString("id"));
                obj.questionId = Integer.parseInt(rs.getString("questionID"));
                obj.text = rs.getString("text");
                obj.correct = Integer.parseInt(rs.getString("correct"));
                answers.add(obj);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return answers;
    }

    public ArrayList<MAnswer> GetAnswersByQuestionId(int questionId) 
    {
        ArrayList<MAnswer> answers = new ArrayList();
        try {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();
            PreparedStatement ps1 = Con.prepareStatement("select * from answer where questionID = '" + questionId + "';");

            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {
                MAnswer obj = new MAnswer();
                obj.id  = Integer.parseInt(rs.getString("id"));
                obj.questionId = Integer.parseInt(rs.getString("questionID"));
                obj.text = rs.getString("text");
                obj.correct = Integer.parseInt(rs.getString("correct"));
                answers.add(obj);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return answers;
    }

    public boolean UpdateAnswer(int idA) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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

            String sqlString = "update answer set questionID = '" + questionId + "', text = '" + text 
                    + "', correct = '" + correct + "' where id = '" + idA + "';";
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
    
    public boolean DeleteAnswer(int idA) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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

            String sqlString = "delete from answer where id = '" + idA + "';";
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
