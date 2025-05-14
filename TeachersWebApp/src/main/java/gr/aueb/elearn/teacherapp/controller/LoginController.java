package gr.aueb.elearn.teacherapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String eMail = request.getParameter("eMail");
		String password = request.getParameter("password");
		
		if (eMail.equals("giolkatsarou@gmail.com") && (password.contentEquals("123"))) {
			// redirect to search page
			request.getRequestDispatcher("/jsps/employeemenu.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Login Error");
			request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
		}
				
	}

}
