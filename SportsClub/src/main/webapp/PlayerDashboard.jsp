<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String username = (String) session.getAttribute("un");
%>

<h2>Welcome, <%= username %></h2>

<a href="MySports.jsp">My Sports</a>
<a href="MyAttendance.jsp">My Attendance</a>
<a href="MyPerformance.jsp">My Performance</a>
<a href="MyFees.jsp">My Fees</a>
<a href="Logout.jsp">Logout</a>
<a href="PlayerProfile.jsp"><button  >Profile</button></a>


</body>
</html>






