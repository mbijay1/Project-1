package com.cubic.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.cubic.util.EnumClass.Category;
import com.cubic.util.EnumClass.Manufacturer;

@Entity
@XmlRootElement
@Table(name = "PRODUCT")

@NamedQueries({
		@NamedQuery(name = "QueryConstants.PRODUCT_SEARCH_BY_NAME", query = "select p from ProductEntity p where UPPER(p.productName) like UPPER(:p1)"),
		@NamedQuery(name = "QueryConstants.PRODUCT_SEARCH_BY_NUMBER", query = "select p from ProductEntity p where UPPER(p.productNumber) like UPPER(:p2)"),
		@NamedQuery(name = "QueryConstants.PRODUCT_SEARCH_BY_UPC", query = "select p from ProductEntity p where UPPER(p.upc) like UPPER(:p3)")
		// @NamedQuery(name="QueryConstants.PRODUCT_SELECT_ALL",query="select p
		// from ProductEntity p")
})

public class ProductEntity {
	@Id
	@Column(name = "PRODUCT_PK")
	@SequenceGenerator(name = "productSeq", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "productSeq")
	private Long pk;
	@Column(name = "ACTIVE_DATE")
	private Date activeDate;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "CURRENT_QUANTITY")
	private Long currentQuantity;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "INACTIVE_DATE")

	private Date inactiveDate;
	@Column(name = "MANUFACTURER")
	private String manufacturer;
	@Column(name = "ORDERED_QUANTITY")
	private Long orderedQuantity;
	@Column(name = "PRICE")
	private double price;
	@Column(name = "PRODUCTNAME")
	private String productName;
	@Column(name = "PRODUCTNUMBER")
	private String productNumber;
	@Column(name = "THRESHOLDQUANTITY")
	private Long thresholdQuantity;
	@Column(name = "UPC")
	private String upc;
	@Column(name = "VERSION")
	private String version;

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

}
