package net.javaguides.fms.services;


import java.util.List;
import java.util.Optional;

import net.javaguides.fms.model.Customer;

public interface Customerservice {

	void customerform(Customer customer);

	Customer saveCustomer(Customer customer);

	List<Customer> findAll();

	Optional<Customer> findById(Long customerId);

	

}
