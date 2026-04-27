package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.AdminDAO;

@WebServlet("/PlayerDeleteController")
public class PlayerDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("u");
		 AdminDAO ad=new  AdminDAO();
		 String status=ad.Playerdelete(username);
		 if(status.equals("success")) {
			 response.sendRedirect("AdminPlayerDashboard.jsp");
			 
		 }else {
			 response.sendRedirect("AdminPlayerDashboard.jsp");
		 }
	}
	    }
	




