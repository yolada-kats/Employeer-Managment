package gr.aueb.elearn.teacherapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.elearn.teacherapp.dao.IEmployeeDAO;
import gr.aueb.elearn.teacherapp.dto.EmployeeDTO;
import gr.aueb.elearn.teacherapp.model.Employee;
import gr.aueb.elearn.teacherapp.service.exceptions.EmployeeIdAlreadyExistsException;
import gr.aueb.elearn.teacherapp.service.exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements IEmployeeService {

	private final IEmployeeDAO employeeDAO;

	public EmployeeServiceImpl(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void insertEmployee(EmployeeDTO employeeDTO) 
			throws EmployeeIdAlreadyExistsException, SQLException {

		Employee newEmployee = new Employee();
		newEmployee.setEmployeeId(employeeDTO.getEmployeeId());
		newEmployee.setFirstName(employeeDTO.getFirstName());
		newEmployee.setLastName(employeeDTO.getLastName());
		newEmployee.setPosition(employeeDTO.getPosition());
		newEmployee.setDepartment(employeeDTO.getDepartment());

		if (employeeDAO.getEmployeeById(newEmployee.getEmployeeId()) == null) {
			employeeDAO.insert(newEmployee);
		} else {
			throw new EmployeeIdAlreadyExistsException(newEmployee);
		}
	}

	@Override
	public void deleteEmployee(EmployeeDTO employeeDTO) 
			throws EmployeeNotFoundException, SQLException {

		Employee employeeToDelete = new Employee();
		employeeToDelete.setEmployeeId(employeeDTO.getEmployeeId());

		if (employeeDAO.getEmployeeById(employeeToDelete.getEmployeeId()) == null) {
			throw new EmployeeNotFoundException(employeeToDelete);
		}

		employeeDAO.delete(employeeToDelete);
	}

	@Override
	public void updateEmployee(EmployeeDTO oldEmployeeDTO, EmployeeDTO newEmployeeDTO)
			throws EmployeeNotFoundException, SQLException {

		Employee oldEmployee = new Employee();
		oldEmployee.setEmployeeId(oldEmployeeDTO.getEmployeeId());

		Employee newEmployee = new Employee();
		newEmployee.setFirstName(newEmployeeDTO.getFirstName());
		newEmployee.setLastName(newEmployeeDTO.getLastName());
		newEmployee.setPosition(newEmployeeDTO.getPosition());
		newEmployee.setDepartment(newEmployeeDTO.getDepartment());

		if (employeeDAO.getEmployeeById(oldEmployee.getEmployeeId()) == null) {
			throw new EmployeeNotFoundException(oldEmployee);
		}

		employeeDAO.update(oldEmployee, newEmployee);
	}

	@Override
	public List<Employee> getEmployeesByLastName(String lastName) throws SQLException {
		return employeeDAO.getEmployeesByLastName(lastName);
	}
}

