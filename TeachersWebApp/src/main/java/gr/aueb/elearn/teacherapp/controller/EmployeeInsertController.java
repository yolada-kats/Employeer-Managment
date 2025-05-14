package gr.aueb.elearn.teacherapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.elearn.teacherapp.dao.IEmployeeDAO;
import gr.aueb.elearn.teacherapp.dao.EmployeeDAOImpl;
import gr.aueb.elearn.teacherapp.dto.EmployeeDTO;
import gr.aueb.elearn.teacherapp.service.IEmployeeService;
import gr.aueb.elearn.teacherapp.service.EmployeeServiceImpl;
import gr.aueb.elearn.teacherapp.service.exceptions.EmployeeIdAlreadyExistsException;

/**
 * Servlet implementation class TeacherInsertController
 */
public class EmployeeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDTO employeeDTO;
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		IEmployeeService employeeServ = new EmployeeServiceImpl(employeeDAO);

		response.setContentType("text/html");

		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String position = request.getParameter("position");
			String department = request.getParameter("department");

			employeeDTO = new EmployeeDTO(id, firstName, lastName, position, department);
			employeeServ.insertEmployee(employeeDTO);

			request.setAttribute("insertedEmployee", employeeDTO);
			request.getRequestDispatcher("/jsps/employeeinserted.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (EmployeeIdAlreadyExistsException e) {
			response.getWriter().write("<h1 style=\"color:red\">Employee already exists</h1>");
			request.getRequestDispatcher("/jsps/employeeinsert.jsp").include(request, response);
		}
	}
}
