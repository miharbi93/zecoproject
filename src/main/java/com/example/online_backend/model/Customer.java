package com.example.online_backend.model;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int custID;
    private  String custName;
    private  String custLocation;
    private  String custEmail;
    private  String custPhone;
    private  String custMenu;
    private  String custPay;
}
