package net.javaguides.fms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.fms.VM.CustomerVM;
import net.javaguides.fms.model.Customer;
import net.javaguides.fms.services.Customerservice;

@Controller
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private Customerservice customerService;
	

	
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerVM>> getCustomers() {
		
		List<Customer> customerList = customerService.findAll();
		
		List<CustomerVM> customers = new ArrayList<CustomerVM>();
		customerList.stream().forEach(customer ->{
			
			CustomerVM customerData = new CustomerVM();
			
			customerData.setRegisterNumber(customer.getRegisterNumber());
			customerData.setCustomerName(customer.getCustomerName());
			customerData.setAddress(customer.getAddress());
			customerData.setPrimaryContact(customer.getPrimaryContact());
			customerData.setSecondaryContact(customer.getSecondaryContact());
			customerData.setCustomerType(customer.getCustomerType());
			customerData.setCustomerReview(customer.getCustomerReview());
			customerData.setActive(customer.getActive());
			
			
			
			customers.add(customerData);
		});
		return ResponseEntity.ok().body(customers);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerVM customerVM) {
		
		Customer customer = new Customer();
		customer.setRegisterNumber(customerVM.getRegisterNumber());
		customer.setCustomerName(customerVM.getCustomerName());
		customer.setAddress(customerVM.getAddress());
		customer.setPrimaryContact(customerVM.getPrimaryContact());
		customer.setSecondaryContact(customerVM.getSecondaryContact());
		customer.setCustomerType(customerVM.getCustomerType());
		customer.setCustomerReview(customerVM.getCustomerReview());
		customer.setActive(true);
		
		
		Customer result = customerService.saveCustomer(customer);
		
		
		
		
		
    return  ResponseEntity.ok().body(result);
	}
	
	


}
