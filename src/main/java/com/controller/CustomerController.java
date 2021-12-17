package com.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.InvalidCredintialException;
import com.exception.IssueNotFoundException;
import com.model.Customer;
import com.model.Issue;
import com.model.Login;
import com.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class CustomerController {

	@Autowired
	CustomerService custservice;

	@PostMapping("/regCustomer")
	public ResponseEntity<Customer> regCustomer(@RequestBody Customer c) throws Throwable {
		Customer c1 = custservice.registerCustomer(c);
		ResponseEntity re = new ResponseEntity<Customer>(c1, HttpStatus.OK);
		return re;
	}
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
	List<Customer> lc = custservice.getAllCustomers();
	ResponseEntity re = new ResponseEntity<List<Customer>>(lc, HttpStatus.OK);
	return re;
	}
	@DeleteMapping(path = "/removeCustomer/{customerId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable int customerId) {
		Customer c = custservice.removeCustomer(customerId);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	@PutMapping(path="/modifyCustomer")
	public ResponseEntity<Customer> modifyCustomer(@RequestBody Customer customer){
		Customer d=custservice.modifyCustomer(customer);
		ResponseEntity re= new ResponseEntity<Customer>(d,HttpStatus.OK);
		return re;
		
	}
	@GetMapping("/getallIssues/{issueType}")
	public ResponseEntity<List<Issue>> findByissueTypeSorted(@PathVariable String issueType) {
		List<Issue> lc = custservice.viewAllIssues();
		ResponseEntity re = new ResponseEntity<List<Issue>>(lc, HttpStatus.OK);
		return re;
	}

	@GetMapping("/getIssueById/{issueId}")
	public ResponseEntity<Issue> viewIssueById(@PathVariable int issueId) throws Throwable {
		Issue c = custservice.viewIssueById(issueId);
		ResponseEntity re = new ResponseEntity<Issue>(c, HttpStatus.OK);
		return re;
	}

	@PostMapping("/login")
	public ResponseEntity<Login> login (@RequestBody Login userId) throws Throwable {
Login c=custservice.login(userId);
		ResponseEntity re = new ResponseEntity<Login>(c,HttpStatus.OK);

		return re;
	}

	@RequestMapping("/changePassword")
	public ResponseEntity<Login> changePassword(@PathVariable Login login) throws Throwable {
		Login c = custservice.changePassword(login);
		ResponseEntity re = new ResponseEntity<Login>(c, HttpStatus.OK);

		return re;
	}

	@RequestMapping("/emailPassword")
	public ResponseEntity<Customer> emailPassword(@PathVariable int customerId) throws Throwable {

		Customer c = custservice.emailPassword(customerId);
		ResponseEntity re = new ResponseEntity<Customer>(c, HttpStatus.OK);
		return re;
	}

	@RequestMapping("/forgotPassword")
	public ResponseEntity<Customer> forgotPassword(@PathVariable int customerId) throws Throwable {

		Customer c = custservice.emailPassword(customerId);
		ResponseEntity re = new ResponseEntity<Customer>(c, HttpStatus.OK);
		return re;
	}
}
