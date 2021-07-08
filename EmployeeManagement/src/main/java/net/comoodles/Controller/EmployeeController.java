package net.comoodles.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.comoodles.Model.Employee;
import net.comoodles.Repository.EmployeeRepository;

import java.util.List;


@RestController
@RequestMapping
("/Employee")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public String saveEmployee(@RequestBody Employee e) {
         employeeRepository.insert(e);
          return "Added Employee id " + e.getId();
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees;
    
    }
   
    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee e) {
          employeeRepository.save(e);
          return "Updated Employee for id " + e.getId();
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteByEmpId(@PathVariable("id") Employee id){
        this.employeeRepository.delete(id);
       
    }
}
