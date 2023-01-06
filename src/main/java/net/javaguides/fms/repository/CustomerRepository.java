package net.javaguides.fms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.fms.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

	Optional<Customer> findByPrimaryContactAndActiveTrue(String contactNumber);

	Optional<Customer> findByPrimaryContact(String contactNumber);



}
