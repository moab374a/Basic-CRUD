package hibernatecrud.demo.RestContoller;


import hibernatecrud.demo.Service.EmployeeService;
import hibernatecrud.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // add mapping for get /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null) throw new RuntimeException("Employee not Exsist");

        return theEmployee;
    }

    // Add mapping for Post /employees - add new employee

    @PostMapping("/employees/")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        //also just in case they pass an id in Json ... set id to 0
        // this is to force a save of new item instead of update

        theEmployee.setId(0);
        employeeService.save(theEmployee);

        return theEmployee;
    }



}
