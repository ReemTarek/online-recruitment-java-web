package Controller;

import Model.MAnswer;
import Model.MExam;
import Model.MQuestion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Om-mostafa El-Hariry
 */
@WebServlet(name = "Cupdate_question_answer", urlPatterns = {"/Cupdate_question_answer"})
public class Cupdate_question_answer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            MQuestion objq = new MQuestion();
            objq.id = Integer.parseInt(request.getParameter("id"));
            objq.examId = objq.GetQuestionById(objq.id);
            objq.text = request.getParameter("question");
            boolean updateQuestion = false;
            updateQuestion = objq.UpdateQuestion(objq.id);
            
            ArrayList<String> answer = new ArrayList();
            ArrayList<Integer> correct = new ArrayList();
            for(int i=0; i<8; i++)
            {
                String ans = request.getParameter("answer" + (i+1));
                int cor = Integer.parseInt(request.getParameter("correct" + (i+1)));
                answer.add(ans);
                correct.add(cor);
            }
            MAnswer obj =  new MAnswer();
            ArrayList<MAnswer> answers = obj.GetAnswersByQuestionId(objq.id);
            boolean updateAnswer = false;
            for(int i=0; i<answers.size(); i++)
            {
                MAnswer obja = new MAnswer();
                obja.questionId = objq.id; 
                obja.text = answer.get(i);
                obja.correct = correct.get(i);
                updateAnswer = obja.UpdateAnswer(answers.get(i).id);
            }

            request.setAttribute("updateQuestion" , updateQuestion);
            request.setAttribute("updateAnswer" , updateAnswer);
            getServletConfig().getServletContext().getRequestDispatcher("/Vres_update_question_answer.jsp").forward(request, response);
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
        } catch (InstantiationException ex) {
            Logger.getLogger(Cupdate_question_answer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cupdate_question_answer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cupdate_question_answer.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (InstantiationException ex) {
            Logger.getLogger(Cupdate_question_answer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cupdate_question_answer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cupdate_question_answer.class.getName()).log(Level.SEVERE, null, ex);
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
