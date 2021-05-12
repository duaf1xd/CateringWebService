package entity;



import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.metamodel.source.annotations.attribute.type.LobTypeResolver;


@Table(name="Item")@Entity
public class Item {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column(name="name")
private String name;
@Column(name="description")
private String description;

@Lob
@Column(name = "image", updatable=false)
private byte[] image;

@Column(name="price")
private double price;
@Column(name="in_stock")
private int inStock;

@Column(name="unit")
private String unit;



@Column(name="imagebase")
private String imageBase;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getInStock() {
	return inStock;
}
public void setInStock(int inStock) {
	this.inStock = inStock;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}

public String getImageBase() {
	return imageBase;
}
public void setImageBase(String imageBase) {
	this.imageBase = imageBase;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
@Override
public String toString() {
	return "Item [id=" + id + ", name=" + name + ", description=" + description + ", image=" + Arrays.toString(image)
			+ ", price=" + price + ", inStock=" + inStock + ", unit=" + unit + ", imageBase=" + imageBase + "]";
}





}
