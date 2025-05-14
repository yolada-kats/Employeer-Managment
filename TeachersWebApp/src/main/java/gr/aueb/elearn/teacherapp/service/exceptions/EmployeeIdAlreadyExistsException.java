package gr.aueb.elearn.teacherapp.service.exceptions;
import gr.aueb.elearn.teacherapp.model.Employee;

public class EmployeeIdAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeIdAlreadyExistsException(Employee employee) {
		super("Employee with id = " + employee.getEmployeeId() + " already exists");
	}
}