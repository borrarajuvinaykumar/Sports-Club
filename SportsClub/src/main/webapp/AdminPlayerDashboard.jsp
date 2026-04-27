<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*,dao.AdminDAO,modal.Playermodal" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<%
AdminDAO  ad=new AdminDAO();
List<Playermodal> list =ad.getAllPlayers();

%>

<a href="AdminPlayerRegistration.jsp">AdminPlayerRegistration</a>

<table border=1 class="table table-hover table-striped table-dark">
<tr>
<th>FULLNAME</th>
<th>USERNAME</th>
<th>PASSWORD</th>
<th>EMAIL</th>
<th>PHONE</th>
<th colspan=2>ACTION</th>
</tr>
<% for(Playermodal pm:list){ %>
<tr> 
<td> <%=pm.getFullname() %></td> 
<td><%=pm.getUsername() %></td>
<td> <%=pm.getPassword() %></td>
<td><%=pm.getEmail() %>  </td>
<td><%=pm.getPhone() %></td>
<td> <a href="EditPlayer.jsp?u=<%=pm.getUsername()%>">Edit</a>  </td>
<td><a href="PlayerDeleteController?u=<%=pm.getUsername()%>">Delete</a></td>
</tr>
<%} %>


</table>
</body>
</html>