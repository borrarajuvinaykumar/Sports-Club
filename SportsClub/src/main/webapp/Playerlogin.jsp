<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<style>
    body {
        /* Basketball sports background */


background-image: url("https://images.unsplash.com/photo-1517649709446-2f9b0a3a6c0d");

        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        height: 100vh;
        margin: 0;
    }

    /* Dark overlay for readability */
    body::before {
        content: "";
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.6);
        z-index: -1;
    }

    .login-card {
        max-width: 400px;
        margin: auto;
        margin-top: 120px;
        padding: 30px;
        border-radius: 15px;
        background-color: #ffffff;
        box-shadow: 0px 10px 30px rgba(0,0,0,0.4);
    }

    .login-card h1 {
        text-align: center;
        margin-bottom: 20px;
        font-size: 26px;
        color: #222;
        font-weight: bold;
    }

    .btn-login {
        width: 100%;
        font-weight: bold;
    }
</style>
</head>

<body>

<div class="container">
    <div class="login-card">
        <h1>🏀 Player Login</h1>

        <form action="Playerlogincontroller" method="post">
            <div class="mb-3">
                <label class="form-label">Username</label>
                <input type="text" name="username" class="form-control" placeholder="Enter username" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" name="password" class="form-control" placeholder="Enter password" required>
            </div>

            <button type="submit" class="btn btn-primary btn-login">
                Login
            </button>
        </form>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
