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

import net.javaguides.fms.VM.CustomerAccountVM;
import net.javaguides.fms.model.CustomerAccount;
import net.javaguides.fms.services.CustomerAccountservice;


@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class CustomerAccountController {
	
	@Autowired
	private CustomerAccountservice customerAccountservice;
	
	@GetMapping("/customeraccount")
	public ResponseEntity<List <CustomerAccountVM>> getCustomerAccount() {
		List<CustomerAccount> customerAccountList = customerAccountservice.findAll();

		List<CustomerAccountVM> customeraccount = new ArrayList<CustomerAccountVM>();
		customerAccountList.stream().forEach(customerAccount ->{
			
			CustomerAccountVM CustomerAccountvm = new CustomerAccountVM();
			CustomerAccountvm.setAccountNumber(customerAccount.getAccountNumber());
			CustomerAccountvm.setGivenAmount(customerAccount.getGivenAmount());
			CustomerAccountvm.setExpectedAmount(customerAccount.getExpectedAmount());
			CustomerAccountvm.setTotalCollectedAmount(customerAccount.getTotalcollectedAmount());
			CustomerAccountvm.setBalanceAmount(customerAccount.getBalanceAmount());
			CustomerAccountvm.setCustomerId(customerAccount.getCustomerId());
			CustomerAccountvm.setInterestRate(customerAccount.getInterestRate());
			CustomerAccountvm.setInterestAmount(customerAccount.getInterestAmount());
			CustomerAccountvm.setExpectedDuration(customerAccount.getExpectedDuration());
			CustomerAccountvm.setCollectedDuration(customerAccount.getCollectedDuration());
			CustomerAccountvm.setId(customerAccount.getId());
	

			
			
			customeraccount.add(CustomerAccountvm);
			
			
		});
		return ResponseEntity.ok().body(customeraccount);
		
	}
	
	@PostMapping("/customeraccount")
	public ResponseEntity<CustomerAccount> saveCustomerAccount(@RequestBody CustomerAccountVM customerAccountVM) {
		
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setGivenAmount(customerAccountVM.getGivenAmount());
		customerAccount.setExpectedAmount(customerAccountVM.getExpectedAmount());
		customerAccount.setTotalcollectedAmount(customerAccountVM.getTotalCollectedAmount());
		customerAccount.setBalanceAmount(customerAccountVM.getBalanceAmount());
		customerAccount.setCustomerId(customerAccountVM.getCustomerId());
		customerAccount.setInterestRate(customerAccountVM.getInterestRate());
		customerAccount.setInterestAmount(customerAccountVM.getInterestAmount());
		customerAccount.setExpectedDuration(customerAccountVM.getExpectedDuration());
		customerAccount.setCollectedDuration(customerAccountVM.getCollectedDuration());
		customerAccount.setAccountNumber(customerAccountVM.getAccountNumber());

		
		
		CustomerAccount result = customerAccountservice.saveCustomerAccount(customerAccount);
	
			
		
		
	    return  ResponseEntity.ok().body(result);
		
		
	}
	

	@GetMapping("/customeraccount/search/{customerId}")
	public ResponseEntity<CustomerAccount> SearchCustomer(@PathVariable Long customerId){
		
		Optional<CustomerAccount> foundcustomerId=customerAccountservice.findBycustomerId(customerId);
		if(foundcustomerId.isPresent()){
			return ResponseEntity.ok().body(foundcustomerId.get());
			
		}
		return null;
	}
	

}
