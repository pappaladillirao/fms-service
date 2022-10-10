package net.javaguides.fms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="customer_account")
public class CustomerAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "Given_amount")
	private Double givenAmount;
	
	@Column(name = "Expected_amount")
	private Double expectedAmount;
	
	@Column(name = "Balance_amount")
	private Double balanceAmount;
	
	@Column(name = "Total_Collected_amount")
	private Double totalcollectedAmount;
	
	@Column(name = "CustomerId")
	private Long customerId;
	
	@Column(name = "Interest_Rate")
	private Long interestRate;
	
	@Column(name = "Interest_Amount")
	private Double interestAmount;
	
	@Column(name = "Expected_Duration")
	private Long expectedDuration;
	
	@Column(name = "Collected_Duration")
	private Long collectedDuration;
	


	
	


	public Long getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Long interestRate) {
		this.interestRate = interestRate;
	}

	public Double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(Double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public Long getExpectedDuration() {
		return expectedDuration;
	}

	public void setExpectedDuration(Long expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	public Long getCollectedDuration() {
		return collectedDuration;
	}

	public void setCollectedDuration(Long collectedDuration) {
		this.collectedDuration = collectedDuration;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Double getGivenAmount() {
		return givenAmount;
	}

	public void setGivenAmount(Double givenAmount) {
		this.givenAmount = givenAmount;
	}

	public Double getExpectedAmount() {
		return expectedAmount;
	}

	public void setExpectedAmount(Double expectedAmount) {
		this.expectedAmount = expectedAmount;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Double getTotalcollectedAmount() {
		return totalcollectedAmount;
	}

	public void setTotalcollectedAmount(Double totalcollectedAmount) {
		this.totalcollectedAmount = totalcollectedAmount;
	}

	
	

}
	
	


