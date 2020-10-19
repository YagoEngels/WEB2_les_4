<%@ page import="model.db.DatabaseStudent" %><%--
  Created by IntelliJ IDEA.
  User: yagoe
  Date: 6-10-2020
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>student info : persoonlijk </title>
  </head>
  <body>
  <%  DatabaseStudent databaseStudent = new DatabaseStudent();
    String naam = (String) request.getAttribute("achternaam");
    String voornaam = (String)request.getAttribute("voornaam");
    System.out.println(naam);
    System.out.println(voornaam);
    String abc = databaseStudent.getleeftijdEnRichting(naam,voornaam);
    if (abc.trim().isEmpty()){
      abc = "er is geen informatie over deze student probeer een anderen student";
    }
  %>
  <p><%=abc%></p>
  </body>
</html>
