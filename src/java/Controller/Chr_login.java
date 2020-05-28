package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Mhr;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Om-mostafa El-Hariry
 */
@WebServlet(name = "Chr_login", urlPatterns = {"/Chr_login"})
public class Chr_login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
      Mhr hr = new Mhr();

                hr.email = request.getParameter("email");
                hr.password = request.getParameter("pwd");

                if(hr.CheckHR())
                {
                    Mhr hrr = new Mhr();
                    hrr.email = request.getParameter("email");
                    HttpSession sessionUser = request.getSession();
                    sessionUser.setAttribute("email",hrr.email);
                    getServletConfig().getServletContext().getRequestDispatcher("/Vhr_options.jsp").forward(request, response);
                }  
                else
                {
                    out.println("Either username or password is incorrect!");
                    getServletConfig().getServletContext().getRequestDispatcher("/Vhr_login.jsp").forward(request, response);
                }
               
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
