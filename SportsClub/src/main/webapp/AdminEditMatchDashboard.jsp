<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="dao.AdminDAO,modal.MatchesModal" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	     <%
	     MatchesModal mm=null;
	     AdminDAO ad=new AdminDAO();
	     mm=ad.getMatchByID(Integer.parseInt(request.getParameter("m")));
	     %>
	     <form name="MatchEditPage" method="post" action="EditMatchController">
	     <input type="text" name="matchid" id="matchid" value="<%= mm.getMatchid()%>">
	     <input type="text" name="sportname" id="sportname" value="<%= mm.getSportname() %>">
	     <input type="text" name="team1" id="team1" value="<%= mm.getTeam1() %>">
	     <input type="text" name="team2" id="team2" value="<%= mm.getTeam2()%>">
	     <input type="text" name="matchdate" id="matchddate" value="<%= mm.getMatchdate() %>">
	     <input type="text" name="matchtime" id="matchtime" value="<%= mm.getMatchtime() %>">
	     <input type="text" name="venue" id="venue" value="<%= mm.getVenue() %>">
         <input type="text" name="status" id="status" value="<%=mm.getStatus() %>">
         <button type ="submit">Submit</button>	     
	     </form>
	</body>
</html>