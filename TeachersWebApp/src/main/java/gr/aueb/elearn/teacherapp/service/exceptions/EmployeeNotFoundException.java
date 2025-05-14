package gr.aueb.elearn.teacherapp.service.exceptions;
import gr.aueb.elearn.teacherapp.model.Employee;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(Employee employee) {
		super("Employee with id = " + employee.getEmployeeId() + " does not exist");
	}
}
