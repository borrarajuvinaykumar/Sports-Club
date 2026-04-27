<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,dao.Cochdao,modal.Cochmodal" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello:<%=session.getAttribute("coch") %></h1>
<% String uname=(String)session.getAttribute("coch");
Cochdao cd=new Cochdao();
Cochmodal m=cd.getbyUsername(uname);
%>

<table>
<tr>
<th>Username</th>
<th>Email</th>
<th>Fullname</th>
<th>Password</th>
<th>Phone</th>
</tr>
<tr>
<td><%=m.getUsername() %></td>
<td><%=m.getEmail() %></td>
<td><%=m.getFullname() %></td>
<td><%=m.getPassword() %></td>
<td><%=m.getPhone() %></td>

</tr></table>
</body>
</html>