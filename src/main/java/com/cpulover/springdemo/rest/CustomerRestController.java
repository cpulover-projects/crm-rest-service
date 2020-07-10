package com.cpulover.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpulover.springdemo.entity.Customer;
import com.cpulover.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;
	
	//define endpoint for "/api/customers" - return list of customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	//define endpoint for "/api/customers/{id}" - return customer by id
		@GetMapping("/customers/{id}")
		public Customer getCustomer(@PathVariable int id){
			return customerService.getCustomer(id);
		}
}
