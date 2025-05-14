package gr.aueb.elearn.teacherapp.dao;

import static gr.aueb.elearn.teacherapp.dao.dbutil.DBUtil.openConnection;
import static gr.aueb.elearn.teacherapp.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.elearn.teacherapp.dao.dbutil.DBUtil.closeRS;
import static gr.aueb.elearn.teacherapp.dao.dbutil.DBUtil.closeStmt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import gr.aueb.elearn.teacherapp.dao.dbutil.DBUtil;
import gr.aueb.elearn.teacherapp.model.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {

    @Override
    public void insert(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, employee.getEmployeeId());
            pst.setString(2, employee.getFirstName());
            pst.setString(3, employee.getLastName());
            pst.setString(4, employee.getPosition());
            pst.setString(5, employee.getDepartment());

            int n = pst.executeUpdate();

            JOptionPane.showMessageDialog(null, n + " Record inserted.", "INSERT", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        try (Connection conn = openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, employee.getEmployeeId());

            int dialogButton = JOptionPane.showConfirmDialog(null, "Είστε σίγουρος;", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {
                int rows = pst.executeUpdate();
                JOptionPane.showMessageDialog(null, rows + " rows deleted successfully", "DELETE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void update(Employee oldEmp, Employee newEmp) throws SQLException {
        String sql = "UPDATE employees SET f_name = ?, l_name = ?, position = ?, department = ? WHERE employee_id = ?";

        try (Connection conn = openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, newEmp.getFirstName());
            pst.setString(2, newEmp.getLastName());
            pst.setString(3, newEmp.getPosition());
            pst.setString(4, newEmp.getDepartment());
            pst.setInt(5, oldEmp.getEmployeeId());

            int rows = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, rows + " rows affected", "UPDATE", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public List<Employee> getEmployeesByLastName(String lastName) throws SQLException {
        String sql = "SELECT * FROM employees WHERE l_name LIKE ?";
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, lastName + "%");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setEmployeeId(rs.getInt("employee_id"));
                    emp.setFirstName(rs.getString("f_name"));
                    emp.setLastName(rs.getString("l_name"));
                    emp.setPosition(rs.getString("position"));
                    emp.setDepartment(rs.getString("department"));
                    employees.add(emp);
                }
            }
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE employee_id = ?";
        Employee emp = null;

        try (Connection conn = openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    emp = new Employee();
                    emp.setEmployeeId(rs.getInt("employee_id"));
                    emp.setFirstName(rs.getString("f_name"));
                    emp.setLastName(rs.getString("l_name"));
                    emp.setPosition(rs.getString("position"));
                    emp.setDepartment(rs.getString("department"));
                }
            }
        }

        return emp;
    }


}

