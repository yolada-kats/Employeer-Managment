package gr.aueb.elearn.teacherapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.elearn.teacherapp.dao.IEmployeeDAO;
import gr.aueb.elearn.teacherapp.dao.EmployeeDAOImpl;
//import gr.aueb.elearn.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.teacherapp.model.Employee;
import gr.aueb.elearn.teacherapp.service.IEmployeeService;
import gr.aueb.elearn.teacherapp.service.EmployeeServiceImpl;

/**
 * Servlet implementation class TeacherSearchController
 */
public class EmployeeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		IEmployeeService employeeService = new EmployeeServiceImpl(employeeDAO);
		List<Employee> employees = new ArrayList<>();

		response.setContentType("text/html;charset=UTF-8");

		// ΠΡΟΣΟΧΗ: Αυτό πρέπει να ταιριάζει με το "name" του input
		String lastName = request.getParameter("lastName");

		// Αν δεν δώθηκε καθόλου επώνυμο
		if (lastName == null || lastName.trim().isEmpty()) {
			request.setAttribute("error", "Please enter a last name.");
			request.getRequestDispatcher("/jsps/employeemenu.jsp").forward(request, response);
			return;
		}

		try {
			employees = employeeService.getEmployeesByLastName(lastName.trim());
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("<h1 style='color:red;'>Database error</h1>");
			return;
		}

		if (employees != null && !employees.isEmpty()) {
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("/jsps/employees.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "No employees found.");
			request.getRequestDispatcher("/jsps/employeemenu.jsp").forward(request, response);
		}
	}
}
