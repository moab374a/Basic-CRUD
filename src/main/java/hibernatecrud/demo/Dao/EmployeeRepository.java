package hibernatecrud.demo.Dao;

import hibernatecrud.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee , Integer> {

    // that's it no need for implementation.
}
