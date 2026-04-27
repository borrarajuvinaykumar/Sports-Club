package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.Playermodal;

import java.io.IOException;

import dao.AdminDAO;


@WebServlet("/AdminPlayerRegistration")
public class AdminPlayerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String fullname=request.getParameter("fullname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		Playermodal pm=new Playermodal();
		pm.setUsername(username);
		pm.setFullname(fullname);
		pm.setPassword(password);
		pm.setEmail(email);
		pm.setPhone(phone);
		
		AdminDAO ad=new AdminDAO();
		String status=ad.Playerinsert(pm);
		
		if(status.equals("success")) {
			System.out.println("insertion success");
			RequestDispatcher rd= request.getRequestDispatcher("AdminPlayerDashboard.jsp");
			rd.forward(request, response);
		}else {
			System.out.println("something went wrong");
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
