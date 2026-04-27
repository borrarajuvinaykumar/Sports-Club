<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*,dao.AdminDAO,modal.MatchesModal"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminDAO ad=new AdminDAO();
	List<MatchesModal> list=ad.getAllDetails();
	%>
	<a href="MatchRegistration.jsp">MatchRegistration</a>

	<table>
		<tr>
			<th>MatchID</th>
			<th>SportName</th>
			<th>Team1</th>
			<th>Team2</th>
			<th>MatchDate</th>
			<th>MatchTime</th>
			<th>Venue</th>
			<th>Status</th>
			<th>Delete</th>
		</tr>
		<% 
       for(MatchesModal mm:list){
       %>
		<tr>
			<td><%=mm.getMatchid()  %></td>
			<td><%=mm.getSportname()  %></td>
			<td><%=mm.getTeam1()  %></td>
			<td><%=mm.getTeam2()  %></td>
			<td><%=mm.getMatchdate()  %></td>
			<td><%=mm.getMatchtime()  %></td>
			<td><%=mm.getVenue()  %></td>
			<td><%=mm.getStatus()  %></td>
			<td><a href="MatchesDeleteController?m=<%=mm.getMatchid() %>">Delete</a></td>
			<td><a href="AdminEditMatchDashboard.jsp?m=<%=mm.getMatchid() %>">Edit</a></td>

		</tr>
		<%
       }
       %>
	</table>

</body>
</html>