package hibernatecrud.demo.DAO;

import hibernatecrud.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

}
