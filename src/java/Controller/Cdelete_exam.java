package Controller;

import Model.MAnswer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.MExam;
import Model.MQuestion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Om-mostafa El-Hariry
 */
@WebServlet(name = "Cdelete_exam", urlPatterns = {"/Cdelete_exam"})
public class Cdelete_exam extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            MExam objE = new MExam();
            objE.id = Integer.parseInt(request.getParameter("id"));
            boolean deleteExam = objE.DeleteExam(objE.id);
            MQuestion objQ = new MQuestion();
            ArrayList<MQuestion> questionId = objQ.GetQuestionByExamId(objE.id);
            boolean deleteQuestion = false;
            for(int i=0; i<questionId.size(); i++)
            {
                deleteQuestion = objQ.DeleteQuestion(questionId.get(i).id);
            }
            ArrayList<ArrayList<MAnswer>> answersId = new ArrayList();
            MAnswer objA = new MAnswer();
            for(int i=0; i<questionId.size(); i++)
            {
                ArrayList<MAnswer> answerID = new ArrayList();
                answerID = objA.GetAnswersByQuestionId(questionId.get(i).id);
                answersId.add(answerID);
            }
            boolean deleteAnswer = false;
            for(int i=0; i<answersId.size(); i++)
            {
                for(int j=0; j<answersId.get(i).size(); j++)
                {
                    deleteAnswer = objA.DeleteAnswer(answersId.get(i).get(j).id);
                }
            }
            request.setAttribute("deleteExam", deleteExam);
            request.setAttribute("deleteQuestion", deleteQuestion);
            request.setAttribute("deleteAnswer", deleteAnswer);
            getServletConfig().getServletContext().getRequestDispatcher("/Vres_delete_exam.jsp").forward(request, response);
       }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cdelete_exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cdelete_exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cdelete_exam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cdelete_exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cdelete_exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cdelete_exam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
