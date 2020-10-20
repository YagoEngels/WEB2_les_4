package ui.controler;
import model.db.DatabaseStudent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebServlet("/servlet")
public class servlet extends HttpServlet {

    DatabaseStudent databaseStudent = new DatabaseStudent();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giverOfTasks(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giverOfTasks(request,response);
    }

    private void giverOfTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String task = "home";
        if (request.getParameter("task") != null){
            task = request.getParameter("task");
            System.out.println(task);
        }

        String a = "";
        switch (task){
            case "home":
                a = home(request,response);
                break;
            case "overview":
                a = overview(request,response);
                break;
            case "find":
                a = find(request,response);
                break;
        }
        request.getRequestDispatcher(a).forward(request, response);
    }

    private String home (HttpServletRequest request, HttpServletResponse response){
        return "index.html";
    }
    private String overview (HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("db",databaseStudent.getStudents());
        return "studentInfoOverzicht.jsp";
    }
    private String find (HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");
        String achternaam = request.getParameter("achternaam");

        String abc = databaseStudent.getleeftijdEnRichting(achternaam,naam);
        if (abc.trim().isEmpty()){
            abc = "er is geen informatie over deze student probeer een anderen student";
        }
        request.setAttribute("TheOneString", abc);
        return ("studentGet.jsp");
    }
}
