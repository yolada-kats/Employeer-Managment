package gr.aueb.elearn.teacherapp.model;


/**
 * Employee POJO / Java Bean class.
 */
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String position;
	private String department;

	public Employee() {}

	public Employee(int employeeId, String firstName, String lastName, String position, String department) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return employeeId + "\t" + firstName + "\t" + lastName + "\t" + position + "\t" + department;
	}
}

