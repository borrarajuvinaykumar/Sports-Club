<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, dao.Playerdao, modal.SportModal" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
Playerdao dao = new Playerdao();
String uname = (String) session.getAttribute("un");
List<SportModal> list = dao.getMySports(uname);
%>
<h1>welcome:<%=uname %></h1>
<h2>My Sports</h2>

<table border="1">
<tr>
    <th>Sport Name</th>
    <th>sports</th>
</tr>

<%
for(SportModal s : list){
%>
<tr>
<td><%=uname %></td>
    <td><%= s.getSportname() %></td>
</tr>
<%
}
%>

</table>

<a href="PlayerDashboard.jsp">Back</a>
</body>
</html>