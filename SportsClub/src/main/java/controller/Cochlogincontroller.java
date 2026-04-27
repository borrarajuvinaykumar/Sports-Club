package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.Cochmodal;

import java.io.IOException;

import dao.Cochdao;

@WebServlet("/Cochlogincontroller")
public class Cochlogincontroller extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cochmodal m=new Cochmodal();
		String coch=request.getParameter("username");
		m.setUsername(request.getParameter("username"));
		m.setPassword(request.getParameter("password"))
		;
		
		Cochdao cd=new Cochdao();
		boolean status=cd.Validate(m);
		System.out.println(status);
		if(status) {
			HttpSession session =request.getSession();
			session.setAttribute("coch", coch);
			 RequestDispatcher rd = request.getRequestDispatcher("CochDash.jsp");
			    rd.forward(request, response);
		}
		else {
			 RequestDispatcher rd = request.getRequestDispatcher("Cochlogin.jsp");
			    rd.forward(request, response);
		}
	}

}