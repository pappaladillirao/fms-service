package net.javaguides.fms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.fms.VM.CustomerAccounthistoryVM;
import net.javaguides.fms.model.Customer;
import net.javaguides.fms.model.CustomerAccount;
import net.javaguides.fms.model.CustomerAccountHistory;
import net.javaguides.fms.services.CustomerAccounthistoryservice;
import net.javaguides.fms.services.CustomerAccountservice;
import net.javaguides.fms.services.Customerservice;


@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class CustomerAccounthistorycontroller {
	
	@Autowired
	CustomerAccounthistoryservice customerAccounthistoryservice;
	
	@Autowired
	CustomerAccountservice customerAccountservice;
	
	@Autowired
	Customerservice customerservice;
	
	
	@GetMapping("/customeraccounthistory")
	public ResponseEntity<List <CustomerAccounthistoryVM>> getCustomerAccounthistory() {
		List<CustomerAccountHistory> customerAccounthistoryList = customerAccounthistoryservice.findAll();

		List<CustomerAccounthistoryVM> CustomerAccounthistory = new ArrayList<CustomerAccounthistoryVM>();
		customerAccounthistoryList.stream().forEach(customerAccounthistory ->{
			
			CustomerAccounthistoryVM CustomerAccounthistoryvm = new CustomerAccounthistoryVM();
			
			CustomerAccounthistoryvm.setTransactionAmount(customerAccounthistory.getTransactionAmount());
			CustomerAccounthistoryvm.setDate(customerAccounthistory.getDate());
			CustomerAccounthistoryvm.setCollectedBy(customerAccounthistory.getCollectedBy());
			CustomerAccounthistoryvm.setCustomerId(customerAccounthistory.getCustomerId());
			CustomerAccounthistoryvm.setCustomerAccountId(customerAccounthistory.getCustomerAccountId());
			CustomerAccounthistoryvm.setReason(customerAccounthistory.getReason());
			CustomerAccounthistoryvm.setId(customerAccounthistory.getId());

			
			CustomerAccounthistory.add(CustomerAccounthistoryvm);
			
		});
		return ResponseEntity.ok().body(CustomerAccounthistory);
	}	
			
	
	@PostMapping("/customeraccounthistory")
	public ResponseEntity<CustomerAccountHistory> saveCustomerAccounthistory(@RequestBody CustomerAccounthistoryVM customerAccounthistoryVM) {
		
		CustomerAccountHistory customerAccounthistory = new CustomerAccountHistory();
		
		customerAccounthistory.setTransactionAmount(customerAccounthistoryVM.getTransactionAmount());
		customerAccounthistory.setDate(customerAccounthistoryVM.getDate());
		customerAccounthistory.setCollectedBy(customerAccounthistoryVM.getCollectedBy());
		customerAccounthistory.setCustomerId(customerAccounthistoryVM.getCustomerId());
		customerAccounthistory.setReason(customerAccounthistoryVM.getReason());
		customerAccounthistory.setCustomerAccountId(customerAccounthistoryVM.getCustomerAccountId());

		
		CustomerAccountHistory result = customerAccounthistoryservice.saveCustomerAccounthistory(customerAccounthistory);
	   Optional<CustomerAccount> foundCustomerAccount=customerAccountservice.findCustomerByCustomerId(result.getCustomerId());
		
	   if(foundCustomerAccount.isPresent()) {
		   CustomerAccount customerAccount=foundCustomerAccount.get();
		   if(result.getTransactionAmount()>0) {
			Double actualTotalColectedAmount=customerAccount.getTotalcollectedAmount();
			Double actualBalanceAmount=customerAccount.getBalanceAmount();
			
		
			actualTotalColectedAmount=actualTotalColectedAmount+result.getTransactionAmount();
			actualBalanceAmount=actualBalanceAmount-result.getTransactionAmount();
			
			customerAccount.setTotalcollectedAmount(actualTotalColectedAmount);
			customerAccount.setBalanceAmount(actualBalanceAmount);
			
		   }
		   
			Long actualCollectedDuration=customerAccount.getCollectedDuration();
			actualCollectedDuration=actualCollectedDuration+1;
			customerAccount.setCollectedDuration(actualCollectedDuration);
			customerAccount=customerAccountservice.saveCustomerAccount(customerAccount);
			
			if(customerAccount.getBalanceAmount()==0) {
				String review="";
			
			 if	(customerAccount.getCollectedDuration()<customerAccount.getExpectedDuration()) {
				 review="EXCELLENT";
			}
			else if
			(customerAccount.getCollectedDuration()==customerAccount.getExpectedDuration()) {
				 review="GOOD";
			}
			else if (customerAccount.getCollectedDuration()>customerAccount.getExpectedDuration() && customerAccount.getCollectedDuration()<=customerAccount.getExpectedDuration()+10) {
				 review="AVERAGE";
			}
			else {
				 review="BAD";
			}
		Optional<Customer> foundCustomer=customerservice.findById(customerAccount.getCustomerId());
		if(foundCustomer.isPresent()) {
			Customer customer=foundCustomer.get();
			customer.setCustomerReview(review);
			customer.setActive(false);
			customerservice.saveCustomer(customer);
		}
	}
	   }
		return  ResponseEntity.ok().body(result);
	}
	

}




