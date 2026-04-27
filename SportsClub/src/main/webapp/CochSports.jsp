<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,dao.Cochdao, modal.SportsModal" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Cochdao ad=new Cochdao();
String uname=(String)session .getAttribute("coch");
List<SportsModal> list=ad.getrecord(uname);
%>

<h1>wellcome:<%=uname %></h1>
<table>




<tr>
<th>CochName</th>
<th>sports </th>
</tr>

<% for(SportsModal m:list){%>
<tr>
<td><%=uname %></td>
<td><%=m.getSportname() %></td>
</tr>
<%} %>
</table>


</body>
</html>