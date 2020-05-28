package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.MExam;
import Model.MPosition;
/**
 *
 * @author Om-mostafa El-Hariry
 */
@WebServlet(name = "Chr_options", urlPatterns = {"/Chr_options"})
public class Chr_options extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String option = request.getParameter("option");
            if (option.equals("edit_position")) 
            {
                MPosition p = new MPosition();
                ArrayList<MPosition> positions = p.GetPositions();
                request.setAttribute("positions", positions);
                getServletConfig().getServletContext().getRequestDispatcher("/Vposition.jsp").forward(request, response);
            } 
            else if (option.equals("edit_exam")) 
            {
                MExam e = new MExam();
                ArrayList<MExam> exams = e.GetExams();
                request.setAttribute("exams", exams);
                getServletConfig().getServletContext().getRequestDispatcher("/Vexam.jsp").forward(request, response);
            }
            else
                System.out.println("Invalid Option");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
