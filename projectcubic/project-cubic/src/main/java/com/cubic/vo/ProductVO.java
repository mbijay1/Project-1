package com.cubic.vo;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductVO {
	private Long pk;
	private String activeState = "true";

	private Date activeDate;
	private String category;
	private Date createdDate;
	private Long currentQuantity;
	private String description;
	private Date inactiveDate;
	private String manufacturer;
	private Long orderedQuantity;
	private double price;
	private String productName;
	private String productNumber;
	private Long thresholdQuantity;
	private String upc;
	private String version;

	public ProductVO() {
		System.out.println("Constructor called");
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public String getCategory() {
		return category;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Long getCurrentQuantity() {
		return currentQuantity;
	}

	public Date getInactiveDate() {
		return inactiveDate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public Long getOrderedQuantity() {
		return orderedQuantity;
	}

	public Long getPk() {
		return pk;
	}

	public double getPrice() {
		return price;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public Long getThresholdQuantity() {
		return thresholdQuantity;
	}

	public String getUpc() {
		return upc;
	}

	public String getVersion() {
		return version;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setCurrentQuantity(Long currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setOrderedQuantity(Long orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public void setThresholdQuantity(Long thresholdQuantity) {
		this.thresholdQuantity = thresholdQuantity;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActiveState() {
		return activeState;
	}

	public void setActiveState(String activeState) {
		this.activeState = activeState;
	}

}
