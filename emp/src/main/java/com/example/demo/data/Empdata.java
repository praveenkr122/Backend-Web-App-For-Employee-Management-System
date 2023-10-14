package com.example.demo.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Empdata {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empid;
	@Column(name="name")
	private String empname;
	@Column(name="email")
	private String empemail;
	public Long getEmpid() {
		return empid;
	}
	public void setEmpid(Long empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	
	
	public Empdata() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Empdata(Long empid, String empname, String empemail) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empemail = empemail;
	}
	@Override
	public String toString() {
		return "Empdata [empid=" + empid + ", empname=" + empname + ", empemail=" + empemail + "]";
	}
	
}
