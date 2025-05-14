package gr.aueb.elearn.teacherapp.service;
import java.sql.SQLException;
import java.util.List;

import gr.aueb.elearn.teacherapp.dto.EmployeeDTO;
import gr.aueb.elearn.teacherapp.model.Employee;
import gr.aueb.elearn.teacherapp.service.exceptions.EmployeeIdAlreadyExistsException;
import gr.aueb.elearn.teacherapp.service.exceptions.EmployeeNotFoundException;

public interface IEmployeeService {

    /**
     * Inserts an {@link Employee} based on the data carried by the
     * {@link EmployeeDTO}.
     *
     * @param employeeDTO 
     *        DTO object that contains the data.
     * @throws EmployeeIdAlreadyExistsException
     *         if an Employee with the same ID already exists.
     * @throws SQLException
     *         if a database access error occurs.
     */
    void insertEmployee(EmployeeDTO employeeDTO) 
            throws EmployeeIdAlreadyExistsException, SQLException;

    /**
     * Deletes an {@link Employee} based on the data carried by the
     * {@link EmployeeDTO}.
     *
     * @param employeeDTO 
     *        DTO object that contains the ID of the employee to be deleted.
     * @throws EmployeeNotFoundException
     *         if the employee is not found.
     * @throws SQLException
     *         if a database access error occurs.
     */
    void deleteEmployee(EmployeeDTO employeeDTO) 
            throws EmployeeNotFoundException, SQLException;

    /**
     * Updates an {@link Employee} based on the data carried by the
     * {@link EmployeeDTO}.
     *
     * @param oldEmployeeDTO
     *        DTO with the ID of the existing employee.
     * @param newEmployeeDTO
     *        DTO with the new employee data.
     * @throws EmployeeNotFoundException
     *         if the employee is not found.
     * @throws SQLException
     *         if a database access error occurs.
     */
    void updateEmployee(EmployeeDTO oldEmployeeDTO, EmployeeDTO newEmployeeDTO) 
            throws EmployeeNotFoundException, SQLException;

    /**
     * Searches and returns a list of {@link Employee} objects filtered
     * by last name (surname).
     *
     * @param surname
     *        The last name or its starting letters.
     * @return List of matching employees.
     * @throws SQLException
     *         if a database access error occurs.
     */
    List<Employee> getEmployeesByLastName(String surname) 
            throws SQLException;
}

