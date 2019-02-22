package com.abhishek.restful.webservices.restfulservice.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int empId;
	
	@Size(min=3,message="Name should be more than 3 Characters")
	private String empName;
	
	@Past
	private Date DoB=new Date();
	
	protected User(){
		
	}
	
	
	
	
	public User(int empId, String empName, Date doB) {
		super();
		this.empId = empId;
		this.empName = empName;
		DoB = doB;
	}
	
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getDoB() {
		return DoB;
	}
	public void setDoB(Date doB) {
		DoB = doB;
	}



	@Override
	public String toString() {
		return "User [empId=" + empId + ", empName=" + empName + ", DoB=" + DoB + "]";
	}

	
	
}
