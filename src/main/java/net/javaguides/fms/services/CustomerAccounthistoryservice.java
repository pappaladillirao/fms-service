package net.javaguides.fms.services;

import java.util.List;

import net.javaguides.fms.model.CustomerAccountHistory;



public interface CustomerAccounthistoryservice {

	List<CustomerAccountHistory> findAll();

	CustomerAccountHistory saveCustomerAccounthistory(CustomerAccountHistory customerAccounthistory);

}
