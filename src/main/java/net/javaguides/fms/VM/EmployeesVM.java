package net.javaguides.fms.VM;

import java.time.Instant;

public class EmployeesVM {

	
	  private Long Id;

      private String employeeName;
	  
	  private String address;

	  private String primaryContact;
	  
	  private String secondaryContact;
	  
	  private String employeeSalaryType;
	   
	  public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getEmployeeSalaryType() {
		return employeeSalaryType;
	}

	public void setEmployeeSalaryType(String employeeSalaryType) {
		this.employeeSalaryType = employeeSalaryType;
	}

	public Instant getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Instant joiningDate) {
		this.joiningDate = joiningDate;
	}

	private Instant joiningDate;
	  
}
