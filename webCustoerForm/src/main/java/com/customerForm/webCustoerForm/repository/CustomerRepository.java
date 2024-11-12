package com.customerForm.webCustoerForm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.customerForm.webCustoerForm.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
