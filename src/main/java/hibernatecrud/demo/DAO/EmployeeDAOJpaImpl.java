package hibernatecrud.demo.DAO;

import hibernatecrud.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // creat a Queary
        Query theQuery = entityManager.createQuery("from Employee");

        //excute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee theEmployee = entityManager.find(Employee.class , theId);

        //return employee

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        // save or Update the employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // update with id from db.. we can get genrated id for save/insert
        theEmployee.setId(dbEmployee.getId());

    }

    @Override
    public void deleteById(int theId) {

        //delete object with primary Key
        Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");

        theQuery.setParameter("employeeId" , theId);

        theQuery.executeUpdate();

    }
}
