package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Mcandidate;
import Model.McandidatePosition;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import Model.MPosition;
@WebServlet(urlPatterns = {"/Ccandidate_login"})
public class Ccandidate_login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Mcandidate candidate = new Mcandidate();
            candidate.username = request.getParameter("username");
            candidate.password = request.getParameter("pwd");
            candidate.email = request.getParameter("email");
            if (candidate.CheckCandidate()==true) {
                Mcandidate can = new Mcandidate();
                can.username = request.getParameter("username");
                can.email = request.getParameter("email");
                Mcandidate cn = candidate.GetCandidateByEmail(candidate.email);
                McandidatePosition cp = new McandidatePosition();
                ArrayList<McandidatePosition> arr = cp.GetCandidatePositionByCId(cn.id);
                ArrayList<String> canstates =  new ArrayList();
                ArrayList<String> postionname =  new ArrayList();
                for(int i=0;i<arr.size();i++)
                {
                    MPosition pos = new MPosition();
                    pos = pos.GetPositionById(arr.get(i).positionId);
                    postionname.add(pos.name);
                    canstates.add(arr.get(i).state);
                }
                HttpSession sessionUser = request.getSession();
                sessionUser.setAttribute("states",canstates);
                sessionUser.setAttribute("posname", postionname);
                sessionUser.setAttribute("email ", can.email);
                getServletConfig().getServletContext().getRequestDispatcher("/VCandidate_state.jsp").forward(request, response);
            } else {
                out.println("Either username or password is incorrect!");
                out.println("<a href=\"login_form.jsp\">Try again...</a>");
            }
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ccandidate_login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ccandidate_login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ccandidate_login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ccandidate_login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ccandidate_login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ccandidate_login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
