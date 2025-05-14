package gr.aueb.elearn.teacherapp.dao.fake;

import gr.aueb.elearn.teacherapp.dao.IEmployeeDAO;
import gr.aueb.elearn.teacherapp.model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FakeEmployeeDAO implements IEmployeeDAO {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void insert(Employee employee) throws SQLException {
        employees.add(employee);
    }

    @Override
    public void update(Employee oldEmployee, Employee newEmployee) throws SQLException {
        delete(oldEmployee);
        insert(newEmployee);
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        employees.removeIf(e -> e.getEmployeeId() == employee.getEmployeeId());
    }

    @Override
    public List<Employee> getEmployeesByLastName(String lastName) throws SQLException {
        return employees.stream()
                .filter(e -> e.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        return employees.stream()
                .filter(e -> e.getEmployeeId() == id)
                .findFirst()
                .orElse(null);
    }

   
}

