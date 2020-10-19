<%@ page import="model.domain.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="model.db.DatabaseStudent" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Info: Overzicht</title>
</head>
<body>
<table class="tabel">
    <thead>
    <th>achternaam</th>
    <th>voornaam</th>
    <th>richting</th>
    <th>leeftijd</th>
    </thead>
    <%!ArrayList<Student> students = new ArrayList<>();%>
    <%students =  (ArrayList<Student>)request.getAttribute("db");%>
    <%for (int i = 0; i < students.size(); i++){%>
    <tr>
        <td><p><%=students.get(i).getNaam()%></p></td>
        <td><p><%=students.get(i).getVoornaam()%></p></td>
        <td><p><%=students.get(i).getStudierichting()%></p></td>
        <td><p><%=students.get(i).getLeeftijd()%></p></td>
    </tr>
    <%}%>
</table>
</body>
</html>
