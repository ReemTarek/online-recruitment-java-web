package Controller;

import Model.MPosition;
import Model.Mcandidate;
import Model.McandidatePosition;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

/**
 *
 * @author Om-mostafa El-Hariry
 */
@WebServlet(name = "Cupload_cv", urlPatterns = {"/Cupload_cv"})
public class Cupload_cv extends HttpServlet 
{
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 500 * 1024;
    private int maxMemSize = 40 * 1024;
    private File file;
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
//            HttpSession sessionUser = request.getSession();
//            String cEmail = (String)sessionUser.getAttribute("email");
//            Mcandidate objc = new Mcandidate();
//            objc = objc.GetCandidateByEmail(cEmail);
//            String positionName = request.getParameter("position");
//            MPosition objp = new MPosition();
//            objp = objp.GetPositionByName(positionName);
//            
//            String cv = request.getParameter("file");
//            out.println("CV : " + cv);
//            McandidatePosition objCP = new McandidatePosition();
//            objCP.candidateId = objc.id;
//            objCP.positionId = objp.id;
//            objCP.cv = cv;
//            boolean addCandidatePosition = objCP.AddCandidatePosition();
//            getServletConfig().getServletContext().getRequestDispatcher("/Vcandidate_login.jsp").forward(request, response);
//    
            
            
//            InputStream inputStream = null; 
//            Part filePart = request.getPart("file");
//            if (filePart != null) {
//            // prints out some information for debugging
//            out.println(filePart.getName());
//            out.println(filePart.getSize());
//            out.println(filePart.getContentType());
//             
//            // obtains input stream of the upload file
//            inputStream = filePart.getInputStream();
//            }
//            if (inputStream != null) {
//                // fetches input stream of the upload file for the blob column
//            //    request.setAttribute("inputStream", inputStream);
//                objCP.cv = inputStream;
//            }
        }
    }

    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("multipart" + isMultipart);
        if (!isMultipart) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();

        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);

        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("C:\\xampp\\tomcat\\webapps\\uploads"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);

        try {
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            String fileName = null;
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);
                    out.println("Uploaded Filename: " + fileName + "<br>");
                    out.println("Uploaded Filename: " + filePath + fileName + "<br>");
                }
            }
            HttpSession sessionUser = request.getSession();
            String cEmail = (String)sessionUser.getAttribute("email");
            Mcandidate objc = new Mcandidate();
            objc = objc.GetCandidateByEmail(cEmail);
            String positionName = (String)sessionUser.getAttribute("position");
            MPosition objp = new MPosition();
            objp = objp.GetPositionByName(positionName);
            
            McandidatePosition objCP = new McandidatePosition();
            objCP.candidateId = objc.id;
            objCP.positionId = objp.id;
            objCP.cv = filePath + fileName;
            boolean addCandidatePosition = objCP.AddCandidatePosition();
            getServletConfig().getServletContext().getRequestDispatcher("/Vcandidate_login.jsp").forward(request, response);
    
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        throw new ServletException("GET method used with "
                + getClass().getName() + ": POST method required.");
    }
}