package com.example.online_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int custID;
    private  String custName;
    private  String custLocation;
    private  String custEmail;
    private  String custPhone;
    private  String custStatus;
    private  String custYear;
}
