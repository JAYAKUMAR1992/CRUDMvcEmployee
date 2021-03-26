package com.jaya.spring.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="EMPLOYEE123")
public class Employee 
{
  @Id
  @Column(name="EMPID")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int empid;
  
  @Column(name="NAME")
  private String name;
  
  
  @DateTimeFormat(pattern="dd/MM/yyyy") 
  @Column(name = "JOINING_DATE", nullable = false)
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
  private LocalDate doj;

  
  @DateTimeFormat(pattern="dd/MM/yyyy") 
  @Column(name = "BIRTH_DATE", nullable = false)
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
  private LocalDate dob;

  @Column(name="ADDRESS")
  private String address;
   
  public Employee(){}

public Employee(int empid, String name, LocalDate doj, LocalDate dob, String address) {
	super();
	this.empid = empid;
	this.name = name;
	this.doj = doj;
	this.dob = dob;
	this.address = address;
}

public int getEmpid() {
	return empid;
}

public void setEmpid(int empid) {
	this.empid = empid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public LocalDate getDoj() {
	return doj;
}

public void setDoj(LocalDate doj) {
	this.doj = doj;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}
  
  
  

}