
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,dao.Cochdao, modal.Playermodal" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Cochdao ad=new Cochdao();
String uname=(String)session .getAttribute("coch");
List<Playermodal> p =ad.getPlayers(uname);
System.out.println(p);
%>

<h1>wellcome:<%=uname %></h1>
<table>




<tr>
<th>CochName</th>
<th>Player </th>
<th>Sports</th>
</tr>

<% for(Playermodal m:p){%>
<tr>
<td><%=uname %></td>
<td><%=m.getFullname() %></td>
<td><%=m.getSportsname() %></td>
</tr>
<%} %>
</table>


</body>
</html>