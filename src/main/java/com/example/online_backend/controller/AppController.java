package com.example.online_backend.controller;

import com.example.online_backend.model.CustomerApplication;
import com.example.online_backend.repository.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private AppRepo appRepo;

    @GetMapping("/add-application")
    public ModelAndView addapplication(){
        ModelAndView ibra = new ModelAndView("add-application");
        CustomerApplication application = new CustomerApplication();
        ibra.addObject("app",application);
        return ibra;
    }

    @PostMapping("/saveApplication")
    public  String saveApplication(@ModelAttribute CustomerApplication customerApplication){
        appRepo.save(customerApplication);
        return "redirect:/showapplication";
    }

    @GetMapping("/showapplication")
    public ModelAndView showapplication(){
        ModelAndView arafa = new ModelAndView("view-application");
        List<CustomerApplication> customerApplications = appRepo.findAll();
        arafa.addObject("views",customerApplications);
        return arafa;
    }

    @GetMapping("/updateApp")
    public  ModelAndView updateApp(@RequestParam int appID){
        ModelAndView modelAndView = new ModelAndView("update-application");
        CustomerApplication customerApplication = appRepo.findById(appID).get();
        modelAndView.addObject("update",customerApplication);
        return modelAndView;
    }

    @GetMapping("/deleteApp")
    public String deleteApp(@RequestParam int appID){
        appRepo.deleteById(appID);
        return "redirect:/showapplication";
    }
}
