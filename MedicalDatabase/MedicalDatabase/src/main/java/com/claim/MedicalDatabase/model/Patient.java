package com.claim.MedicalDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patient_id")
	private long id;
	
	@Column(name="physician_email")
	private String docEmail;
	
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="o2_level")
	private double o2Level;
	
	@Column(name="heartbeat")
	private double heartbeat;
	
	@Column(name="role")
	private String role;
	
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getHeartbeat() {
		return heartbeat;
	}
	public void setHeartbeat(double heartbeat) {
		this.heartbeat = heartbeat;
	}

	public String getDocEmail() {
		return docEmail;
	}
	public void setDocEmail(String docEmail) {
		this.docEmail = docEmail;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}


	
	public double getO2Level() {
		return o2Level;
	}
	public void setO2Level(double o2Level) {
		this.o2Level = o2Level;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", docEmail=" + docEmail + ", lname=" + lname + ", fname=" + fname + ", o2Level="
				+ o2Level + ", heartbeat=" + heartbeat + "]";
	}
}
