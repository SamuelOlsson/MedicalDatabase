package com.claim.MedicalDatabase.model;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="users")
public class Users {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="phone_number")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
//	@Column(name="Logged In")
//	private Boolean loggedIn;
	
	@Transient //used for validation, not to be persisted to database
	private String repeatpass;
	
	private String role;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLname() {
		return lname;
	}
//	public Boolean getLoggedIn() {
//		return loggedIn;
//	}
//	public void setLoggedIn(Boolean loggedIn) {
//		this.loggedIn = loggedIn;
//	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatpass() {
		return repeatpass;
	}
	public void setRepeatpass(String repeatpass) {
		this.repeatpass = repeatpass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", lname=" + lname + ", fname=" + fname + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}
	
}
