package com.cpulover.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpulover.springdemo.entity.Customer;
import com.cpulover.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;

	// define endpoint for "/api/customers" - return list of customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	// define endpoint for "/api/customers/{id}" - return customer by id
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		return customer;
	}

	// add mapping for POST/customers - add new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		// set id to 0 to force a save of new entity, instead of update
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}

	// add mapping for POST/customers-multiple - add many new customers
	@PostMapping("/customers-multiple")
	public Customer[] addMultipleCustomers(@RequestBody Customer[] theCustomers) {

		for (Customer tempCustomer : theCustomers) {
			tempCustomer.setId(0);
			customerService.saveCustomer(tempCustomer);
		}
		return theCustomers;
	}

	// add mapping for POST/customers - update an existing customer
	// (include id in request body)
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}

	// add mapping for POST/customers/{id} - update an existing customer
	// (not include id in request body)
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
		Customer theCustomer = customerService.getCustomer(id);
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not exist - " + id);
		}
		theCustomer.setFirstName(customer.getFirstName());
		theCustomer.setLastName(customer.getLastName());
		theCustomer.setEmail(customer.getEmail());

		customerService.saveCustomer(theCustomer);
		return customer;
	}

	// add mapping for DELETE/customer/{id} - delete a customer
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		Customer theCustomer = customerService.getCustomer(id);
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not exist - " + id);
		}
		customerService.deleteCustomer(id);
		return "Customer deleted: " + id;
	}

}
