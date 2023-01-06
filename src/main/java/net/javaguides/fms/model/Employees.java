package net.javaguides.fms.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="employees")
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column(name = "employee_name")
	  private String employeeName;
	
	@Column(name = "address")
	  private String address;
	
	@Column(name = "primary_contact")
	  private String  primaryContact;
	  
	@Column(name = "secondary_contact")
	  private String secondaryContact;
	  
	  @Column(name = "employee_salary_type")
	  private String employeeSalaryType;
	  
	 
	 @Column(name = "joining_Date")
	 private Instant joiningDate;
	 
	 @Column(name = "Deleted")
	 private Boolean deleted;
	  
	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
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


	
	
	
	

}
