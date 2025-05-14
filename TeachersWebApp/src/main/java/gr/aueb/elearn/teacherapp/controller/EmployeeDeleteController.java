package gr.aueb.elearn.teacherapp.controller;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.elearn.teacherapp.dao.IEmployeeDAO;
import gr.aueb.elearn.teacherapp.dao.EmployeeDAOImpl;
import gr.aueb.elearn.teacherapp.dto.EmployeeDTO;
//import gr.aueb.elearn.teacherapp.model.Teacher;
import gr.aueb.elearn.teacherapp.service.IEmployeeService;
import gr.aueb.elearn.teacherapp.service.EmployeeServiceImpl;
import gr.aueb.elearn.teacherapp.service.exceptions.EmployeeNotFoundException;

/**
 * Servlet implementation class TeacherDeleteController
 */
public class EmployeeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		IEmployeeService employeeServ = new EmployeeServiceImpl(employeeDAO);

		response.setContentType("text/html");
		Integer id = Integer.parseInt(request.getParameter("id"));
		employeeDTO.setEmployeeId(id);

		try {
			employeeServ.deleteEmployee(employeeDTO);
			request.setAttribute("deletedEmployeeId", id);
			request.getRequestDispatcher("/jsps/employeedeleted.jsp").forward(request, response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (EmployeeNotFoundException e2) {
			response.getWriter().write("<h1 style=\"color:red\">Employee does not exist</h1>");
			request.getRequestDispatcher("/jsps/employees.jsp").include(request, response);
		}
	}
}
