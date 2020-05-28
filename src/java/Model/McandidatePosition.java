package Model;

import java.io.InputStream;
import static java.lang.System.out;
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
public class McandidatePosition 
{
    public int candidateId;
    public int positionId;
    public String state;
    //public InputStream cv;
    public String cv;
    public String exam_state;
    public McandidatePosition()
    {
        candidateId = 0;
        positionId = 0;
        state = null;
        cv = null;
        exam_state=null;
    }
    
    public ArrayList<McandidatePosition> GetCandidatesPosition() 
    {
        ArrayList<McandidatePosition> candidatePosition = new ArrayList();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();

            PreparedStatement ps1 = Con.prepareStatement("select * from candidate_position");
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {
                McandidatePosition obj = new McandidatePosition();
                obj.candidateId = Integer.parseInt(rs.getString("candidateID"));
                obj.positionId = Integer.parseInt(rs.getString("positionId"));
                obj.state = rs.getString("state");
                obj.cv = rs.getString("cv");
                 obj.exam_state = rs.getString("exam_state");
                candidatePosition.add(obj);
            }
            stat.close();
            Con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return candidatePosition;
    }
    public ArrayList<McandidatePosition> GetCandidatePositionByCId(int cId) 
    {
        ArrayList<McandidatePosition> candidatePosition = new ArrayList();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();

            PreparedStatement ps1 = Con.prepareStatement("select * from candidate_position where "
                    + " candidateID = '" + cId + "';");
            ResultSet rs = ps1.executeQuery();
            McandidatePosition ps= new McandidatePosition();
            while (rs.next()) 
            {
                ps.state = rs.getString("state");
                ps.exam_state = rs.getString("exam_state");
                ps.positionId = Integer.parseInt(rs.getString("positionID"));
                candidatePosition.add(ps);
            }
            stat.close();
            Con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return candidatePosition;
    }
    public McandidatePosition GetCandidatePositionByCIdANDPId(int cId, int pId) 
    {
        McandidatePosition candidatePosition = new McandidatePosition();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();

            PreparedStatement ps1 = Con.prepareStatement("select * from candidate_position where "
                    + " candidateID = '" + cId + "' and positionID = '" + pId + "';");
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {
                candidatePosition.state = rs.getString("state");
                candidatePosition.exam_state = rs.getString("exam_state");
                candidatePosition.cv = rs.getString("cv");
            }
            stat.close();
            Con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return candidatePosition;
    }
    public ArrayList <McandidatePosition> GetCandidatePositionByState(String pState) 
    {
        ArrayList <McandidatePosition> candidateState = new ArrayList<>();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();

            PreparedStatement ps1 = Con.prepareStatement("select * from candidate_position where state = '" 
                    + pState + "';");
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {McandidatePosition obj = new McandidatePosition();
                obj.state = rs.getString("state");
                obj.cv = rs.getString("cv");
                obj.candidateId = Integer.parseInt(rs.getString("candidateID"));
                obj.positionId = Integer.parseInt(rs.getString("positionId"));
                obj.exam_state =rs.getString("exam_state");
                candidateState.add(obj);        
            }
            stat.close();
            Con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return candidateState;
    }
    public ArrayList <McandidatePosition> GetCandidatePositionByExamState(String EState) 
    {
        ArrayList <McandidatePosition> candidateState = new ArrayList<>();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();

            PreparedStatement ps1 = Con.prepareStatement("select * from candidate_position where exam_state = '" 
                    + EState + "';");
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) 
            {
                McandidatePosition obj = new McandidatePosition();
                obj.state = rs.getString("state");
                obj.cv = rs.getString("cv");
                obj.candidateId = Integer.parseInt(rs.getString("candidateID"));
                obj.positionId = Integer.parseInt(rs.getString("positionId"));
                obj.exam_state = rs.getString("exam_state");
                if(obj.state.equals("approve"))
                {
                   candidateState.add(obj);
                }
            }
            stat.close();
            Con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return candidateState;
    }

    public boolean UpdateCandidatePositionByState(int cid, int pid, String EState) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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
            String sqlString = "UPDATE candidate_position SET exam_state= '" 
                    + EState + "' where candidateID = '" + cid + "' and positionID = '" + pid + "';";
           
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

    
    public boolean UpdateCandidatePositionByExamState(int cid, int pid, String EState) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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
            String sqlString = "UPDATE candidate_position SET exam_state= '" 
                    + EState + "' where candidateID = '" + cid + "' and positionID = '" + pid + "';";
           
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

    public boolean AddCandidatePosition() throws ClassNotFoundException, InstantiationException, IllegalAccessException 
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
            String sqlString = "INSERT INTO candidate_position (candidateID, positionID, state, cv , exam_state) VALUES ('" 
                    + candidateId + "','" + positionId + "','" + state + "','" + cv + "','" + exam_state + "')";
            
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
}
