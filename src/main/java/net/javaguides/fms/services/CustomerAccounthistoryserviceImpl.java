package net.javaguides.fms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.fms.model.CustomerAccountHistory;
import net.javaguides.fms.repository.CustomerAccountHistoryRepository;

@Service
public class CustomerAccounthistoryserviceImpl  implements CustomerAccounthistoryservice {

	
	@Autowired
	CustomerAccountHistoryRepository customerAccounthistoryrepository;
	
	@Override
	public List<CustomerAccountHistory> findAll() {
		// TODO Auto-generated method stub
		return customerAccounthistoryrepository.findAll();
	}

	@Override
	public CustomerAccountHistory saveCustomerAccounthistory(CustomerAccountHistory customerAccounthistory) {
		// TODO Auto-generated method stub
		return customerAccounthistoryrepository.save(customerAccounthistory);
	}

}
