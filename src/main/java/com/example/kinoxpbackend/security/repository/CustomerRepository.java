package com.example.kinoxpbackend.security.repository;

import com.example.kinoxpbackend.security.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String>{
    Boolean existsByEmail(String email);
}
