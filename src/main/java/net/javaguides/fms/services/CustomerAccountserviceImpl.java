package net.javaguides.fms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.fms.model.CustomerAccount;
import net.javaguides.fms.repository.CustomerAccountRepository;




@Service
public class CustomerAccountserviceImpl implements CustomerAccountservice{
	
	@Autowired
	CustomerAccountRepository customerAccountRepository;

	@Override
	public List<CustomerAccount> findAll() {
		// TODO Auto-generated method stub
		return customerAccountRepository.findAll();
	}

	@Override
	public CustomerAccount saveCustomerAccount(CustomerAccount customerAccount) {
		// TODO Auto-generated method stub
		return customerAccountRepository.save(customerAccount);
	}

	@Override
	public Optional<CustomerAccount> findCustomerByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return customerAccountRepository.findByCustomerId(customerId);
	}

	
	

}
