package net.javaguides.fms.services;

import java.util.List;
import java.util.Optional;

import net.javaguides.fms.model.CustomerAccount;

public interface CustomerAccountservice {

	List<CustomerAccount> findAll();

	CustomerAccount saveCustomerAccount(CustomerAccount customerAccount);

	Optional<CustomerAccount> findCustomerByCustomerId(Long customerId);

	

	Optional<CustomerAccount> findBycustomerId(Long customerId);



}
