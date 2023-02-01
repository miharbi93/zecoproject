package com.example.online_backend.controller;

import com.example.online_backend.model.Customer;
import com.example.online_backend.model.Employee;
import com.example.online_backend.repository.CustomerRepo;
import com.example.online_backend.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerAPI {

    @Autowired
    public CustomerRepo customerRepo;

    @GetMapping("/customers")
    public ResponseEntity<?> getAllcus(){
        try{
            List<Customer> customers = customerRepo.findAll();
            return new ResponseEntity<>(customers, HttpStatus.ACCEPTED);
        }catch (Exception exception){
            return  new ResponseEntity<>("No Data Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        try {
            Customer customer1 = customerRepo.save(customer);
            return new ResponseEntity<>(customer1, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Opps Error Found You Cant Add",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/customer{custID}")
    public  ResponseEntity<?> getByID(@PathVariable int custID){
        Optional<Customer> customer = customerRepo.findById(custID);

        try {
            if(customer.isPresent()){
                return  new ResponseEntity<>(customer,HttpStatus.OK);
            }else{
                return  new ResponseEntity<>("No Data Found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("Sorry something wrong",HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete{custID}")
    public  ResponseEntity<?> delete(@PathVariable int custID){
        try {
            customerRepo.deleteById(custID);
            return  new ResponseEntity<>("Deleted Successfull",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("Opps something went wrong",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update{custID}")
    public  ResponseEntity<?> update(@PathVariable int custID, @RequestBody Customer customer){
        try {
            if(customerRepo.findById(custID).isPresent()){
                customer.setCustID(custID);
                Customer customer1 = customerRepo.save(customer);
                return  new ResponseEntity<>(customer1,HttpStatus.OK);
            }else{
                return  new ResponseEntity<>("Sorry You Cant Update",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("Sorry something wrong",HttpStatus.CONFLICT);
        }
    }


}
