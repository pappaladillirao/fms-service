package net.javaguides.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.fms.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
