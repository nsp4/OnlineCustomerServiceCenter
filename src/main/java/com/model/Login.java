package com.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Login implements Serializable {
	
	private static final long serialVersionUID = -9168833388053422036L;
	@Id
	private int userId;
	private String username;
	private String password;
	private String role;
	private boolean isLoggedin=false;
	public Login() {}
	
	public Login(int userId, String username, String password, String role, boolean isLoggedin) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.isLoggedin = isLoggedin;
		
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isLoggedin() {
		return isLoggedin;
	}
	public void setLoggedin(boolean isLoggedin) {
		this.isLoggedin = isLoggedin;
	}
	public Login(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}
}
	
	

		
