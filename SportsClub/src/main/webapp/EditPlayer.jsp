<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,dao.AdminDAO,modal.Playermodal"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




<%	
String uname=request.getParameter("u");
AdminDAO  ad=new AdminDAO();
Playermodal p=ad.Playeredit(uname);
%>

<div class="container-fluid con">
		<div class="row mb-3">
			<div class="col-4"></div>
			<div class="col-4 cen bg-info bor">Edit Page</div>
			<div class="col-4"></div>
		</div>
		<form action="PlayerEditController" method="post">
		<div class="row mb-2">
				<div class="col-4"></div>
				<div class="col-4">
				<input type="text" value="<%= p.getUsername() %>" readonly>
<input type="hidden" name="username" value="<%= p.getUsername() %>">
				
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row mb-2">
				<div class="col-4"></div>
				<div class="col-4">
					<input type="text" name="fullname" id="fullname" value="<%= p.getFullname() %>">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row mb-2">
				<div class="col-4"></div>
				<div class="col-4">
				<input type="password" name="password" id="password"
						value="<%=p.getPassword()%>">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row mb-2">
				<div class="col-4"></div>
				<div class="col-4">
			<input type="text" name="email" id="email" value="<%=p.getEmail()%>">
				
					
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row mb-2">
				<div class="col-4"></div>
				<div class="col-4">
					<input type="text" name="phone" id="phone"
					value="<%=p.getPhone() %>">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row mt-3">
				<div class="col-4"></div>
				<div class="col-4 text-center">
					<button class="btn btn-success" type="submit">Submit</button>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row mt-3">
				<div class="col-4"></div>
				<div class="col-4 text-center">
					<label>Existing Student-click on</label><a href="AdminLogin">AdminPlayerDashboard.jsp</a>
				</div>
				<div class="col-4"></div>
			</div>
		</form>
	</div>



</body>
</html>