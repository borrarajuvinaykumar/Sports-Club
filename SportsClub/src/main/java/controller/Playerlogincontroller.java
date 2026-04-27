package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import dao.Playerdao;
import modal.Playermodal;

@WebServlet("/Playerlogincontroller")
public class Playerlogincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname=request.getParameter("username");
		String password=request.getParameter("password");

		
		Playermodal pm=new Playermodal();
	

		pm.setUsername(uname);
		pm.setPassword(password);	
		Playerdao pd=new Playerdao();
		String status=pd.Login(pm);
		if(status.equals("success")) {
         
			HttpSession session = request.getSession();
			session.setAttribute("un", uname);
			RequestDispatcher rd = request.getRequestDispatcher("PlayerDashboard.jsp");
			rd.forward(request, response);	
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("Playerlogin.jsp");
			rd.forward(request, response);
		}
	}
}
