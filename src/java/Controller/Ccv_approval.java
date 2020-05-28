package Controller;

import Model.MPosition;
import Model.Mcandidate;
import Model.McandidatePosition;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Om-mostafa El-Hariry
 */
@WebServlet(name = "Ccv_approval", urlPatterns = {"/Ccv_approval"})
public class Ccv_approval extends HttpServlet {

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
            McandidatePosition objCP = new McandidatePosition();
            ArrayList<McandidatePosition> candidatePosition = objCP.GetCandidatePositionByState("null");
            ArrayList<MPosition> positions = new ArrayList();
            for(int i=0; i<candidatePosition.size(); i++)
            {
                MPosition obj = new MPosition();
                obj = obj.GetPositionById(candidatePosition.get(i).positionId);
                positions.add(obj);
            }
            ArrayList<Mcandidate> candidate = new ArrayList();
            for(int i=0; i<candidatePosition.size(); i++)
            {
                Mcandidate objc = new Mcandidate();
                objc = objc.GetCandidateById(candidatePosition.get(i).candidateId);
                candidate.add(objc);
            }
            request.setAttribute("candidate", candidate);
            request.setAttribute("candidatePosition", candidatePosition);
            request.setAttribute("positions", positions);
            out.println("servlet : " + positions.get(0).id);
            out.println("servlet : " + candidate.get(0).id);
            getServletConfig().getServletContext().getRequestDispatcher("/Vcv_approval.jsp").forward(request, response);
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
