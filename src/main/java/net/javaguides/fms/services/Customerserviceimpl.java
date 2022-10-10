package net.javaguides.fms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.fms.model.Customer;
import net.javaguides.fms.repository.CustomerRepository;

@Service
public class Customerserviceimpl implements Customerservice{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void customerform(Customer customer) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}


	@Override
	public Optional<Customer> findById(Long customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}

	

}
