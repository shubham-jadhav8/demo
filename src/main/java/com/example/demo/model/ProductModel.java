package com.example.demo.model;

import java.sql.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.lang.NonNull;

public class ProductModel {
	
	private long productid;
	
	@NotBlank(message ="product name is required" )
	 @Pattern(regexp = "[A-Za-z0-9]+", message = "Only alphanumeric characters allowed")
	private String productname;
	
	@DecimalMin(value = "0.01", message = "Product price must be greater than zero")
	private double productprice;
	
	@Min(value = 0, message = "Product quantity cannot be negative")
	private int productQty;
	
	private Date mfgDate;
	private Date expDate;
	private Date createdDate;
	
	
	
	public ProductModel(long productid, String productname, double productprice, int productQty, Date mfgDate,
			Date expDate, Date createdDate) {
		super();
		this.productid = productid;
		
	
		this.productname = productname;
		this.productprice = productprice;
		this.productQty = productQty;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.createdDate = createdDate;
	}
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public Date getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "ProductModel [productid=" + productid + ", productname=" + productname + ", productprice="
				+ productprice + ", productQty=" + productQty + ", mfgDate=" + mfgDate + ", expDate=" + expDate
				+ ", createdDate=" + createdDate + "]";
	}
	

}
