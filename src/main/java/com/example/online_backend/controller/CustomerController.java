package com.example.online_backend.controller;

import com.example.online_backend.model.CustomerTable;
import com.example.online_backend.repository.CustRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class
CustomerController {

    @Autowired
    private CustRepo custRepo;

    @GetMapping({"/showCustomer", "/", "/list"})
    public ModelAndView showCustomer(){
        ModelAndView mav = new ModelAndView("list-employee");
        List<CustomerTable> customerTableList = custRepo.findAll();
        mav.addObject("customers",customerTableList);
        return  mav;
    }

    @GetMapping("/add-customer")
    public ModelAndView addCustomer(){
        ModelAndView mav = new ModelAndView("add-customer");
        CustomerTable customerTable = new CustomerTable();
        mav.addObject("cust",customerTable);
        return  mav;
    }

    @PostMapping("/saveCustomer")
    public  String saveCustomer(@ModelAttribute CustomerTable customerTable){
        custRepo.save(customerTable);
        return "redirect:/list";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int custID){
        custRepo.deleteById(custID);
        return "redirect:/list";
    }

    @GetMapping("/update")
    public ModelAndView updateCustomer(@RequestParam int custID){
        ModelAndView mav = new ModelAndView("update-customer");
        CustomerTable customerTable = custRepo.findById(custID).get();
        mav.addObject("custo",customerTable);
        return mav;
    }



}
