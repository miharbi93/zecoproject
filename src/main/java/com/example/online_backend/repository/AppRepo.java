package com.example.online_backend.repository;

import com.example.online_backend.model.CustomerApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepo extends JpaRepository<CustomerApplication, Integer> {
}
