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
@WebServlet(name = "Cadd_question_answer", urlPatterns = {"/Cadd_question_answer"})
public class Cadd_question_answer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String type = request.getParameter("type");
            MExam obje = new MExam();
            ArrayList<MExam> exams = obje.GetExamsType(type);
            boolean addQuestion = false;
            for(int i=0; i<exams.size(); i++)
            {
                MQuestion objq = new MQuestion();
                objq.examId = exams.get(i).id;
                objq.text = request.getParameter("question");
                addQuestion = objq.AddQuestion();
            }
            ArrayList<String> answer = new ArrayList();
            ArrayList<Integer> correct = new ArrayList();
            for(int i=0; i<8; i++)
            {
                String ans = request.getParameter("answer" + (i+1));
                int cor = Integer.parseInt(request.getParameter("correct" + (i+1)));
                answer.add(ans);
                correct.add(cor);
            }
            ArrayList<MQuestion> questions = new ArrayList();
            for(int i=0; i<exams.size(); i++)
            {
                MQuestion obj = new MQuestion();
                questions = obj.GetQuestionByExamId(exams.get(i).id);
            }
            boolean addAnswer = false;
            for(int i=0; i<questions.size(); i++)
            {
                for(int j=0; j<answer.size(); j++)
                {
                    MAnswer obja = new MAnswer();
                    obja.questionId = questions.get(i).id; 
                    obja.text = answer.get(j);
                    obja.correct = correct.get(j);
                    addAnswer = obja.AddAnswer();
                }
            }
            request.setAttribute("addQuestion" , addQuestion);
            request.setAttribute("addAnswer" , addAnswer);
            getServletConfig().getServletContext().getRequestDispatcher("/Vres_add_question_answer.jsp").forward(request, response);
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
            Logger.getLogger(Cadd_question_answer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cadd_question_answer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cadd_question_answer.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Cadd_question_answer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cadd_question_answer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cadd_question_answer.class.getName()).log(Level.SEVERE, null, ex);
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
