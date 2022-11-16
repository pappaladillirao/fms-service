package net.javaguides.fms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.fms.model.CustomerAccount;


@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount,Long> {

  Optional<CustomerAccount> findByCustomerId(Long customerId);

}
