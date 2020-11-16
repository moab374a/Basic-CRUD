package hibernatecrud.demo.Service;
import hibernatecrud.demo.Dao.EmployeeRepository;
import hibernatecrud.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl( EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }


    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Employee> findById(int theId) {
        return employeeRepository.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
