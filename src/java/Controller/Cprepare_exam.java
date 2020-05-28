package Controller;

import Model.MAnswer;
import Model.MExam;
import Model.MQuestion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
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
@WebServlet(name = "Cprepare_exam", urlPatterns = {"/Cprepare_exam"})
public class Cprepare_exam extends HttpServlet {

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
            String[] type = request.getParameterValues("examType");
            out.println("type : " + type[0] + "   " + type[1]);
            ArrayList<MExam> selectedExams = new ArrayList();
            if(type != null)
            {
                for(int i=0; i<type.length; i++)
                {
                    MExam obj = new MExam();
                    obj = obj.GetExamByType(type[i]);
                    selectedExams.add(obj);
                }
            }
            out.println("selecedexams : "  + selectedExams.size() + "    " + selectedExams.get(0).type + "   " + selectedExams.get(1).type);
            ArrayList<ArrayList<MQuestion>> selectedQuestions = new ArrayList();
            for(int i=0; i< selectedExams.size(); i++)
            {
                MQuestion obj = new MQuestion();
                ArrayList<MQuestion> arrObj = obj.GetQuestionByExamId(selectedExams.get(i).id);
                selectedQuestions.add(arrObj);
            }
            out.println("selectedQuestions : " + selectedQuestions.size());
            out.println("  " + selectedQuestions.get(0).size() + "    " + selectedQuestions.get(1).size());
            ArrayList<ArrayList<ArrayList<MAnswer>>> selectedAnswers = new ArrayList();
            for(int i=0; i<selectedQuestions.size(); i++)
            {
                ArrayList<ArrayList<MAnswer>> answersForOneExam = new ArrayList();
                for(int j=0; j<selectedQuestions.get(i).size(); j++)
                {
                    MAnswer obj = new MAnswer();
                    ArrayList<MAnswer> arrObj = obj.GetAnswersByQuestionId(selectedQuestions.get(i).get(j).id);
                    answersForOneExam.add(arrObj);
                }
                selectedAnswers.add(answersForOneExam);
            }
            out.println("selectedAnswers : " + selectedAnswers.size());
            out.println("  " + selectedAnswers.get(0).size() + "    " + selectedAnswers.get(1).size());
            out.println("   " + selectedAnswers.get(0).get(0).size());
            ArrayList<ArrayList<MQuestion>> randomQuestionsForAllExams = new ArrayList();
            Random rand = new Random();
            for(int i=0; i<selectedQuestions.size(); i++)
            {
                ArrayList<MQuestion> randomQuestions = new ArrayList();
                ArrayList<Integer> arrRand = new ArrayList();
                int it = 0;
                if(selectedQuestions.get(i).size() < 5)
                    it = selectedQuestions.get(i).size();
                else 
                    it = 5;
                for(int j=0; j<it; j++)
                {       
                    int r = rand.nextInt((selectedQuestions.get(i).size()-1) +1);
                    out.println("R : " + r);
                    if(!arrRand.contains(r))
                    {
                        arrRand.add(r);
                        randomQuestions.add(selectedQuestions.get(i).get(r));
                    }
                    else
                        j--;
                }
                out.println("\n arrRandQ : " + arrRand);
                randomQuestionsForAllExams.add(randomQuestions);
            }
            ArrayList<ArrayList<ArrayList<MAnswer>>> correctAnswersForAllExams = new ArrayList();
            ArrayList<ArrayList<ArrayList<MAnswer>>> wrongAnswersForAllExams = new ArrayList();
            for(int i=0; i<selectedAnswers.size(); i++)
            {
                ArrayList<ArrayList<MAnswer>> correctAnswersForAllQuestionsForOneExam = new ArrayList();
                ArrayList<ArrayList<MAnswer>> wrongAnswersForAllQuestionsForOneExam = new ArrayList();
                for(int j=0; j<selectedAnswers.get(i).size(); j++)
                {
                    ArrayList<MAnswer> correctAnswers = new ArrayList();
                    ArrayList<MAnswer> wrongAnswers = new ArrayList();
                    for(int n=0; n<selectedAnswers.get(i).get(j).size(); n++)
                    {
                        if(selectedAnswers.get(i).get(j).get(n).correct == 1)
                            correctAnswers.add(selectedAnswers.get(i).get(j).get(n));
                        else
                            wrongAnswers.add(selectedAnswers.get(i).get(j).get(n));
                    }
                    correctAnswersForAllQuestionsForOneExam.add(correctAnswers);
                    wrongAnswersForAllQuestionsForOneExam.add(wrongAnswers);
                }
                correctAnswersForAllExams.add(correctAnswersForAllQuestionsForOneExam);
                wrongAnswersForAllExams.add(wrongAnswersForAllQuestionsForOneExam);
            }
            
            ArrayList<ArrayList<ArrayList<MAnswer>>> correctRandomAnswersForAllExams = new ArrayList();
            ArrayList<ArrayList<ArrayList<MAnswer>>> wrongRandomAnswersForAllExams = new ArrayList();
            for(int i=0; i<selectedAnswers.size(); i++)
            {
                ArrayList<ArrayList<MAnswer>> correctRandomAnswersForAllQuestionsForOneExam = new ArrayList();
                ArrayList<ArrayList<MAnswer>> wrongRandomAnswersForAllQuestionsForOneExam = new ArrayList();
                for(int j=0; j<selectedAnswers.get(i).size(); j++)
                {
                    ArrayList<MAnswer> correctRandomAnswers = new ArrayList();
                    ArrayList<MAnswer> wrongRandomAnswers = new ArrayList();
                    ArrayList<Integer> wrongRand = new ArrayList();
                    ArrayList<Integer> correctRand = new ArrayList();

                    int wIt = 0;
                    if(wrongAnswersForAllExams.get(i).get(j).size() < 3)
                        wIt = wrongAnswersForAllExams.get(i).get(j).size();
                    else 
                        wIt = 3;
                    for(int n=0; n<wIt; n++)
                    {
                        int wR = rand.nextInt((wrongAnswersForAllExams.get(i).get(j).size()-1) +1);
                        if(!wrongRand.contains(wR))
                        {
                            wrongRand.add(wR);
                            wrongRandomAnswers.add(wrongAnswersForAllExams.get(i).get(j).get(n));
                        }
                        else
                            n--;
                    }
                    int cIt = 0;
                    if(correctAnswersForAllExams.get(i).get(j).size() < 1)
                        cIt = wrongAnswersForAllExams.get(i).get(j).size();
                    else 
                        cIt = 1;
                    
                    for(int n=0; n<cIt; n++)
                    {
                        int cR = rand.nextInt((correctAnswersForAllExams.get(i).get(j).size()-1) +1);
                        if(!correctRand.contains(cR))
                        {
                            correctRand.add(cR);
                            correctRandomAnswers.add(correctAnswersForAllExams.get(i).get(j).get(n));
                        }
                        else
                            n--;
                    }
                    correctRandomAnswersForAllQuestionsForOneExam.add(correctRandomAnswers);
                    wrongRandomAnswersForAllQuestionsForOneExam.add(wrongRandomAnswers);
                }
                correctRandomAnswersForAllExams.add(correctRandomAnswersForAllQuestionsForOneExam);
                wrongRandomAnswersForAllExams.add(wrongRandomAnswersForAllQuestionsForOneExam);
            }
            out.println("*****************************");
            out.println("Exam : " + selectedExams.size());
            out.println("Qestions : " + randomQuestionsForAllExams.size());
            out.println("Correct Answers : " + correctRandomAnswersForAllExams.size());
            out.println("Wrong Answers : " + wrongRandomAnswersForAllExams.size());
            
            request.setAttribute("selectedExams", selectedExams);
            request.setAttribute("randomQuestions", randomQuestionsForAllExams);
            request.setAttribute("correctRandomAnswers", correctRandomAnswersForAllExams);
            request.setAttribute("wrongRandomAnswers", wrongRandomAnswersForAllExams);
            getServletConfig().getServletContext().getRequestDispatcher("/Vres_prepare_exam.jsp").forward(request, response);
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
            Logger.getLogger(Cprepare_exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cprepare_exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cprepare_exam.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Cprepare_exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cprepare_exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cprepare_exam.class.getName()).log(Level.SEVERE, null, ex);
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
