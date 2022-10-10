package net.javaguides.fms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long Id;

@Column(name = "register_number")
  private String registerNumber;

  @Column(name = "customer_name")
  private String customerName;
  
  @Column(name = "address")
  private String address;
  
  @Column(name = "primary_contact")
  private Long  primaryContact;
  
  @Column(name = "secondary_contact")
  private Long secondaryContact;
  
  @Column(name = "customer_type")
  private String customerType;
  
  @Column(name = "customer_review")
  private String customerReview;
  
  @Column(name ="Active")
  private boolean active;
  

public long getId() {
	return Id;
}

public void setId(long id) {
	Id = id;
}

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

public Long getPrimaryContact() {
	return primaryContact;
}

public void setPrimaryContact(Long primaryContact) {
	this.primaryContact = primaryContact;
}

public Long getSecondaryContact() {
	return secondaryContact;
}

public void setSecondaryContact(Long secondaryContact) {
	this.secondaryContact = secondaryContact;
}

public String getCustomerReview() {
	return customerReview;
}

public void setCustomerReview(String customerReview) {
	this.customerReview = customerReview;
}

public boolean getActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}




  

	
}
