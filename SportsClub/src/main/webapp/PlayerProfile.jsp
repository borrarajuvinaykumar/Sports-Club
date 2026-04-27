<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page import="java.util.*,dao.Playerdao,modal.Playermodal" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome Player Profile</h1>

<%Playermodal p1= new Playermodal();
Playerdao pd=new Playerdao();
String uname=(String)session.getAttribute("un");
p1=pd.getPlayerByUserName(uname);
System.out.println("hello");
%>
<h1>Welcome to :<%=session.getAttribute("un") %></h1>
<form name="EditStudent" method="post"action="Playerlogincontroller">
<input type="text" name="fullname" value="<%=p1.getFullname() %>">
<input type="text" name="username" value="<%= p1.getUsername() %>" readonly>
<input type="text" name="password" value="<%=p1.getPassword() %>">
<input type="text" name="email" value="<%=p1.getEmail() %>">
<input type="text" name="phone" value="<%=p1.getPhone() %>">
<button class="Submit">SUBMIT</button>
</form>

</body>
</html>