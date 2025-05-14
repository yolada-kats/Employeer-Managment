package gr.aueb.elearn.teacherapp.service;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gr.aueb.elearn.teacherapp.dao.fake.FakeEmployeeDAO;
import gr.aueb.elearn.teacherapp.dto.EmployeeDTO;
import gr.aueb.elearn.teacherapp.model.Employee;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeServiceTest {

    private IEmployeeService service;

    @BeforeEach
    public void setUp() {
        service = new EmployeeServiceImpl(new FakeEmployeeDAO());
    }

    @Test
    public void testInsertEmployee() throws Exception {
        EmployeeDTO emp = new EmployeeDTO(1, "Maria", "Kosta", "Analyst", "Finance");
        service.insertEmployee(emp);

        List<Employee> results = service.getEmployeesByLastName("Kosta");
        assertEquals(1, results.size());
        assertEquals("Maria", results.get(0).getFirstName());
    }
    
    @Test
    public void testUpdateEmployee() throws Exception {
        // 1. ������ �������� ���������
        EmployeeDTO originalEmp = new EmployeeDTO(2, "Nikos", "Papadopoulos", "Analyst", "Finance");
        service.insertEmployee(originalEmp);

        // 2. ���������� ���� ��������� ��� ��� ���� ��������
        EmployeeDTO updatedEmp = new EmployeeDTO(2, "Nikos", "Papadopoulos", "Senior Analyst", "Finance");

        // 3. ����� update
        service.updateEmployee(originalEmp, updatedEmp);

        // 4. �������� ��������� ��� �������
        List<Employee> results = service.getEmployeesByLastName("Papadopoulos");

        assertEquals(1, results.size());
        assertEquals("Senior Analyst", results.get(0).getPosition());
    }

}

