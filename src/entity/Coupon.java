package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="Coupon")@Entity
public class Coupon {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column(name="code")
private String code;
@Column(name="description")
private String description;
@Column(name="rate")
private double rate;
@Column(name="min_order_price")
private double minOrderPrice;
@Column(name="max_reduction_price")
private double maxReductionPrice;

@Temporal(TemporalType.DATE)
@Column(name="expired_date")
private Date expiredDate;
@Column(name="current_usage_count")
private int currentUsageCount;
@Column(name="max_usage_count")
private int maxUsageCount;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getRate() {
	return rate;
}
public void setRate(double rate) {
	this.rate = rate;
}
public double getMinOrderPrice() {
	return minOrderPrice;
}
public void setMinOrderPrice(double minPrice) {
	this.minOrderPrice = minPrice;
}
public double getMaxReductionPrice() {
	return maxReductionPrice;
}
public void setMaxReductionPrice(double maxReductionPrice) {
	this.maxReductionPrice = maxReductionPrice;
}
public Date getExpiredDate() {
	return expiredDate;
}
public void setExpiredDate(Date expiredDate) {
	this.expiredDate = expiredDate;
}

public int getCurrentUsageCount() {
	return currentUsageCount;
}
public void setCurrentUsageCount(int currentUsageCount) {
	this.currentUsageCount = currentUsageCount;
}
public int getMaxUsageCount() {
	return maxUsageCount;
}
public void setMaxUsageCount(int maxUsageCount) {
	this.maxUsageCount = maxUsageCount;
}
@Override
public String toString() {
	return "Coupon [id=" + id + ", code=" + code + ", description=" + description + ", rate=" + rate + ", minPrice="
			+ minOrderPrice + ", maxReductionPrice=" + maxReductionPrice + ", expriredDate=" + expiredDate
			+ ", currentUsageCount=" + currentUsageCount + ", maxUsageCount=" + maxUsageCount + "]";
}



/*
 * insert into coupon (code, description, rate, min_order_price, max_reduction_price, expired_date, item_id, current_usage_count, max_usage_count) values ('vnc234', 'new year coupon', 0.4, 1, 100, DATE '2021-03-12', 1, 1, 50);
 */

}
