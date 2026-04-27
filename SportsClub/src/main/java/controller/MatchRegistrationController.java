package controller;

import java.io.IOException;

import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.MatchesModal;

@WebServlet("/MatchRegistrationController")
public class MatchRegistrationController extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MatchesModal mm = new MatchesModal();
//		mm.setMatchid(Integer.parseInt(request.getParameter("matchid")));
		mm.setSportname(request.getParameter("sportname"));
		mm.setTeam1(request.getParameter("team1"));
		mm.setTeam2(request.getParameter("team2"));
		mm.setMatchdate(request.getParameter("matchdate"));
		mm.setMatchtime(request.getParameter("matchtime"));
		mm.setVenue(request.getParameter("venue"));
		mm.setStatus(request.getParameter("status"));
		AdminDAO ad=new AdminDAO();
		boolean status=ad.registerMatches(mm);
		if(status==true) {
			response.sendRedirect("AdminMatchDashboard.jsp");
		} else {
			response.sendRedirect("AdminMatchDashboard.jsp");

		}
	}

}