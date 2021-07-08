package net.comoodles.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import net.comoodles.Model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

    
}