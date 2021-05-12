package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="Customer")@Entity
public class Customer {
@Id@GeneratedValue
private int id;
@Column(name="phone_number")
private String phoneNumber;
@Column(name="email")
private String email;
@Column(name="name")
private String name;
@Column(name="address")
private String address;
@Column(name="is_banned")
private int isBanned;
@Column(name="username")
private String username;
@Column(name="password")
private String password;
@Column(name="dob")@Temporal(TemporalType.DATE)
private Date dob;
@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
private List<Request> requests;
public Customer() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getIsBanned() {
	return isBanned;
}
public void setIsBanned(int isBanned) {
	this.isBanned = isBanned;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public List<Request> getRequest() {
	return requests;
}
public void setRequest(List<Request> requests) {
	this.requests = requests;
}





}
