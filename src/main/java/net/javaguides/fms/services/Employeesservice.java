package net.javaguides.fms.services;

import java.util.List;
import java.util.Optional;

import net.javaguides.fms.model.Employees;

public interface Employeesservice {

	List<Employees> findAll();

	Employees saveEmployees(Employees employees);

	Optional<Employees> findById(Long id);





	

}
