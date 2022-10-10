package net.javaguides.fms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.fms.VM.CustomerAccountVM;
import net.javaguides.fms.model.CustomerAccount;
import net.javaguides.fms.services.CustomerAccountservice;


@Controller
@RequestMapping("/api")
public class CustomerAccountController {
	
	@Autowired
	private CustomerAccountservice customerAccountservice;
	
	@GetMapping("/Customeraccount")
	public ResponseEntity<List <CustomerAccountVM>> getCustomerAccount() {
		List<CustomerAccount> customerAccountList = customerAccountservice.findAll();

		List<CustomerAccountVM> customeraccount = new ArrayList<CustomerAccountVM>();
		customerAccountList.stream().forEach(customerAccount ->{
			
			CustomerAccountVM CustomerAccountData = new CustomerAccountVM();
			
			CustomerAccountData.setGivenAmount(customerAccount.getGivenAmount());
			CustomerAccountData.setExpectedAmount(customerAccount.getExpectedAmount());
			CustomerAccountData.setTotalCollectedAmount(customerAccount.getTotalcollectedAmount());
			CustomerAccountData.setBalanceAmount(customerAccount.getBalanceAmount());
			CustomerAccountData.setCustomerId(customerAccount.getCustomerId());
			CustomerAccountData.setInterestRate(customerAccount.getInterestRate());
			CustomerAccountData.setInterestAmount(customerAccount.getInterestAmount());
			CustomerAccountData.setExpectedDuration(customerAccount.getExpectedDuration());
			CustomerAccountData.setCollectedDuration(customerAccount.getCollectedDuration());
			

			
			
			customeraccount.add(CustomerAccountData);
			
			
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
		

		
		
		CustomerAccount result = customerAccountservice.saveCustomerAccount(customerAccount);
	
			
		
		
	    return  ResponseEntity.ok().body(result);
		
		
	}
	

}
