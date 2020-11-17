package SpringDataRest.Dao;

import SpringDataRest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

    // that's it no need for implementation.
}
