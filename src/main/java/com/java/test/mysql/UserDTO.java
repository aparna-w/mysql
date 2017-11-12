package com.java.test.mysql;

public class UserDTO {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private long phone;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public long getPhone() { return phone; }
	public void setPhone(long phone) { this.phone = phone; }
	
	@Override
	public String toString() {
		return "User [id : " + this.id + ", firstName : " + this.firstName + ", lastName : " + this.lastName + ", email : " + this.email + ", phone : " + this.phone + "]";
	}
	
}
