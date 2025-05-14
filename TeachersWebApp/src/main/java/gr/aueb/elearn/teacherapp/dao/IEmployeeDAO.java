package gr.aueb.elearn.teacherapp.dao;

import java.sql.SQLException;
import java.util.List;
import gr.aueb.elearn.teacherapp.model.Employee;

public interface IEmployeeDAO {
	void insert(Employee employee) throws SQLException;
	void delete(Employee employee) throws SQLException;
	void update(Employee oldEmployee, Employee newEmployee) throws SQLException;
	List<Employee> getEmployeesByLastName(String lastName) throws SQLException;
	Employee getEmployeeById(int id) throws SQLException;
}
