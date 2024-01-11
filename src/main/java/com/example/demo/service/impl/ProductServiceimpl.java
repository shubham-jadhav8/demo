package com.example.demo.service.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.impl.ProductDaoImpl;
import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;

public class ProductServiceimpl implements ProductService {

	
	ProductDao dao=new ProductDaoImpl();
	
	
	@Override
	public int addProduct(ProductModel productmodel) {
		// TODO Auto-generated method stub
	
		
		//String Productid = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	
		//productmodel.setProductid(Long.parseLong(Productid));
		
		
		 java.util.Date currentDate = new java.util.Date();
		 java.sql.Date createdDate = new java.sql.Date(currentDate.getTime());

		 productmodel.setCreatedDate(createdDate);
		
		
		
		productmodel.setCreatedDate((createdDate));
		
		
		
		
		return dao.addProduct(productmodel);
	}


	@Override
	public int DeleteProductByID(long ProductId) {
		// TODO Auto-generated method stub
		return dao.DeleteProductByID(ProductId);
	}


	@Override
	public ProductModel getProductById(long ProductId) {
		// TODO Auto-generated method stub
		return dao.getProductById(ProductId);
	}


	@Override
	public int UpdateProduct(ProductModel productmodel) {
	    // TODO: Implement your update logic
		
		ProductModel dbproduct = getProductById(productmodel.getProductid());
		  
		int status=0;
		if (dbproduct!=null)
		{	
	       status=dao.UpdateProduct(productmodel);
	}
	else {   status=2;}
		
		return status;
	}
	
	@Override
	public List<ProductModel> GetallProducts() {
	
		
		
		return dao.GetallProducts();
	}


	//@Override
	//public List<ProductModel> getProductInAscendingOrder() {
		// TODO Auto-generated method stub
	//	return dao.getProductInAscendingOrder();
//	}


	@Override
	public List<ProductModel> getProductInAscendingOrderofPrice() {
		// TODO Auto-generated method stub
		 return dao.getProductInAscendingOrderofPrice();
	}


	@Override
	public List<ProductModel> getProductInAscendingOrderofName() {
		// TODO Auto-generated method stub
		 return dao.getProductInAscendingOrderofName();
	}


	@Override
	public ProductModel GetProductByName(String productname) {
		// TODO Auto-generated method stub
		return dao.GetProductByName(productname);
	}


	@Override
	public ArrayList<ProductModel> PriceGreaterThan(int price) {
		// TODO Auto-generated method stub
		return dao. PriceGreaterThan(price);
	}


	@Override
	public ProductModel ProductWithMaxPrice() {
		// TODO Auto-generated method stub
		return dao.ProductWithMaxPrice();
	}


	@Override
	public ArrayList<ProductModel> getProductsInPriceRange(int low, int high) {
		// TODO Auto-generated method stub
		return dao.getProductsInPriceRange(low ,high);
	}


	@Override
	public ArrayList<ProductModel> sortProducts(String orderType, String propertyName) {
		// TODO Auto-generated method stub
		return dao.sortProducts(orderType,propertyName);
	}


	
	
}
