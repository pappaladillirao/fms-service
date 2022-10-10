package net.javaguides.fms.VM;

public class CustomerAccountVM {
	
	private Double givenAmount;
	
	private Double expectedAmount;
	
	private Double totalCollectedAmount;
	
	private Double balanceAmount;
	
	private Long customerId;
	
	private Long interestRate;
	
	private Double interestAmount;
	
	private Long expectedDuration;
	
	private Long collectedDuration;
	
	
	
	

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

	public Double getTotalCollectedAmount() {
		return totalCollectedAmount;
	}

	public void setTotalCollectedAmount(Double totalCollectedAmount) {
		this.totalCollectedAmount = totalCollectedAmount;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public Long getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Long interestRate) {
		this.interestRate = interestRate;
	}
	

}
