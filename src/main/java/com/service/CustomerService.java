package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDao;
import com.dao.IssueDao;
import com.dao.LoginDao;
import com.exception.CustomerNotFoundException;
import com.exception.DuplicateCustomerException;
import com.exception.InvalidCredintialException;
import com.exception.IssueNotFoundException;

import com.model.Customer;
import com.model.Issue;
import com.model.Login;

@Service
public class CustomerService {
	@Autowired
	CustomerDao repo;

	public Customer registerCustomer(Customer customer) throws Throwable {
		Supplier s1 = () -> new DuplicateCustomerException("Already  exist in the database");
		repo.save(customer);
		return customer;
	}
	public List<Customer> getAllCustomers(){
		List<Customer> c=repo.findAll();
		return c;
		}
	public Customer modifyCustomer(Customer customer) {
		int customerId = customer.getCustomerId();
		Optional<Customer> optional = rep.findById(customerId);
		if (optional.isPresent()) {
			Customer o = optional.get();
			o.setFirstName(customer.getFirstName());
			o.setLastName(customer.getLastName());
			o.setCustomerId(customer.getCustomerId());
			o.setEmail(customer.getEmail());
			o.setMobile(customer.getMobile());
			o.setCity(customer.getCity());
			return rep.save(o);
		}
		return null;
	}
	//delete customer
	public Customer removeCustomer(int customerId) {
		Customer c = rep.findById(customerId).get();
		rep.deleteById(customerId);
		return c;
	}
	@Autowired
	IssueDao repo1;

	public List<Issue> viewAllIssues() {
		List<Issue> lc1 = repo1.findAll();
		return lc1;
	}

	public Issue viewIssueById(int issueId) throws Throwable {
		Supplier s1 = () -> new IssueNotFoundException("Issue Does not exist in the database");
		Issue c = repo1.findById(issueId).orElseThrow(s1);
		return c;
	}

	public Issue reopenIssue(int issueId) throws Throwable {
		Supplier s1 = () -> new IssueNotFoundException("Issue Does not exist in the database");
		Issue c = repo1.findById(issueId).orElseThrow(s1);
		return c;
	}
	

	@Autowired
	LoginDao repo2;

	public Login login(Login userId) throws InvalidCredintialException

	{
		Login l=repo2.save(userId);
		;return l;
	}

	public Login changePassword(Login userName) {
		repo2.save(userName);
		return userName;
	}

	@Autowired
	CustomerDao rep;

	public Customer emailPassword(int customerId) {

		Customer c = rep.getById(customerId);
		return c;
	}

	public String forgotPassword(int customerId) {
		rep.findById(customerId);
		return "forgot password";
	}
	

}
