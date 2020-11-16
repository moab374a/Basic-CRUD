package hibernatecrud.demo.DAO;

import hibernatecrud.demo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //define field for entitymanger
    private EntityManager entityManager;

    // set up constractor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager)
    {
        this.entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        //get the current Hibernate

        Session currentSession = entityManager.unwrap(Session.class);

        // creat a query (we are using Hibernate API for this work)

        Query<Employee> theQuery = currentSession.createQuery("from Employee " , Employee.class);

        //excute query and get result list

        List<Employee> employees = theQuery.getResultList();

        //return the result

        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // get the employee
        Employee theEmployee = currentSession.get(Employee.class , theId );

        //return the employee
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete object wiht primary key
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");

        theQuery.setParameter("employeeId" , theId);

        theQuery.executeUpdate();
    }
}
