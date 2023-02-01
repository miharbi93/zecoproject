package com.example.online_backend.repository;

import com.example.online_backend.model.CustomerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustRepo extends JpaRepository<CustomerTable, Integer> {
}
