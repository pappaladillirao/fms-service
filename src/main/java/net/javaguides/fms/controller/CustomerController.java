package net.javaguides.fms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.fms.VM.CustomerVM;
import net.javaguides.fms.model.Customer;
import net.javaguides.fms.model.CustomerAccount;
import net.javaguides.fms.services.CustomerAccountservice;
import net.javaguides.fms.services.Customerservice;

@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private Customerservice customerService;
	
	

	
	@GetMapping("/customer")
	public ResponseEntity<List<CustomerVM>> getCustomers() {
		
		List<Customer> customerList = customerService.findAll();
		
		List<CustomerVM> customerListVMs = new ArrayList<CustomerVM>();
		customerList.stream().forEach(customer ->{
			
			CustomerVM customerVM = new CustomerVM();
			
			customerVM.setRegisterNumber(customer.getRegisterNumber());
			customerVM.setCustomerName(customer.getCustomerName());
			customerVM.setAddress(customer.getAddress());
			customerVM.setPrimaryContact(customer.getPrimaryContact());
			customerVM.setSecondaryContact(customer.getSecondaryContact());
			customerVM.setCustomerType(customer.getCustomerType());
			customerVM.setCustomerReview(customer.getCustomerReview());
			customerVM.setActive(customer.getActive());
			customerVM.setId(customer.getId());
			
			
			customerListVMs.add(customerVM);
		});
		return ResponseEntity.ok().body(customerListVMs);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerVM customerVM) {
		
		Customer customer = new Customer();
		if(customerVM.getId()!= null&&customerVM.getId()!=0) {
			customer.setId(customerVM.getId());
		}
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
	
	@GetMapping("/customer/search/{contactNumber}")
	public ResponseEntity<Customer> searchCustomer(@PathVariable String contactNumber){
		
		Optional<Customer> foundCustomer=customerService.findByPrimaryContact(contactNumber);
		if(foundCustomer.isPresent()) {
			return ResponseEntity.ok().body(foundCustomer.get());
		}
		return null;
		
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> searchCustomer(@PathVariable Long id){
		
		Optional<Customer> customerView=customerService.findById(id);
		
		if(customerView.isPresent()) {
			return ResponseEntity.ok().body(customerView.get());
		}
		return null;
		
	}
	

	
	


}
