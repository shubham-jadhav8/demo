package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.ProductModel;

public interface ProductDao {
	public int addProduct(ProductModel productmodel );
	public int DeleteProductByID (long ProductId);
	public ProductModel getProductById(long ProductId);
	public int UpdateProduct( ProductModel productmodel );
	public List<ProductModel> GetallProducts();
	//public List<ProductModel> getProductInAscendingOrder();
	public List<ProductModel> getProductInAscendingOrderofPrice();
	public List<ProductModel> getProductInAscendingOrderofName();
	public ProductModel GetProductByName(String productname);
	public ArrayList<ProductModel> PriceGreaterThan(int price);
	public ProductModel ProductWithMaxPrice();
	public ArrayList<ProductModel> getProductsInPriceRange(int low, int high);
	public ArrayList<ProductModel> sortProducts(String orderType, String propertyName);
}
