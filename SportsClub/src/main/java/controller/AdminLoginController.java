package controller;

import java.io.IOException;

import dao.AdminDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.AdminModal;


@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	//private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminModal am=new AdminModal(); 
        boolean status=false;
        String admin=request.getParameter("username");
		am.setUsername(request.getParameter("username"));
		am.setPassword(request.getParameter("password"));
		AdminDAO ad=new AdminDAO();
		status=ad.Validate(am);
		if(status==true) {
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);
			RequestDispatcher rd=request.getRequestDispatcher("AdminDashBoard.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request, response);
		}
	}

}