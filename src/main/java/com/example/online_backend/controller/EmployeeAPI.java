package com.example.online_backend.controller;

import com.example.online_backend.model.Employee;
import com.example.online_backend.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
@RestController
@RequestMapping("/Employee")
public class EmployeeAPI {
    @Autowired
    public EmployeeRepo employeeRepo;

    @GetMapping("/Employees")
    public ResponseEntity<?> getEmployees(){
        try {
            List<Employee> employees = employeeRepo.findAll();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Opps no data found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Id/{empId}")
    public ResponseEntity<?> getEmployeeByID(@PathVariable int empId){
        Optional<Employee> employee = employeeRepo.findById(empId);

        try {
            if (employee.isPresent()){
                return new ResponseEntity<>(employee,HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No data Found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex){
            return new ResponseEntity<>("Something Wrong",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/Delete/{empId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int empId){
        try {
            employeeRepo.deleteById(empId);
            return new ResponseEntity<>("Deleted Successfull",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Opps something Wrong",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        try {
            Employee employee1 = employeeRepo.save(employee);
            return new ResponseEntity<>(employee1,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Opps Data Already Saved",HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<?> updateEmployee(@PathVariable int empId,@RequestBody Employee employee){
        try {
            if (employeeRepo.findById(empId).isPresent()){
                employee.setEmpId(empId);
                Employee employee1 = employeeRepo.save(employee);
                return new ResponseEntity<>(employee1,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Data Does Not Exits",HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex){
            return new ResponseEntity<>("Something went wrong",HttpStatus.CONFLICT);
        }
    }


}
