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


@WebServlet("/PlayerEditController")
public class PlayerEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Playermodal m=new Playermodal();
		
		m.setUsername(request.getParameter("username"));
		m.setFullname(request.getParameter("fullname"));
		m.setPassword(request.getParameter("password"));
		m.setEmail(request.getParameter("email"));
		m.setPhone(request.getParameter("phone"));
		
		AdminDAO ad=new AdminDAO();
		String status=ad.Playerupdate(m);
		System.out.println(status);
		if(status.equals("success")) {
			response.sendRedirect("AdminPlayerDashboard.jsp");
		}else {
			response.sendRedirect("AdminPlayerDashboard.jsp");
		}
		
	}

}
