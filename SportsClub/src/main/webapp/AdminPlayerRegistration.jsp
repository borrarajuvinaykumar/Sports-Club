<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*, dao.AdminDAO,modal.Playermodal" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="container mt-5">
<div class="row justify-content-center">
<div class="col-md-6">

<div class="card shadow">
<div class="card-header bg-primary text-white">
<h4>Register</h4>
</div>

<div class="card-body">

<form action="AdminPlayerRegistration" method="post">

<!-- Hidden username -->
<div class="mb-3">
<label class="form-label">	Username</label>
<input type="text" name="username" placeholder="Username">
</div>


<div class="mb-3">
<label class="form-label">Email</label>
<input type="text" class="form-control" name="email" placeholder="Email">
</div>

<div class="mb-3">
<label class="form-label">Full Name</label>
<input type="text" class="form-control" name="fullname" placeholder="FullName">
</div>

<div class="mb-3">
<label class="form-label">Password</label>
<input type="text" class="form-control" name="password" placeholder="Password">
</div>

<div class="mb-3">
<label class="form-label">Phone</label>
<input type="text" class="form-control" name="phone" placeholder="Phone">
</div>

<div class="text-center">
<button type="submit" class="btn btn-success">Register</button>

</div>

</form>

</div>
</div>

</div>
</div>
</div>

</body>


</html>