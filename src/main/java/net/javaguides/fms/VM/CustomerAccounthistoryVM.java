package net.javaguides.fms.VM;

import java.time.Instant;

public class CustomerAccounthistoryVM {
	
	private Double transactionAmount;
	
	private Instant Date;
	
	private String collectedBy;
	
	private Long customerId;
	
	private String reason;

	
	
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

    public Instant getDate() {
		return Date;
	}

	public void setDate(Instant date) {
		Date = date;
	}

	public String getCollectedBy() {
		return collectedBy;
	}

	public void setCollectedBy(String collectedBy) {
		this.collectedBy = collectedBy;
	}
	

}
