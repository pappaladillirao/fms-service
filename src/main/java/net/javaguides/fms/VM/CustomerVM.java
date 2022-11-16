package net.javaguides.fms.VM;



public class CustomerVM {
	
	private Long id;

     private String registerNumber;
     
	  private String customerName;
	  
	  private String address;

	  private String primaryContact;
	  
	  private String secondaryContact;
	  
	  private String customerType;
	  
	  private String customerReview;
	  
	  private boolean active;
	  
	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}



	public String getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getSecondaryContact() {
		return secondaryContact;
	}

	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}

	public String getCustomerReview() {
		return customerReview;
	}

	public void setCustomerReview(String customerReview) {
		this.customerReview = customerReview;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	  
}
