<%-- 
    Document   : Vres_prepare_exam
    Created on : Dec 23, 2019, 11:10:37 PM
    Author     : Om-mostafa El-Hariry
--%>
<%@page import="java.util.Random"%>
<%@page import="Model.MAnswer"%>
<%@page import="Model.MQuestion"%>
<%@page import="Model.MExam"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<MExam> selectedExams = (ArrayList<MExam>) request.getAttribute("selectedExams");
    ArrayList<ArrayList<MQuestion>> selectedQuestions = (ArrayList<ArrayList<MQuestion>>)request.getAttribute("randomQuestions");
    ArrayList<ArrayList<ArrayList<MAnswer>>> correctSelectedAnswers = (ArrayList<ArrayList<ArrayList<MAnswer>>>)request.getAttribute("correctRandomAnswers");
    ArrayList<ArrayList<ArrayList<MAnswer>>> wrongSelectedAnswers = (ArrayList<ArrayList<ArrayList<MAnswer>>>)request.getAttribute("wrongRandomAnswers");
    Random rand = new Random();
//    for(int i=0; i<selectedExams.size(); i++)
//    {
//        out.println("Exam Type: " + selectedExams.get(i).type + "<br><br>");
//        //for(int j=0; j<selectedQuestions.get(i).size(); j++)
//        //{
//            ArrayList<Integer> qR = new ArrayList();
//            int it = 0;
//            if(selectedQuestions.get(i).size() < 5)
//                it = selectedQuestions.get(i).size();
//            else 
//                it = 5;
//            for(int n=0; n<selectedQuestions.get(i).size(); n++)
//            {
//                int r = rand.nextInt((selectedQuestions.get(i).size()-1) +1);
//                if(!qR.contains(r))
//                {
//                    qR.add(r);
//                }
//                else 
//                    n--;
//                if(qR.size() == it)
//                    break;
//            }
//            for(int a = 0; a<qR.size(); a++)
//            {
//                out.println("Q" + (a+1) + ":" + selectedQuestions.get(i).get(a).text + "<br>");
////                for(int n=0; n<correctSelectedAnswers.size(); n++)
////                {
////                    for(int b=0; b<correctSelectedAnswers.get(n).size(); b++)
////                    {
////                        ArrayList<Integer> cAR = new ArrayList();
////                        int cIt = 0;
////                        if(correctSelectedAnswers.get(i).get(a).size() < 1)
////                            cIt = wrongSelectedAnswers.get(i).get(a).size();
////                        else 
////                            cIt = 1;
////
////                        for(int c=0; c<correctSelectedAnswers.get(n).get(b).size(); c++)
////                        {
////                            int r = rand.nextInt((correctSelectedAnswers.get(n).get(b).size()-1) + 1);
////                            if(!cAR.contains(r))
////                                cAR.add(r);
////                            else
////                                c--;
////                            if(cAR.size() == cIt)
////                                break;
////                        }
////                        for(int d = 0; d<cAR.size(); d++)
////                        {
////                            out.println("<input type = 'radio' name = 'cAnswer' "
////                                    + " value = '" + correctSelectedAnswers.get(n).get(b).get(d).text +
////                                    "'> '" + correctSelectedAnswers.get(n).get(b).get(d).text + "'<br>");
////                        }
////                    }
////                }
////                for(int n=0; n<wrongSelectedAnswers.size(); n++)
////                {
////                    for(int b=0; b<wrongSelectedAnswers.get(n).size(); b++)
////                    {
////                        ArrayList<Integer> wAR = new ArrayList();
////                        int wIt = 0;
////                        if(wrongSelectedAnswers.get(i).get(j).size() < 3)
////                          wIt = wrongSelectedAnswers.get(i).get(j).size();
////                        else 
////                            wIt = 3;
////                        for(int c=0; c<wrongSelectedAnswers.get(n).get(b).size(); c++)
////                        {
////                            int r = rand.nextInt((wrongSelectedAnswers.get(n).get(b).size()-1) + 1);
////                            if(!wAR.contains(r))
////                                wAR.add(r);
////                            else
////                                c--;
////                            if(wAR.size() == wIt)
////                                break;
////                        }
////                        for(int d = 0; d<wAR.size(); d++)
////                        {
////                            out.println("<input type = 'radio' name = 'cAnswer' "
////                                    + " value = '" + wrongSelectedAnswers.get(n).get(b).get(d).text +
////                                    "'> '" + wrongSelectedAnswers.get(n).get(b).get(d).text + "'<br>");
////                        }
////                    }
////                }
//            }
//        }
    }
%>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Exam</title>
    </head>
    <body>
    </body>
</html>
