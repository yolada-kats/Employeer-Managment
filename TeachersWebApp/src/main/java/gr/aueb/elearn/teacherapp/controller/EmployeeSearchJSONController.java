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

import com.google.gson.Gson;

import gr.aueb.elearn.teacherapp.dao.IEmployeeDAO;
import gr.aueb.elearn.teacherapp.dao.EmployeeDAOImpl;
import gr.aueb.elearn.teacherapp.model.Employee;
import gr.aueb.elearn.teacherapp.service.IEmployeeService;
import gr.aueb.elearn.teacherapp.service.EmployeeServiceImpl;

/**
 * Servlet implementation class TeacherSearchController
 */
@WebServlet("/TeacherSearchJSONController")
public class EmployeeSearchJSONController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		IEmployeeService employeeServ = new EmployeeServiceImpl(employeeDAO);
		List<Employee> employees = new ArrayList<>();
		
		Gson gson = new Gson();
		String gsonResponse;

		response.setContentType("application/json; charset=UTF-8");
		String lastName = request.getParameter("searchInput");
		
		try {
			employees = employeeServ.getEmployeesByLastName(lastName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (employees != null && !employees.isEmpty()) {
			gsonResponse = gson.toJson(employees);
			response.getWriter().write(gsonResponse);
			System.out.println(gsonResponse);
		} else {
			response.getWriter().write("[]");
		}
	}
}
