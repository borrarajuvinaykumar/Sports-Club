package controller;

import java.io.IOException;

import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/MatchesDeleteController")
public class MatchesDeleteController extends HttpServlet {
	//private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	          int matchid=Integer.parseInt(request.getParameter("m"));	
	          AdminDAO md=new AdminDAO();
	          boolean status=md.deleteMatches(matchid);
	          System.out.println(status);
	          if(status==true) {
	        	  response.sendRedirect("AdminMatchDashboard.jsp");
	          } else {
	        	  response.sendRedirect("AdminMatchDashboard.jsp");
	          }
	          
	}

	

}