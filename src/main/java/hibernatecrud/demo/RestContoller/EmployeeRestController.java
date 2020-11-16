package hibernatecrud.demo.RestContoller;


import hibernatecrud.demo.Service.EmployeeService;
import hibernatecrud.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //quick solution ; inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        this.employeeService = theEmployeeService;
    }
    // expose "/employees" and return list of employees

    @GetMapping("/employees")
    public List<Employee> findALl()
    {
        return employeeService.findAll();
    }

}
