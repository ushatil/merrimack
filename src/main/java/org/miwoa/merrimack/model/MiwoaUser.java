package org.miwoa.merrimack.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class MiwoaUser {
	@Id private Long id;
	@Index private String email;
	private String fullName;
	private String encrpytedPassword;
	private String role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEncrpytedPassword() {
		return encrpytedPassword;
	}
	public void setEncrpytedPassword(String encrpytedPassword) {
		this.encrpytedPassword = encrpytedPassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
