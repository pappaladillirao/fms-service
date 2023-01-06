package net.javaguides.fms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import net.javaguides.fms.model.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long>{

	List<Employees> findAllByAndDeletedFalse();

	

	

}
