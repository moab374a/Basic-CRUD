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
    @Transactional // handel transaction management
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
}
