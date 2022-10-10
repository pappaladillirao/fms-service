package net.javaguides.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.fms.model.CustomerAccountHistory;


@Repository
public interface CustomerAccountHistoryRepository extends JpaRepository<CustomerAccountHistory,Long> {

}
