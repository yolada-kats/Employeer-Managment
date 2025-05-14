package gr.aueb.elearn.teacherapp.controller;

import gr.aueb.elearn.teacherapp.dao.IEmployeeDAO;
import gr.aueb.elearn.teacherapp.dao.EmployeeDAOImpl;
import gr.aueb.elearn.teacherapp.dto.EmployeeDTO;
import gr.aueb.elearn.teacherapp.model.Employee;
import gr.aueb.elearn.teacherapp.service.EmployeeServiceImpl;
import gr.aueb.elearn.teacherapp.service.IEmployeeService;
import gr.aueb.elearn.teacherapp.service.exceptions.EmployeeNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class EmployeeUpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
        IEmployeeService employeeService = new EmployeeServiceImpl(employeeDAO);

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String position = request.getParameter("position");
            String department = request.getParameter("department");

            EmployeeDTO oldEmpDTO = new EmployeeDTO();
            oldEmpDTO.setEmployeeId(id);

            EmployeeDTO newEmpDTO = new EmployeeDTO(id, firstName, lastName, position, department);

            employeeService.updateEmployee(oldEmpDTO, newEmpDTO);

            request.setAttribute("updatedEmployee", newEmpDTO);
            request.getRequestDispatcher("/jsps/employeeupdated.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (EmployeeNotFoundException e) {
            response.getWriter().write("<h2 style='color:red;'>Employee not found.</h2>");
            request.getRequestDispatcher("/jsps/employeemenu.jsp").include(request, response);
        }
    }
}

