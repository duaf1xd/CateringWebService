package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="Request")@Entity
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="detail")
	private String detail;
		
	@Column(name="status")
	private int status;
		
	@Column(name="recycle")
	private int recycle;
	
	@Column(name="request_time")@Temporal(TemporalType.TIMESTAMP)
	private Date requestTime;
	
	@Column(name="total_price")
	private double totalPrice;
	
	@Column(name="deliver_address")
	private String deliverAd;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	private Customer customer;




public Request() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDetail() {
	return detail;
}


public String getDeliverAd() {
	return deliverAd;
}
public void setDeliverAd(String deliverAd) {
	this.deliverAd = deliverAd;
}
public int getRecycle() {
	return recycle;
}
public void setRecycle(int recycle) {
	this.recycle = recycle;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public Date getRequestTime() {
	return requestTime;
}
public void setRequestTime(Date requestTime) {
	this.requestTime = requestTime;
}


public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}




}
