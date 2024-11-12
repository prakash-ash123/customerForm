package com.customerForm.webCustoerForm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.customerForm.webCustoerForm.CustomerService;
import com.customerForm.webCustoerForm.model.Customer;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;
    
    @PostMapping("/submit")
    public ResponseEntity<String> handleCustomerForm(@RequestBody Customer customer) {
        // Log or save customer data
    	service.saveCustomer(customer);
        System.out.println("Received customer data: " + customer);

        // Simulate saving to the database or processing
        return ResponseEntity.ok("Customer submitted successfully!");
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "form";
    }

    //@PostMapping("/submit")
   // public String submitForm(@ModelAttribute Customer customer) {
       // service.saveCustomer(customer);
       // return "redirect:/list";
   // }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customers", service.getAllCustomers());
        return "list";
    }
}
