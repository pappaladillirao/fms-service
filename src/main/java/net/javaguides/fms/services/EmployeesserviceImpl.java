package net.javaguides.fms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.fms.model.Customer;
import net.javaguides.fms.model.Employees;
import net.javaguides.fms.repository.EmployeesRepository;


@Service
public class EmployeesserviceImpl implements Employeesservice {
	
	@Autowired
	private EmployeesRepository employeesRepository;

	@Override
	public List<Employees> findAll() {
		// TODO Auto-generated method stub
		return employeesRepository.findAllByAndDeletedFalse() ;
	}

	@Override
	public Employees saveEmployees(Employees employees) {
		// TODO Auto-generated method stub
		return employeesRepository.save(employees);
	}

	@Override
	public Optional<Employees> findById(Long id) {
		// TODO Auto-generated method stub
		return employeesRepository.findById(id);
	}

	

	

	

}
