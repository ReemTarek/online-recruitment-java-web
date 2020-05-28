package Model;

/**
 *
 * @author Om-mostafa El-Hariry
 */
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class McandidateExam 
{
    public int id;
    public int candidateID;
    public int examID;
    public int questionID;
    public int answerID;
    public Date examDate;
    public Date deadline;
    public int score;
    public McandidateExam()
    {
        id = 0;
        candidateID = 0;
        examID = 0;
        questionID = 0;
        answerID = 0;
        examDate = null;
        deadline = null;
        score = 0;
    }
    public ArrayList<Mcandidate> GetCandidateByExamType(String examType) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        MExam obj = new MExam();
        ArrayList<MExam> examsWithType = obj.GetExamsType(examType);
        ArrayList<Integer> examsId = new ArrayList();
        
        for(int i=0; i<examsWithType.size(); i++)
        {
            
            examsId.add(examsWithType.get(i).id);
        }
       
        ArrayList<Integer> candidatesId = GetCandidateIdByExamId(examsId);
        ArrayList<Mcandidate> candidates = new ArrayList();
        Mcandidate cObj = new Mcandidate();
        for(int i=0; i<candidatesId.size(); i++)
        {
            candidates.add(cObj.GetCandidateById(candidatesId.get(i)));
        }
        return candidates;
    }
    
    public ArrayList<Integer> GetCandidateIdByExamId(ArrayList<Integer> examsId)
    {
        ArrayList<Integer> candidatesID = new ArrayList();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stat = Con.createStatement();
        
            for(int i=0; i<examsId.size(); i++)
            {
                PreparedStatement ps1 = Con.prepareStatement("select * from candidate_exam where examID = '" + examsId.get(i) + "';");

                ResultSet rs = ps1.executeQuery();
                while (rs.next()) 
                {
                    int eID;
                    eID = Integer.parseInt(rs.getString("candidateID"));
                    candidatesID.add(eID);
                }
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return candidatesID;
    }
    
    public ArrayList<Mcandidate> GetCandidateByExamDate(String examDate) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException
    {
        McandidateExam obj = new McandidateExam();
        ArrayList<Integer> examsId = obj.GetExamsByDate(examDate);
        
        ArrayList<Integer> candidatesId = GetCandidateIdByExamId(examsId);
        ArrayList<Mcandidate> candidates = new ArrayList();
        for(int i=0; i<candidatesId.size(); i++)
        {
            Mcandidate cObj = new Mcandidate();
            candidates.add(cObj.GetCandidateById(candidatesId.get(i)));
        }
        return candidates;
    }
    public ArrayList<Integer> GetExamsByDate(String examDate) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException
    {        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        Date date = formatter.parse(examDate);  
        String strDate= formatter.format(date);
        //System.out.println(strDate);
        java.util.Date d = formatter.parse(strDate);
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        //System.out.println("******** " + sqlDate);
        ArrayList<Integer> examsId = new ArrayList();
        try 
        {
            String user_name = "root";
            String pass = "";
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection Con = DriverManager.getConnection(url, user_name, pass);
            Statement stmt = Con.createStatement();
            String sqlString = "select * from candidate_exam where examDate = '" + sqlDate + "'";
            ResultSet res = stmt.executeQuery(sqlString);
            while (res.next()) 
            {
                int examId;
                examId = Integer.parseInt(res.getString("examID"));
                examsId.add(examId);
            }
            res.close();
            stmt.close();
            Con.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return examsId;
    }
     public boolean saveCanAnswer() throws ClassNotFoundException
   { try
        {    
           String user_name = "root";
            String pass = "";
            Connection Con = null;
            Statement stat = null;
            String dataBaseName = "interview";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            try {

               try {
                   Class.forName("com.mysql.jdbc.Driver").newInstance();
               } catch (InstantiationException ex) {
                   Logger.getLogger(McandidateExam.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IllegalAccessException ex) {
                   Logger.getLogger(McandidateExam.class.getName()).log(Level.SEVERE, null, ex);
               }

                Con = DriverManager.getConnection(url, user_name, pass);

                stat = Con.createStatement();
                
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
   
            String sqlString="INSERT INTO candidate_exam (candidateID,examID,questionID,answerID,examDate,deadline,score) VALUES "
                    + "('"+candidateID+"','"+examID+"','"+questionID+"','"+answerID+"','"+examDate+"','"+deadline+"','"+score+"')";
            
            int count= stat.executeUpdate(sqlString);
            if(count > 0){
                     try
            {    
                //myStatement.executeUpdate(sqlString);
                stat.close();
                Con.close();
            } catch (SQLException ex) {Logger.getLogger(McandidateExam.class.getName()).log(Level.SEVERE, null, ex);}
               return true;
            }
            else{
                     try
            {    
                //myStatement.executeUpdate(sqlString);
                stat.close();
                Con.close();
            } catch (SQLException ex) {Logger.getLogger(McandidateExam.class.getName()).log(Level.SEVERE, null, ex);}
               return false;
            }
       
        } catch (SQLException ex) {Logger.getLogger(McandidateExam.class.getName()).log(Level.SEVERE, null, ex);}  
        return false;
   }
}
