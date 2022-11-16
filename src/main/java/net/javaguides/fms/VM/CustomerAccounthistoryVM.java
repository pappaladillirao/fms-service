package net.javaguides.fms.VM;

import java.time.Instant;

public class CustomerAccounthistoryVM {
	
	private Long Id;
	
	private Long customerAccountId;
	
	private Double transactionAmount;
	
	private Instant date;
	
	private String collectedBy;
	
	private String reason;
	
	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	private Long customerId;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
		
	
	}

	

	
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

   

	public String getCollectedBy() {
		return collectedBy;
	}

	public void setCollectedBy(String collectedBy) {
		this.collectedBy = collectedBy;
	}
	
	public Long getCustomerAccountId() {
		return customerAccountId;
	}

	public void setCustomerAccountId(Long customerAccountId) {
		this.customerAccountId = customerAccountId;
	}

}
